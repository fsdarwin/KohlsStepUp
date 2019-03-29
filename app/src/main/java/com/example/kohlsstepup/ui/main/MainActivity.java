package com.example.kohlsstepup.ui.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.kohlsstepup.R;
import com.example.kohlsstepup.data.model.ApiHelper;
import com.example.kohlsstepup.data.model.Post;
import com.example.kohlsstepup.data.model.PostResults;
import com.example.kohlsstepup.ui.RvAdapter;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "FRANK ";
    RecyclerView recyclerView;
    ArrayList postArrayList;
    RvAdapter rvAdapter;
    Callback callreturn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getBaseContext());
        recyclerView = findViewById(R.id.RecView);
        recyclerView.setLayoutManager(layoutManager);

        ApiHelper.getPosts().enqueue(new Callback<PostResults>() {
            @Override
            public void onResponse(Call<PostResults> call, Response<PostResults> response) {
                Log.d(TAG, "onResponse: ");
                postArrayList = response.body().getPosts();

                if (postArrayList != null) {
                    rvAdapter = new RvAdapter(postArrayList);
                    recyclerView.setAdapter(rvAdapter);
                    rvAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<PostResults> call, Throwable t) {

            }
        });
    }
}
