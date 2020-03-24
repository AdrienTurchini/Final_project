package fr.esilv.s8.mobileappdev.final_project.ui.weather;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

    private static Retrofit retrofit = null;

    private static String BaseUrl = "http://api.openweathermap.org/";

    public static  Retrofit getRetrofit() {
        if(retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(BaseUrl)
                    .build();
        }
        return retrofit;
    }
}
