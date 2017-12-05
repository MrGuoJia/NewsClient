package com.example.jia.newsclient.activity.activity;

import android.animation.Animator;
import android.content.Intent;
import android.media.MediaPlayer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.jia.newsclient.R;
import com.example.jia.newsclient.activity.baseClass.BaseActivity;

/**
 * Created by jia on 2017/6/26.
 */

public  class GuideActivity  extends BaseActivity {
    private ImageView img;
    private Button btnGo;
    private int index=0;
    private Boolean isExit=false;
    private MediaPlayer mediaPlayer;
    private int[] imagesArray = new int[] {
            R.drawable.ad_new_version1_img1,
            R.drawable.ad_new_version1_img2,
            R.drawable.ad_new_version1_img3,
            R.drawable.ad_new_version1_img4,
            R.drawable.ad_new_version1_img5,
            R.drawable.ad_new_version1_img6,
            R.drawable.ad_new_version1_img7,
    };
    @Override
    public int getLayoutRes() {
        return R.layout.activity_guide;
    }

    @Override
    public void initView() {
        img = (ImageView) findViewById(R.id.iv_01);
        btnGo = (Button) findViewById(R.id.btn_go);
    }
    @Override
    public void initListener() {
        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enterMainActivity();
            }
        });
    }

    private void enterMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void initData() {
        startAnimation();
    }

    private void startAnimation() {
        index++;
        index=index % imagesArray.length;

        img.setBackgroundResource(imagesArray[index]);
        index++;
        img.setScaleX(1.0f);
        img.setScaleY(1.0f);
        img.animate()
                .scaleX(1.2f)
                .scaleY(1.2f)
                .setDuration(3000)
                .setListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                            if(!isExit){
                                startAnimation();
                            }
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                }).start();

    }

    @Override
    protected void onStart() {
        super.onStart();
        playBGMusic();
    }

    private void playBGMusic() {
        mediaPlayer=new MediaPlayer().create(this,R.raw.new_version);
        mediaPlayer.setVolume(1.0f,1.0f);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        isExit=true;
        stopMusic();
    }

    private void stopMusic() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}
