package com.example.jia.newsclient.activity.fragment;

import android.content.Intent;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.example.jia.newsclient.R;
import com.example.jia.newsclient.activity.activity.NewsDetailActivity;
import com.example.jia.newsclient.activity.adapter.NewsAdapter;
import com.example.jia.newsclient.activity.baseClass.BaseFragment;
import com.example.jia.newsclient.activity.bean.NewsEntity;
import com.example.jia.newsclient.activity.manager.URLManager;
import com.google.gson.Gson;
import com.liaoinstan.springview.container.DefaultFooter;
import com.liaoinstan.springview.container.DefaultHeader;
import com.liaoinstan.springview.widget.SpringView;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jia on 2017/6/27.*/



public class NewsFragment extends BaseFragment {
    private String channelId;
    private ListView listView;
    private SpringView springView;
    private View headerView;
    private NewsAdapter newsAdapter;
    private List<NewsEntity.ResultBean> listDatas=new ArrayList<>();
    private int pageNo=1;

    public void setChannelId(String channelId){
        this.channelId=channelId;
    }
    @Override
    protected void initData() {


        getNewsDatas(true);
    }






    @Override
    protected void initListen() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int index=position;
                if(listView.getHeaderViewsCount()>0){
                    index=index-1;
                }
                NewsEntity.ResultBean newsBean = listDatas.get(index);

                Intent intent = new Intent(activity, NewsDetailActivity.class);
                intent.putExtra("news", newsBean);
                startActivity(intent);

            }
        });
    }

    private void getNewsDatas( final boolean refresh) {
        if(refresh){
            pageNo=1;
            String newsUrl = URLManager.getUrl(channelId, pageNo);
           // String url= URLManager.getUrl(channelId);
            HttpUtils utils=new HttpUtils();
            utils.send(HttpRequest.HttpMethod.GET, newsUrl, new RequestCallBack<String>() {
                @Override
                public void onSuccess(ResponseInfo<String> responseInfo) {
                    String json=responseInfo.result;
                    json =  json.replace(channelId, "result");
                    Gson gson = new Gson();
                    NewsEntity newsEntity = gson.fromJson(json, NewsEntity.class);
                    int count=newsEntity.getResult().size();

                    listDatas=newsEntity.getResult();

                    if(refresh){
                        showListView(listDatas);
                    }else {
                        newsAdapter.appendDatas(listDatas);
                    }
                    pageNo++;
                    springView.onFinishFreshAndLoad();
                   // showDatas(newsDatas);
                }
                @Override
                public void onFailure(HttpException error, String msg) {
                    error.printStackTrace();
                }
            });
        }
    }

    private void showListView(List<NewsEntity.ResultBean> listDatas) {
        if (listView.getHeaderViewsCount() > 0) {
            listView.removeHeaderView(headerView);
        }

        // 第一条新闻
        NewsEntity.ResultBean firstNews = listDatas.get(0);
        // 有轮播图
        if (firstNews.getAds() != null && firstNews.getAds().size() > 0) {
            headerView = LayoutInflater.from(getContext()).inflate(R.layout
                    .list_header, listView, false);

            // 查找轮播图控件
            SliderLayout sliderLayout = (SliderLayout)
                    headerView.findViewById(R.id.slider_layout);
            // 准备轮播图要显示的数据
            List<NewsEntity.ResultBean.AdsBean> ads = firstNews.getAds();
            // 添加轮播图子界面
            for (int i = 0; i < ads.size(); i++) {
                NewsEntity.ResultBean.AdsBean bean = ads.get(i);

                // 一个TextSliderView表示一个子界面
                TextSliderView  textSliderView = new TextSliderView(getContext());
                textSliderView.description(bean.getTitle())  // 显示标题
                        .image(bean.getImgsrc());      // 显示图片

                sliderLayout.addSlider(textSliderView);       // 添加一个子界面
            }

            // 添加到轮播图到列表的头部
            listView.addHeaderView(headerView);

        } else {
            // 没有轮播图的情况
        }
        newsAdapter.setDatas(listDatas);
    }

    @Override
    protected void initView() {
        listView= (ListView) super.mRoot.findViewById(R.id.listView);

        newsAdapter=new NewsAdapter(getContext(),null);
        listView.setAdapter(newsAdapter);
        initSpringView();
    }

    private void initSpringView() {
        springView= (SpringView) super.mRoot.findViewById(R.id.springView);
        springView.setHeader(new DefaultHeader(getContext()));
        springView.setFooter(new DefaultFooter(getContext()));
        springView.setType(SpringView.Type.FOLLOW);
        springView.setListener(new SpringView.OnFreshListener(){

            @Override
            public void onRefresh() { //下拉刷新
                getNewsDatas(true);
            }

            @Override
            public void onLoadmore() { //上拉加载
                getNewsDatas(false);
            }
        });
    }



    @Override
    public int getLayoutRes() {
        return R.layout.fragment_news;
    }

}
