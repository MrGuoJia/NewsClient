package com.example.jia.newsclient.activity.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import com.example.jia.newsclient.R;
import com.example.jia.newsclient.activity.baseClass.BaseActivity;
import com.example.jia.newsclient.activity.cn.sharesdk.onekeyshare.OnekeyShare;

public class CollectionNewsShowActivity extends BaseActivity {
    private Toolbar news_show_toolbar;
    private WebView news_show_webView;
    private ImageView img_return;
    private ImageView setting_size;
    private WebSettings settings;
    private ImageView img_share_to;
    private int choose=-1;
    private String tittle_to_share="";
    private String tittle_url_to_share="";
    @Override
    public int getLayoutRes() {
        return R.layout.activity_collection_news_show;
    }

    @Override
    public void initView() {
        news_show_toolbar= (Toolbar) findViewById(R.id.news_show_toolbar);
        news_show_webView= (WebView) findViewById(R.id.news_show_webView);
        img_return= (ImageView) findViewById(R.id.img_return);
        setting_size= (ImageView) findViewById(R.id.img_setting_size);
        img_share_to= (ImageView) findViewById(R.id.img_share_to);
        settings=news_show_webView.getSettings();
        settings.setSupportZoom(true);
        initWebView();
        clickEvent();
    }

    private void clickEvent() {
        setting_size.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String items[]= {"大号字体","中号字体","小号字体"};
                AlertDialog.Builder builder=new AlertDialog.Builder(CollectionNewsShowActivity.this);
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
        img_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        img_share_to.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OnekeyShare oks = new OnekeyShare();
                oks.setTitle(tittle_to_share);
                oks.setTitleUrl(tittle_url_to_share);

                oks.show(CollectionNewsShowActivity.this);
            }
        });
    }

    private void initWebView() {
        Intent i=getIntent();
        String list_tittle=i.getStringExtra("list_tittle");
        String list_tittle_url=i.getStringExtra("list_tittle_url");
        tittle_to_share=list_tittle;
        tittle_url_to_share=list_tittle_url;
        news_show_toolbar.setTitle(list_tittle);
        news_show_webView.getSettings().setJavaScriptEnabled(true);
        news_show_webView.loadUrl(list_tittle_url);
        news_show_webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
