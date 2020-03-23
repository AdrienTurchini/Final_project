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

    private SlideshowViewModel slideshowViewModel;
    private RecyclerView rv;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        slideshowViewModel =
                ViewModelProviders.of(this).get(SlideshowViewModel.class);
        View root = inflater.inflate(R.layout.fragment_slideshow, container, false);

        rv = (RecyclerView) root.findViewById(R.id.fragment_slideshow_rv);
        int[] photo = new int[]{R.drawable.slide,R.drawable.guillaume, R.drawable.pauline,
                R.drawable.loris, R.drawable.pierre, R.drawable.marius, R.drawable.melvyn};

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this.getContext(), 2, GridLayoutManager.VERTICAL, false);
        rv.setLayoutManager(gridLayoutManager);
        AdapterSlideshow adapterSlideshow = new AdapterSlideshow(this.getContext(), photo);
        rv.setAdapter(adapterSlideshow);




        return root;
    }
}