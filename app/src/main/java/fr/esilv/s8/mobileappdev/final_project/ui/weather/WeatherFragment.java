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
import retrofit2.Callback;
import retrofit2.Response;

public class WeatherFragment extends Fragment {

    private String AppId = "7d05663265bf2d1761640846a820923a";

    private TextView weather;
    private EditText search;
    private Button button;
    private static final int SECOND_ACTIVITY_REQUEST_CODE = 0;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {




        View root = inflater.inflate(R.layout.weather_fragment, container, false);


        weather = root.findViewById(R.id.text_weather);
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

        // ajoute un listener qui regarde si on a cliqué sur le bouton
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // l'utilisateur a cliqué sur le bouton et cela lance la nouvelle activite en communiquant avec l'ActivityManger de Android
                Intent MainActivity = new Intent(getActivity(), MainActivity.class);
                String searchInput = search.getText().toString();
                MainActivity.putExtra("searchInput", searchInput);
                startActivityForResult(MainActivity, SECOND_ACTIVITY_REQUEST_CODE);
                getActivity().finish();
            }
        });

        WeatherService dataService = RetrofitInstance.getRetrofit().create(WeatherService.class);


        Call<WeatherResponse> weatherResponseCall = dataService
                .getCurrentWeatherData(MainActivity.city,AppId);

        weatherResponseCall.enqueue(new Callback<WeatherResponse>() {
            @Override
            public void onResponse(@NonNull Call<WeatherResponse> call, @NonNull Response<WeatherResponse> response) {
                if (response.code() == 200) {
                    WeatherResponse weatherResponse = response.body();
                    assert weatherResponse != null;

                    double temP = weatherResponse.main.temp - (273.15);
                    temP = Math.round(temP * 1.0)/1.0;
                    int temp = (int) temP;

                    double temPMin = weatherResponse.main.temp_min - (273.15);
                    temPMin = Math.round(temPMin * 1.0)/1.0;
                    int tempMin = (int) temPMin;

                    double temPMax = weatherResponse.main.temp_max - (273.15);
                    temPMax = Math.round(temPMax * 1.0)/1.0;
                    int tempMax = (int) temPMax;

                    String stringBuilder = "Country: " +
                            weatherResponse.sys.country +
                            "\n" +
                            "Temperature: " +
                            temp +
                            "\n" +
                            "Temperature(Min): " +
                            tempMin+
                            "\n" +
                            "Temperature(Max): " +
                            tempMax +
                            "\n" +
                            "Humidity: " +
                            weatherResponse.main.humidity +
                            "\n" +
                            "Pressure: " +
                            weatherResponse.main.pressure +
                            "\n" +
                            "City Name : " +
                            weatherResponse.name;

                    weather.setText(stringBuilder);
                }
            }

            @Override
            public void onFailure(@NonNull Call<WeatherResponse> call, @NonNull Throwable t) {
                weather.setText(t.getMessage());
            }
        });

        return root;
    }

}
