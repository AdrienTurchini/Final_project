package fr.esilv.s8.mobileappdev.final_project.ui.weather;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import fr.esilv.s8.mobileappdev.final_project.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WeatherViewModel extends ViewModel {

    private MutableLiveData<String> weatherText;

    public WeatherViewModel() {
        weatherText = new MutableLiveData<>();
        weatherText.setValue("Please try later, there is a connexion / API problem.");
        getCurrentData();
    }

    public LiveData<String> getText() {
        return weatherText;
    }

    public static String BaseUrl = "http://api.openweathermap.org/";
    public static String AppId = "7d05663265bf2d1761640846a820923a";
    public static String lat = "45.4149700";
    public static String lon = "6.56500";
    public static String city = "Megeve";

    void getCurrentData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        WeatherService service = retrofit.create(WeatherService.class);
        //Call<WeatherResponse> call = service.getCurrentWeatherData(lat, lon, AppId);
        Call<WeatherResponse> call = service.getCurrentWeatherData(city, AppId);
        call.enqueue(new Callback<WeatherResponse>() {
            @Override
            public void onResponse(@NonNull Call<WeatherResponse> call, @NonNull Response<WeatherResponse> response) {
                if (response.code() == 200) {
                    WeatherResponse weatherResponse = response.body();
                    assert weatherResponse != null;

                    double temp = weatherResponse.main.temp - (273.15);
                    temp = Math.round(temp * 100.0)/100.0;

                    double tempMin = weatherResponse.main.temp_min - (273.15);
                    tempMin = Math.round(tempMin * 100.0)/100.0;

                    double tempMax = weatherResponse.main.temp_max - (273.15);
                    tempMax = Math.round(tempMax * 100.0)/100.0;

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

                    weatherText.setValue(stringBuilder);
                }
            }

            @Override
            public void onFailure(@NonNull Call<WeatherResponse> call, @NonNull Throwable t) {
                weatherText.setValue(t.getMessage());
            }
        });
    }
}
