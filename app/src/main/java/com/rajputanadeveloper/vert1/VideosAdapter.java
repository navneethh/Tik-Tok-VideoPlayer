package com.rajputanadeveloper.vert1;

import android.media.MediaPlayer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class VideosAdapter extends RecyclerView.Adapter<VideosAdapter.videoViewHolder> {


   List<VideoItem> videoItems;

    public VideosAdapter(List<VideoItem> videoitemm) {
        this.videoItems = videoitemm;
    }


    @NonNull
    @Override
    public videoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
              return new videoViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_container_video,parent,false));
    }


    @Override
    public void onBindViewHolder(@NonNull videoViewHolder holder, int position) {

        holder.setVideoData(videoItems.get(position));
    }

    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The total number of items in this adapter.
     */
    @Override
    public int getItemCount() {
        return videoItems.size();
    }

    static class videoViewHolder extends RecyclerView.ViewHolder{


        TextView textvideotitle,textvideodesc;
        ProgressBar videoProgressBar;
        VideoView videoView;

        public videoViewHolder(@NonNull View itemView) {
            super(itemView);
            textvideodesc=itemView.findViewById(R.id.textVideoDescription);
            textvideotitle=itemView.findViewById(R.id.textVideoTitle);
            videoView=itemView.findViewById(R.id.videoView);
            videoProgressBar=itemView.findViewById(R.id.progress);
        }

        public void setVideoData(VideoItem vitem){




            textvideodesc.setText(vitem.videoDescription);
            textvideotitle.setText(vitem.videoTitle);
            videoView.setVideoPath(vitem.videoURL);
            videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mediaPlayer) {
                    videoProgressBar.setVisibility(View.GONE);
                    mediaPlayer.start();

                    float videoratio= mediaPlayer.getVideoWidth()/(float)mediaPlayer.getVideoHeight();
                    float screenratio= videoView.getWidth()/(float)videoView.getHeight();

                    float scale= videoratio/screenratio;
                    if(scale>=1f){                        Log.e("proper scale", "scale");

                        videoView.setScaleX(scale);
                    }else{
                        Log.e("Reverse scale", "1/scale");
                        videoView.setScaleY(1/scale);
                    }
                }
            });

            videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    mp.start();
                }
            });



        }

    }
}
