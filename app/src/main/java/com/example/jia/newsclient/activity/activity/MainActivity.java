package com.example.jia.newsclient.activity.activity;


import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioGroup;

import com.example.jia.newsclient.R;
import com.example.jia.newsclient.activity.baseClass.BaseActivity;
import com.example.jia.newsclient.activity.fragment.FragmentMain01;
import com.example.jia.newsclient.activity.fragment.FragmentMain02;
import com.example.jia.newsclient.activity.fragment.FragmentMain03;
import com.example.jia.newsclient.activity.fragment.FragmentMain04;
import com.example.jia.newsclient.activity.fragment.FragmentMain05;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.Bmob;
import cn.sharesdk.framework.ShareSDK;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

public class MainActivity extends BaseActivity {
    private RadioGroup radioGroup;
    private ViewPager viewPager;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;
    private Toolbar toolbar;
    private  NavigationView navigationView;

    @Override
    public int getLayoutRes() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {

        radioGroup= (RadioGroup) findViewById(R.id.rg_01);
        initViewPager();
        initNavigation();
        initToolbar();
        initDrawerLayout();
    }

    private void initDrawerLayout() {
        toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,0,  0);

        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();
    }

    private void initToolbar() {
         toolbar= (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        //toolbar.setLogo(R.drawable.logo);
        toolbar.setTitle("网易新闻");
        //toolbar.setSubtitle("网易新闻");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setTitleTextColor(Color.RED);
        toolbar.setSubtitleTextColor(Color.WHITE);

        //toolbar.setNavigationContentDescription(R.drawable.btn);
        toolbar.setNavigationOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(navigationView);

            }
        });


    }

    private void initNavigation() {
        drawerLayout= (DrawerLayout) findViewById(R.id.drawerLayout);
        navigationView= (NavigationView) findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.item_01:
                        Intent i=new Intent(MainActivity.this,CollectionActivity.class);
                        startActivity(i);
                        showToast("-------");
                        break;
                }
                drawerLayout.closeDrawers();
                return false;
            }
        });
    }

    private void initViewPager() {
        viewPager= (ViewPager) findViewById(R.id.view_pager);
        final List<Fragment> fragments = new ArrayList<>();
        fragments.add(new FragmentMain01());
        fragments.add(new FragmentMain02());
        fragments.add(new FragmentMain03());
        fragments.add(new FragmentMain04());
        fragments.add(new FragmentMain05());
        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        });
    }

    @Override
    public void initListener() {
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId){
                    case R.id.rb_01:
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.rb_02:
                        viewPager.setCurrentItem(1);
                        break;
                    case R.id.rb_03:
                        viewPager.setCurrentItem(2);
                        break;
                    case R.id.rb_04:
                        viewPager.setCurrentItem(3);
                        break;
                    case R.id.rb_05:
                        viewPager.setCurrentItem(4);
                        break;
                }
            }
        });

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        radioGroup.check(R.id.rb_01);
                        break;
                    case 1:
                        radioGroup.check(R.id.rb_02);
                        break;
                    case 2:
                        radioGroup.check(R.id.rb_03);
                        break;
                    case 3:
                        radioGroup.check(R.id.rb_04);
                        break;
                    case 4:
                        radioGroup.check(R.id.rb_05);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void initData() {
        Bmob.initialize(this, "31111c8e8a4a02b36b61f26e782e6ab0");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_option,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.item_tittle:
                showToast("item01");

                break;
            case R.id.item_tittle2:
                showToast("item02");
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        JCVideoPlayer.releaseAllVideos();
    }
}
