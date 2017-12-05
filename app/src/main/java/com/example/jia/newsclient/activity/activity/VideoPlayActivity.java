package com.example.jia.newsclient.activity.activity;

import android.media.MediaPlayer;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.VideoView;

import com.example.jia.newsclient.R;
import com.example.jia.newsclient.activity.baseClass.BaseActivity;

/**
 * Created by jia on 2017/6/29.
 */

public class VideoPlayActivity extends BaseActivity {
    private VideoView videoView;
    private ProgressBar progressBar;
    @Override
    public int getLayoutRes() {
        return R.layout.activity_video_play;
    }

    @Override
    public void initView() {
        videoView= (VideoView) findViewById(R.id.video_view);
        progressBar= (ProgressBar) findViewById(R.id.pb_video);
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {
        String videoUrl=getIntent().getStringExtra("video_url");
        //showToast(videoUrl);
        videoView.setVideoPath(videoUrl);
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoView.start();
                progressBar.setVisibility(View.GONE);

            }
        });
    }
}
