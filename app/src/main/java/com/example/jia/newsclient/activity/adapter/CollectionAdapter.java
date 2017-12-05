package com.example.jia.newsclient.activity.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jia.newsclient.R;
import com.example.jia.newsclient.activity.bean.TopNews;
import com.example.jia.newsclient.activity.listener.MyOnItemClickListener;
import com.example.jia.newsclient.activity.listener.MyOnItemLongClickListener;

import java.util.List;

/**
 * Created by jia on 2017/6/28.
 */

public class CollectionAdapter extends RecyclerView.Adapter<CollectionAdapter.ViewHolder> {
    private List<TopNews> newsList;
    private MyOnItemClickListener itemClickListener;
    private MyOnItemLongClickListener itemLongClickListener;
    private Context context;
    public CollectionAdapter (List<TopNews> newsList,Context context){
        this.newsList=newsList;
        this.context=context;
    }
    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView tv_tittle_news;
        public ViewHolder(View itemView) {
            super(itemView);
            tv_tittle_news= (TextView) itemView.findViewById(R.id.tv_tittle_news);
        }
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
            TopNews topNews=newsList.get(position);
            holder.tv_tittle_news.setText(topNews.getTittle());
           /*自定义item的点击事件不为null，设置监听事件*/
        if (itemClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    itemClickListener.OnItemClickListener(holder.itemView, holder.getLayoutPosition());
                }
            });
        }

        /*自定义item的长按事件不为null，设置监听事件*/
        if (itemLongClickListener != null) {

            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    itemLongClickListener.OnItemLongClickListener(holder.itemView, holder.getLayoutPosition());
                    return true;
                }
            });
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.collection_item,parent,false);
        RecyclerView.ViewHolder holder=new ViewHolder(view);
        return (ViewHolder) holder;
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public void setDataChange(List<TopNews> newsList){
        this.newsList=newsList;
        notifyDataSetChanged();
    }
    public void setOnItemClickListener(MyOnItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }
    public void setOnItemLongClickListener(MyOnItemLongClickListener itemLongClickListener) {
        this.itemLongClickListener = itemLongClickListener;
    }
}
