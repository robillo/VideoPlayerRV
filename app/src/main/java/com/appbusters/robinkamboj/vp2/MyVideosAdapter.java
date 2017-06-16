package com.appbusters.robinkamboj.vp2;

import android.graphics.Bitmap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.allattentionhere.autoplayvideos.AAH_CustomViewHolder;
import com.allattentionhere.autoplayvideos.AAH_VideosAdapter;
import com.squareup.picasso.Picasso;

import java.util.List;

class MyVideosAdapter extends AAH_VideosAdapter {

    private List<MyModel> list;
    private Picasso picasso;

    private class MyViewHolder extends AAH_CustomViewHolder {
        final TextView tv;
        final ImageView img_vol;

        //to mute/un-mute video (optional)
        boolean isMuted;

        MyViewHolder(View x) {
            super(x);
            tv = (TextView) x.findViewById(R.id.tv);
            img_vol = (ImageView) x.findViewById(R.id.img_vol);
        }
    }

    MyVideosAdapter(List<MyModel> list_urls, Picasso p) {
        this.list = list_urls;
        this.picasso = p;
    }

    @Override
    public AAH_CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_card, parent, false);
        Log.e("CREATING VH", "My Videos Adapter");
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final AAH_CustomViewHolder holder, int position) {
        ((MyViewHolder) holder).tv.setText(list.get(position).getName());

        Log.e("BINDING DATA", "My Videos Adapter");

        //todo
        holder.setImageUrl(list.get(position).getImage_url());
        holder.setVideoUrl(list.get(position).getVideo_url());
        //load image/thumbnail into imageview

        if (list.get(position).getImage_url() != null && !list.get(position).getImage_url().isEmpty())
            picasso.load(holder.getImageUrl()).into(holder.getAAH_ImageView());

        if(list.get(position).getVideo_url()!=null){
            Log.e("videourl" + position, list.get(position).getVideo_url());
            Log.e("imageurl" + position, list.get(position).getImage_url());
            holder.playVideo();
        }
        else {
            Log.e("imageurl" + position, list.get(position).getImage_url());
        }

        //to mute/un-mute video (optional)
        holder.getAah_vi().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((MyViewHolder) holder).isMuted) {
                    holder.unmuteVideo();
                    ((MyViewHolder) holder).img_vol.setImageResource(android.R.drawable.ic_media_play);
                } else {
                    holder.muteVideo();
                    ((MyViewHolder) holder).img_vol.setImageResource(android.R.drawable.ic_media_pause);
                }
                ((MyViewHolder) holder).isMuted = !((MyViewHolder) holder).isMuted;
            }
        });

        if (list.get(position).getVideo_url()==null){
            ((MyViewHolder) holder).img_vol.setVisibility(View.INVISIBLE);
        }else {
            ((MyViewHolder) holder).img_vol.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
        return list.size();
    }
}