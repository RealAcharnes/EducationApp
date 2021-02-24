package com.example.androidproject.network;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClientInstance {

    /**
     * This is the class for the retrofit Instance, we write the Base of the URL that never change.
     */

    private static Retrofit retrofit;
    private static final String BASE_URL = "https://core.ac.uk:443/api-v2/";


    public static Retrofit getRetrofitInstance() {

        if (retrofit == null) {

            /** The API we use  can be a little slow so we put a Timeout of 100sec to be safe **/

            OkHttpClient httpClient = new OkHttpClient().newBuilder()
                    .connectTimeout(100, TimeUnit.SECONDS)
                    .readTimeout(100, TimeUnit.SECONDS)
                    .writeTimeout(100, TimeUnit.SECONDS)
                    .build();

            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient)
                    .build();
        }
        return retrofit;
    }

}
