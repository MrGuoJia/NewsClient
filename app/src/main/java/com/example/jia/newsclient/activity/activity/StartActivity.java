package com.example.jia.newsclient.activity.activity;

import android.content.Intent;
import android.os.SystemClock;

import com.example.jia.newsclient.R;
import com.example.jia.newsclient.activity.baseClass.BaseActivity;
import com.example.jia.newsclient.activity.util.SharePrefUtil;

/**
 * Created by jia on 2017/6/26.
 */

public class StartActivity extends BaseActivity {
    @Override
    public int getLayoutRes() {
        return R.layout.activity_start;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {
        new Thread() {
            public void run() {
                SystemClock.sleep(1500);

                boolean firstRun= SharePrefUtil.getBoolean(getApplicationContext(),"firstRun",true);
                if(firstRun){
                    SharePrefUtil.saveBoolean(StartActivity.this,"firstRun",false);
                    enterGuideActivity();
                }else {
                    enterMainActivity();
                }

            }
        }.start();
    }

    private void enterMainActivity() {
        Intent intent =new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
    }

    private void enterGuideActivity() {
        Intent intent = new Intent(this, GuideActivity.class);
        startActivity(intent);
        finish();
    }

}
