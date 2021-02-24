package com.example.androidproject.interfaces;

import com.example.androidproject.pojo.Infos;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GetDataService {
    /**
     * This class is the interface for retrofit.
     * retrofit use this interface to call the API
     * The URL contain a variable, depending on the search input of the user.
     * @param mUserInput the user input
     * @return it call the API using retrofit
     */
    @GET("search/{searchInput}?page=1&pageSize=10&apiKey=Bhk6AjUdJnOSGNKePu3CDX8f4l0LZzco")
    Call<Infos> doGetListArticles(@Path(value= "searchInput", encoded = true) String mUserInput);

}
