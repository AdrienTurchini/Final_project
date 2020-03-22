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


    private final List<Pair<String, String>> characters = Arrays.asList(
            Pair.create("L'histoire", "Slide Session est une asso créée en xxxx etc. "),
            Pair.create("Ce que l'on fait", "Tout au long de l'année nous nous engageons dans de nombreux projets etc."),
            Pair.create("Voyage au ski", "xxxx"),
            Pair.create("Altigliss", "Altigliss c'est le championnat du monde étudiant de ski."),
            Pair.create("Nos sponsors", "xxxxxxx"),
            Pair.create("Notre devise", "xxxxx")
    );

    @Override
    public int getItemCount() {
        return characters.size();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.activity_adapter_asso, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Pair<String, String> pair = characters.get(position);
        holder.display(pair);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {



        private final TextView name;
        private final TextView description;

        private Pair<String, String> currentPair;

        public MyViewHolder(final View itemView) {
            super(itemView);

            name = ((TextView) itemView.findViewById(R.id.name));
            description = ((TextView) itemView.findViewById(R.id.description));

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    new AlertDialog.Builder(itemView.getContext())
                            .setTitle(currentPair.first)
                            .setMessage(currentPair.second)
                            .show();
                }
            });
        }

        public void display(Pair<String, String> pair) {
            currentPair = pair;
            name.setText(pair.first);
            description.setText(pair.second);
        }
    }

}