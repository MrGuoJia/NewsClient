package com.example.jia.newsclient.activity.baseClass;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * Created by jia on 2017/6/26.
 */

public abstract class BaseActivity  extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutRes());

        initView();
        initListener();
        initData();
    }
    public abstract int getLayoutRes();
    public abstract void initView();
    public abstract void initListener();
    public abstract void initData();

    private Toast mToast;

    public void showToast(String msg) {
        if (mToast == null) {
            mToast = Toast.makeText(this, "", Toast.LENGTH_SHORT);
        }
        mToast.setText(msg);
        mToast.show();
    }
}
