package com.example.yelaman.alphaacademy;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    List<Video> mVideos;

    public CustomAdapter(List<Video> videos) {
        mVideos = videos;
    }

    @NonNull
    @Override
    public CustomAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.row_list, null, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.ViewHolder holder, int position) {
        holder.setNameOfVideo(mVideos.get(position).getTitle());
//        holder.setVideo();
       /* holder.setVideoPreview(mVideos.get(position).getThumbnail());*/
    }

    @Override
    public int getItemCount() {
        return mVideos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameOfVideo;
        ImageView preview;
        /*ImageView videoPreview;*/


        public ViewHolder(View itemView) {
            super(itemView);

            preview = itemView.findViewById(R.id.image);
            nameOfVideo = itemView.findViewById(R.id.textViewNameOfVideo);
            /*videoPreview = itemView.findViewById(R.id.videoPreview);*/
        }

        public void setNameOfVideo(String nameOfVideo) {
            this.nameOfVideo.setText(nameOfVideo);
        }

      /*  public void setVideo() {
            this.preview.setImageDrawable(R.drawable.photo);
        }*/
        /* public void setVideoPreview(String thumbnail) {
            Glide.with(itemView.getContext()).load(thumbnail).into(this.videoPreview);
        }*/
    }
}
