package fr.esilv.s8.mobileappdev.final_project.ui.Asso;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;
import java.util.List;

import fr.esilv.s8.mobileappdev.final_project.R;


public class AdapterAsso extends RecyclerView.Adapter<AdapterAsso.MyViewHolder> {




    private Context context;
    private String[] title;
    private String[] desc;

    AdapterAsso(Context context, String[] title, String[] desc){
        this.context = context;
        this.title = title;
        this.desc = desc;
    }

    @Override
    public int getItemCount() {
        return title.length;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.activity_adapter_asso, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.name.setText(title[position]);
        holder.description.setText(desc[position]);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private final TextView name;
        private final TextView description;

        private Pair<String, String> currentPair;

        public MyViewHolder(final View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.name);
            description = ((TextView) itemView.findViewById(R.id.description));

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    new AlertDialog.Builder(itemView.getContext())
                            .setTitle(name.getText().toString())
                            .setMessage(description.getText().toString())
                            .show();
                }
            });
        }
    }
}