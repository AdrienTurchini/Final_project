package fr.esilv.s8.mobileappdev.final_project.ui.gallery;

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

import fr.esilv.s8.mobileappdev.final_project.R;

public class InstagramFragment extends Fragment {

    private InstagramViewModel instagramViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        instagramViewModel =
                ViewModelProviders.of(this).get(InstagramViewModel.class);
        View root = inflater.inflate(R.layout.fragment_instagram, container, false);
        final TextView textView = root.findViewById(R.id.text_instagram);
        instagramViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}