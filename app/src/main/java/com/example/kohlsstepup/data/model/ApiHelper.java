package com.example.kohlsstepup.data.model;

import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

import static com.example.kohlsstepup.data.model.Constants.BASE_URL;

public class ApiHelper {
    public static final String TAG = "FRANK ";

    public static Retrofit createRetrofitInstance() {
        Log.d(TAG, "createRetrofitInstance: ");
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Log.d(TAG, "createRetrofitInstance: " + retrofit.baseUrl());
        return retrofit;
    }

    public static Call<List<Post>> getPosts() {
        Retrofit retrofit = createRetrofitInstance();
        RemoteService remoteService = retrofit.create(RemoteService.class);
        Log.d(TAG, "getPosts: " + remoteService.getPosts().toString());
        return remoteService.getPosts();
    }

    public static Call<Post> getPost(String userId, String id) {
        Retrofit retrofit = createRetrofitInstance();
        RemoteService remoteService = retrofit.create(RemoteService.class);
        Log.d(TAG, "getPost (1) : userId: " + userId + " id: " + id);
        return remoteService.getPost(userId, id);
    }

    public interface RemoteService {
        @GET("posts")
        Call<List<Post>> getPosts();

        @GET("posts")
        Call<Post> getPost(@Query("userId") String userId, @Query("id") String id);
    }
}
