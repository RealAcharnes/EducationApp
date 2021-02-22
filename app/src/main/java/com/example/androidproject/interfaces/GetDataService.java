package com.example.androidproject.interfaces;

import com.example.androidproject.pojo.Article;
import com.example.androidproject.pojo.Infos;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GetDataService {

    @GET("search/{searchInput}?page=1&pageSize=10&apiKey=Bhk6AjUdJnOSGNKePu3CDX8f4l0LZzco")
    Call<Infos> doGetListArticles(@Path(value= "searchInput", encoded = true) String mUserInput);

}
