package com.example.jia.newsclient.activity.adapter;

import android.content.Context;
import android.content.Intent;
import android.speech.tts.Voice;
import android.support.v7.widget.RecyclerView;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jia.newsclient.R;
import com.example.jia.newsclient.activity.activity.VideoPlayActivity;
import com.example.jia.newsclient.activity.bean.VideoEntity;
import com.squareup.picasso.Picasso;

import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

/**
 * Created by jia on 2017/6/29.
 */

public class VideoAdapter extends RecyclerView.Adapter {
    private Context context;
    private List<VideoEntity.ResultBean> listDatas;

    public VideoAdapter(Context context, List<VideoEntity.ResultBean> listDatas) {
        this.context = context;
        this.listDatas = listDatas;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(context).inflate(R.layout.item_video,parent,false);

        return new MyViewHolder(item);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        MyViewHolder holder= (MyViewHolder) viewHolder;
        final VideoEntity.ResultBean video=listDatas.get(position);
        Picasso.with(context).load(video.getCover()).into(holder.ivVideoImage);
        holder.tvVideoTitle.setText(listDatas.get(position).getTitle());
        holder.videoPlayer.setUp(video.getMp4_url(), JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL,"");


        String durationStr = DateFormat.format("mm:ss", video.getLength() * 1000).toString();
        holder.tvVideoDuration.setText(durationStr);
        holder.tvPlayCount.setText(String.valueOf(video.getSizeSD()));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, VideoPlayActivity.class);
                intent.putExtra("video_url",video.getMp4_url());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        if(listDatas!=null){
            return  listDatas.size();
        }
        return 0;
    }
    class MyViewHolder extends RecyclerView.ViewHolder{
        private ImageView ivVideoImage;
        private TextView tvVideoTitle;
        private TextView tvVideoDuration;
        private TextView tvPlayCount;
        private JCVideoPlayerStandard videoPlayer;

        public MyViewHolder(View itemView) {
            super(itemView);
            ivVideoImage= (ImageView) itemView.findViewById(R.id.iv_video_image);
            tvVideoTitle= (TextView) itemView.findViewById(R.id.tv_video_title);
            tvVideoDuration= (TextView) itemView.findViewById(R.id.tv_video_duration);
            tvPlayCount= (TextView) itemView.findViewById(R.id.tv_play_count);
            videoPlayer= (JCVideoPlayerStandard) itemView.findViewById(R.id.videoPlayer);

        }
    }
}
