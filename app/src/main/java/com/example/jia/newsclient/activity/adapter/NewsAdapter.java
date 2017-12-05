package com.example.jia.newsclient.activity.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jia.newsclient.R;
import com.example.jia.newsclient.activity.bean.NewsEntity;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by jia on 2017/6/27.
 */

public class NewsAdapter extends BaseAdapter {
    private Context context;
    private List<NewsEntity.ResultBean> listDatas;
    private static final int ITEM_TYPE_WITH_1_IMAGE = 0;
    private static final int ITEM_TYPE_WITH_3_IMAGE = 1;

    public NewsAdapter(Context context,List<NewsEntity.ResultBean> listDatas){
        this.context=context;
        this.listDatas=listDatas;
    }
    @Override
    public int getCount() {
        if(listDatas==null){
            return 0;
        }
        return listDatas.size();
    }

    @Override
    public Object getItem(int position) {
        return listDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        NewsEntity.ResultBean info= (NewsEntity.ResultBean) getItem(position);
        int itemViewType=getItemViewType(position);
        if(itemViewType==ITEM_TYPE_WITH_1_IMAGE){
            if(convertView==null){
                convertView=View.inflate(context, R.layout.item_news_1,null);
            }
            ImageView ivIcon = (ImageView) convertView.findViewById(R.id.iv_icon);
            TextView tvTitle = (TextView) convertView.findViewById(R.id.tv_title);
            TextView tvSource = (TextView) convertView.findViewById(R.id.tv_source);
            TextView tvComment = (TextView) convertView.findViewById(R.id.tv_comment);

            tvTitle.setText(info.getTitle());
            tvSource.setText(info.getSource());
            tvComment.setText(info.getReplyCount()+ "跟帖");
            Picasso.with(context).load(info.getImgsrc()).into(ivIcon);
        }
        else if(itemViewType==ITEM_TYPE_WITH_3_IMAGE){
            if(convertView==null){
                convertView=View.inflate(context,R.layout.item_news_2,null);
            }
            TextView tvTitle= (TextView) convertView.findViewById(R.id.tv_title);
            TextView tvComment= (TextView) convertView.findViewById(R.id.tv_comment);
            ImageView iv01 = (ImageView) convertView.findViewById(R.id.iv_01);
            ImageView iv02 = (ImageView) convertView.findViewById(R.id.iv_02);
            ImageView iv03 = (ImageView) convertView.findViewById(R.id.iv_03);
            tvTitle.setText(info.getTitle());
            tvComment.setText(info.getReplyCount()+"跟帖");

            Picasso.with(context).load(info.getImgsrc()).into(iv01);
            Picasso.with(context).load(info.getImgextra().get(0).getImgsrc())
                    .into(iv02);
            Picasso.with(context).load(info.getImgextra().get(1).getImgsrc())
                    .into(iv03);
        }
        return convertView;
    }

    @Override
    public int getItemViewType(int position) {
        NewsEntity.ResultBean item= (NewsEntity.ResultBean) getItem(position);
        if(item.getImgextra()==null || item.getImgextra().size()==0){
            return ITEM_TYPE_WITH_1_IMAGE;
        }else {
            return super.getItemViewType(position);
        }

    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    public void setDatas(List<NewsEntity.ResultBean> listDatas) {
        this.listDatas=listDatas;
        notifyDataSetChanged();
    }

    public void appendDatas(List<NewsEntity.ResultBean> listDatas) {
        this.listDatas.addAll(listDatas);
        notifyDataSetChanged();
    }
}
