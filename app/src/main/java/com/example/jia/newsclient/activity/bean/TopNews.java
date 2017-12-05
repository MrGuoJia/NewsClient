package com.example.jia.newsclient.activity.bean;

import java.io.Serializable;

import cn.bmob.v3.BmobObject;

/**
 * Created by jia on 2017/6/28.
 */

public class TopNews extends BmobObject {
    private String news_url;

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    private String tittle;
    public String getNews_url() {
        return news_url;
    }

    public void setNews_url(String news_url) {
        this.news_url = news_url;
    }
}
