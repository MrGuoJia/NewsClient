package com.example.jia.newsclient.activity.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.example.jia.newsclient.R;
import com.example.jia.newsclient.activity.baseClass.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jia on 2017/6/27.
 */

public class FragmentMain01 extends BaseFragment {
    private ViewPager viewPager;
    private TabLayout tabLayout;
    //http://c.m.163.com/nc/article/headline/T1348647909107/0-20.html
    @Override
    protected void initData() {
        initViewPager();
    }

    @Override
    protected void initListen() {

    }

    @Override
    protected void initView() {
        viewPager = (ViewPager) super.mRoot.findViewById(R.id.view_pager_02);
        tabLayout = (TabLayout) super.mRoot.findViewById(R.id.tab_layout);
        initViewPager();
    }

    private void initViewPager() {
        final String[] titles = new String[] {
                "头条", "社会", "科技", "财经", "体育", "汽车"
        };
        final String[] channelId = new String[] {
                "T1348647909107",
                "T1348648037603",
                "T1348649580692",
                "T1348648756099",
                "T1348649079062",
                "T1348654060988",
        };

        final List<Fragment> fragments=new ArrayList<>();
        for(int i=0;i<titles.length;i++){
            NewsFragment fragment=new NewsFragment();
            fragment.setChannelId(channelId[i]);
            fragments.add(fragment);
        }
        viewPager.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return titles[position];
            }
        });
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.fragment_01;
    }
}
