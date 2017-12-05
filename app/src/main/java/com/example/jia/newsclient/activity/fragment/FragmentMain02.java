package com.example.jia.newsclient.activity.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.jia.newsclient.R;
import com.example.jia.newsclient.activity.adapter.VideoAdapter;
import com.example.jia.newsclient.activity.baseClass.BaseFragment;
import com.example.jia.newsclient.activity.bean.VideoEntity;
import com.example.jia.newsclient.activity.manager.URLManager;
import com.google.gson.Gson;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;

/**
 * Created by jia on 2017/6/27.
 */

public class FragmentMain02 extends BaseFragment {
    @Override
    protected void initData() {
        getVideoDatas();
    }

    private void getVideoDatas() {
        new HttpUtils().send(HttpRequest.HttpMethod.GET, URLManager.VideoURL, new RequestCallBack<String>() {

            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
                String json=responseInfo.result;
                json=json.replace("V9LG4B3A0", "result");
                Gson gson=new Gson();
                VideoEntity newsDatas=gson.fromJson(json,VideoEntity.class);
              //  Log.e("===","-"+newsDatas.getResult().get(0).getMp4Hd_url().toString());
                showDatas(newsDatas);
            }

            @Override
            public void onFailure(HttpException error, String msg) {
                error.printStackTrace();
            }
        });
    }

    private void showDatas(VideoEntity newsDatas) {
        RecyclerView recyclerView= (RecyclerView) mRoot.findViewById(R.id.video_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(activity));
        recyclerView.setAdapter(new VideoAdapter(activity,newsDatas.getResult()));
    }

    @Override
    protected void initListen() {

    }

    @Override
    protected void initView() {

    }

    @Override
    public int getLayoutRes() {
        return R.layout.fragment_02;
    }
}
