package com.example.kohlsstepup.data.model;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

import static com.example.kohlsstepup.data.model.Constants.BASE_URL;

public class ApiHelper {

    public static Retrofit createRetrofitInstance() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }

    public static Call<ArrayList<Post>> getPosts() {
        Retrofit retrofit = createRetrofitInstance();
        RemoteService remoteService = retrofit.create(RemoteService.class);
        return remoteService.getPosts();
    }

    public interface RemoteService {
        @GET("posts")
        Call<ArrayList<Post>> getPosts();
    }
}
