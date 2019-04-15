package com.androidpopcorn.tenx.testapp.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidpopcorn.tenx.testapp.R;
import com.androidpopcorn.tenx.testapp.data.model.Photo;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.HeroViewHolder> {

    private static final String TAG = "PhotoAdapter";

    Context mCtx;
    List<Photo> mList;


    @Inject
    public PhotoAdapter(Context mCtx) {
        this.mCtx = mCtx;
        this.mList = new ArrayList<>();
    }





    @NonNull
    @Override
    public HeroViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mCtx).inflate(R.layout.recyclerview_layout, parent, false);
        return new HeroViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HeroViewHolder holder, int position) {
        Photo currentPhoto = mList.get(position);

        String path = currentPhoto.getPost_url();
        String[] str = path.split("/");
        String id = str[str.length-1];

//        get id from the post url and fetch the photo from the unsplash api
        String newPath = "https://source.unsplash.com/"+id+"/400";

        Glide.with(mCtx)
                .load(newPath)
                .into(holder.imageView);

        holder.textView.setText(currentPhoto.getAuthor());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class HeroViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;

        public HeroViewHolder(View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.textView);
        }
    }



    public void updatePhotos(List<Photo> newphotos){
        mList.clear();
        mList.addAll(newphotos);
        notifyDataSetChanged();
    }
}