package fr.esilv.s8.mobileappdev.final_project.ui.slideshow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import fr.esilv.s8.mobileappdev.final_project.MainActivity;
import fr.esilv.s8.mobileappdev.final_project.R;
import fr.esilv.s8.mobileappdev.final_project.ui.slideshow.AdapterSlideshow;

public class SlideshowFragment extends Fragment {


    private RecyclerView rv;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_slideshow, container, false);

        rv = (RecyclerView) root.findViewById(R.id.fragment_slideshow_rv);
        int[] photo = new int[]{R.drawable.a11,R.drawable.a12, R.drawable.a13,
                R.drawable.a14, R.drawable.a15, R.drawable.a16, R.drawable.a17, R.drawable.a18, R.drawable.slide, R.drawable.marius, R.drawable.melvyn, R.drawable.pierre, R.drawable.loris, R.drawable.pauline, R.drawable.guillaume, R.drawable.pierre};

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this.getContext(), 2, GridLayoutManager.VERTICAL, false);
        rv.setLayoutManager(gridLayoutManager);
        AdapterSlideshow adapterSlideshow = new AdapterSlideshow(this.getContext(), photo);
        rv.setAdapter(adapterSlideshow);




        return root;
    }
}