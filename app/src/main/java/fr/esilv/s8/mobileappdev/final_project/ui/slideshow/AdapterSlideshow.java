package fr.esilv.s8.mobileappdev.final_project.ui.slideshow;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;
import java.util.List;

import fr.esilv.s8.mobileappdev.final_project.R;


public class AdapterSlideshow extends RecyclerView.Adapter<AdapterSlideshow.MyViewHolder> {

    private Context context;
    private int[] photo;

    AdapterSlideshow(Context context, int[] photos){
        this.context = context;
        this.photo = photos;
    }

    @Override
    public int getItemCount() {
        return photo.length;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.fragment_adapter_slideshow, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.image.setImageResource(photo[position]);

    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private final ImageView image;

        public MyViewHolder(final View itemView) {
            super(itemView);
            image = ((ImageView) itemView.findViewById(R.id.adapter_slideshow_imageView));

        }

    }

}