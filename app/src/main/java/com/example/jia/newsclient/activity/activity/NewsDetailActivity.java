package com.example.jia.newsclient.activity.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Parcelable;
import android.preference.DialogPreference;
import android.support.v7.app.AlertDialog;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import android.widget.ImageView;
import android.widget.ProgressBar;
import com.example.jia.newsclient.R;
import com.example.jia.newsclient.activity.baseClass.BaseActivity;
import com.example.jia.newsclient.activity.bean.NewsEntity;
import com.example.jia.newsclient.activity.bean.TopNews;
import com.example.jia.newsclient.activity.cn.sharesdk.onekeyshare.OnekeyShare;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;


/**
 * Created by jia on 2017/6/28.
 */

public class NewsDetailActivity extends BaseActivity {
    private WebView webView;
    private ProgressBar progressBar;

    private ImageView img_collection;
    private ImageView img_setting;
    private ImageView img_collection_box;
    private ImageView img_share;
    private int choose=-1;
    private NewsEntity.ResultBean bean;
    private WebSettings settings;
    private List<TopNews> newsList = new ArrayList<>();

    @Override
    public int getLayoutRes() {
        return R.layout.activity_news_detail;
    }

    @Override
    public void initView() {
        webView= (WebView) findViewById(R.id.web_view);
        progressBar= (ProgressBar) findViewById(R.id.pb_01);
        img_collection= (ImageView) findViewById(R.id.img_collection);
        img_setting= (ImageView) findViewById(R.id.img_setting);
        img_collection_box= (ImageView) findViewById(R.id.img_collection_box);
        img_share= (ImageView) findViewById(R.id.img_share);
        settings=webView.getSettings();
        settings.setSupportZoom(true);
        initWebView();
    }

    private void initWebView() {
        Intent i=getIntent();
        bean= (NewsEntity.ResultBean) i.getSerializableExtra("news");
        String news_url=bean.getUrl();
        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(news_url);
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        webView.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                if(newProgress==100){
                    progressBar.setVisibility(View.VISIBLE);
                    progressBar.setProgress(newProgress);
                }
                super.onProgressChanged(view, newProgress);
            }
        });
    }

    @Override
    public void initListener() {
        img_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OnekeyShare oks = new OnekeyShare();
                oks.setTitle(bean.getTitle());
                oks.setTitleUrl(bean.getUrl());
                oks.setUrl(bean.getUrl());
                oks.show(NewsDetailActivity.this);

            }
        });


        img_collection_box.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder=new AlertDialog.Builder(NewsDetailActivity.this);
                builder.setMessage("是否查看收藏夹？");
                builder.setTitle("提示");
                builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(NewsDetailActivity.this,CollectionActivity.class));
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



        img_collection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder=new AlertDialog.Builder(NewsDetailActivity.this);
                builder.setMessage("是否收藏？");
                builder.setTitle("提示");
                builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        TopNews topNews=new TopNews();
                        topNews.setTittle(bean.getTitle());
                        topNews.setNews_url(bean.getUrl());
                        topNews.save(new SaveListener<String>() {
                            @Override
                            public void done(String s, BmobException e) {
                                if(e==null){
                                    showToast("收藏成功");
                                }else {
                                    showToast("收藏失败");
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
        img_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String items[]= {"大号字体","中号字体","小号字体"};
                AlertDialog.Builder builder=new AlertDialog.Builder(NewsDetailActivity.this);
                builder.setTitle("字体设置");
                builder.setSingleChoiceItems(items, choose, new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        choose=which;
                    }
                });
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (choose){
                            case 0:
                                settings.setTextSize(WebSettings.TextSize.LARGEST);

                                break;
                            case 1:
                                settings.setTextSize(WebSettings.TextSize.NORMAL);

                                break;
                            case 2:
                                settings.setTextSize(WebSettings.TextSize.SMALLER);

                                break;
                        }
                    }
                });
                builder.setNegativeButton("取消",new DialogInterface.OnClickListener(){

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
    public void initData() {

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(bean.getTitle());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home){
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

