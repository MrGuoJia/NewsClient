package com.example.jia.newsclient.activity.baseClass;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * Created by jia on 2017/6/27.
 */

public abstract class BaseFragment extends Fragment{
    public View mRoot;
    public Activity activity;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity=getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(mRoot==null){
            mRoot=LayoutInflater.from(activity).inflate(getLayoutRes(),container,false);
            initView();
            initListen();
            initData();
        }

        return mRoot;
    }

    protected abstract void initData();

    protected abstract void initListen();

    protected abstract void initView();

    public abstract int getLayoutRes() ;
    private Toast mToast;

    public void showToast(String msg) {
        if (mToast == null) {
            mToast = Toast.makeText(activity, "", Toast.LENGTH_SHORT);
        }
        mToast.setText(msg);
        mToast.show();
    }
}
