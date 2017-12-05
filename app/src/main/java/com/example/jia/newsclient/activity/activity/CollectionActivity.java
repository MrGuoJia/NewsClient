package com.example.jia.newsclient.activity.activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.example.jia.newsclient.R;
import com.example.jia.newsclient.activity.adapter.CollectionAdapter;
import com.example.jia.newsclient.activity.baseClass.BaseActivity;
import com.example.jia.newsclient.activity.bean.TopNews;
import com.example.jia.newsclient.activity.fragment.NewsFragment;
import com.example.jia.newsclient.activity.listener.MyOnItemClickListener;
import com.example.jia.newsclient.activity.listener.MyOnItemLongClickListener;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.UpdateListener;

public class CollectionActivity extends BaseActivity {
    private RecyclerView recyclerView;
    private List<TopNews> newsList=new ArrayList<>();
    private CollectionAdapter collectionAdapter;
    private Toolbar collectionToolbar;
    @Override
    public int getLayoutRes() {
        return R.layout.activity_collection;

    }

    @Override
    public void initView() {
        recyclerView= (RecyclerView) findViewById(R.id.recycler_view);
        collectionToolbar= (Toolbar) findViewById(R.id.collection_toolbar);

    }

    private void initAdapter() {

        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        collectionAdapter=new CollectionAdapter(newsList,this);
        recyclerView.setAdapter(collectionAdapter);
        collectionAdapter.setOnItemClickListener(new MyOnItemClickListener() {
            @Override
            public void OnItemClickListener(View view, int position) {

                Intent i=new Intent(CollectionActivity.this,CollectionNewsShowActivity.class);
                 i.putExtra("list_tittle",newsList.get(position).getTittle());
                 i.putExtra("list_tittle_url",newsList.get(position).getNews_url());
                 startActivity(i);
                 finish();
            }
        });

        collectionAdapter.setOnItemLongClickListener(new MyOnItemLongClickListener() {
            @Override
            public void OnItemLongClickListener(View view, final int position) {

                final int index=position;
                AlertDialog.Builder builder=new AlertDialog.Builder(CollectionActivity.this);
                builder.setMessage("是否删除此收藏？");
                builder.setTitle("提示");
                builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                            TopNews topNews=newsList.get(index);
                            topNews.delete(new UpdateListener() {
                                @Override
                                public void done(BmobException e) {
                                    if(e==null){
                                        newsList.remove(index);
                                        collectionAdapter.setDataChange(newsList);
                                        initAdapter();
                                        showToast("成功删除");
                                    }
                                }
                            });

                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        showToast("取消");
                    }
                });
                builder.create().show();



            }
        });
    }

    @Override
    public void initListener() {


    }

    @Override
    public void initData() {
        getMessageFromBmob();
        collectionToolbar.setTitle("我的收藏夹");
    }

    private void getMessageFromBmob() {
        newsList.clear();
        BmobQuery<TopNews> bmobQuery=new BmobQuery<TopNews>();
        bmobQuery.setLimit(50);
        bmobQuery.findObjects(new FindListener<TopNews>() {
            @Override
            public void done(List<TopNews> list, BmobException e) {
                if(e==null){
                    newsList=list;
                    initAdapter();
                    showToast("查询成功:共"+list.size()+"条数据");

                }else {
                    showToast("加载失败");
                }
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home){
            startActivity(new Intent(CollectionActivity.this, NewsFragment.class));
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
