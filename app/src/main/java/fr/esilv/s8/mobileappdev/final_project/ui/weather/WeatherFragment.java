package fr.esilv.s8.mobileappdev.final_project.ui.weather;

import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import fr.esilv.s8.mobileappdev.final_project.MainActivity;
import fr.esilv.s8.mobileappdev.final_project.R;
import fr.esilv.s8.mobileappdev.final_project.ui.Asso.Asso;
import retrofit2.Call;

public class WeatherFragment extends Fragment {

    private WeatherViewModel weatherViewModel;
    private TextView weather;
    private EditText search;
    private Button button;
    private static final int SECOND_ACTIVITY_REQUEST_CODE = 0;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {



        weatherViewModel =
                ViewModelProviders.of(this).get(WeatherViewModel.class);
        View root = inflater.inflate(R.layout.weather_fragment, container, false);

        final TextView textView = root.findViewById(R.id.text_weather);
        weatherViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        search = root.findViewById(R.id.weather_search);
        button = root.findViewById(R.id.weather_button);

        //  désactive le bouton play lors de la création de la page
        button.setEnabled(false);

        // ajoute un listener pour voir quand modification du texte sous la forme d'une classe anonyme
        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // verifie qu'il y a au moins une lettre et active le bouton si oui
                button.setEnabled(s.toString().length() != 0);
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        

        return root;
    }

}
