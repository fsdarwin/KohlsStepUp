package com.example.kohlsstepup.ui.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.kohlsstepup.R;
import com.example.kohlsstepup.data.model.ApiHelper;
import com.example.kohlsstepup.data.model.Post;
import com.example.kohlsstepup.ui.RvAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "FRANK ";
    RecyclerView recyclerView;
    List<Post> postList;
    RvAdapter rvAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getBaseContext());
        recyclerView = findViewById(R.id.RecView);
        recyclerView.setLayoutManager(layoutManager);
        Log.d(TAG, "onCreate: ");

        ApiHelper.getPosts().enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                final List<Post> postList = response.body();
                //Finish setting up the RecyclerView after the respose sets the post list
                rvAdapter = new RvAdapter(postList);
                //Set the click listener to send the selected item over to DetailsActivity
                rvAdapter.setOnEntryClickListener(new RvAdapter.OnEntryClickListener() {
                    @Override
                    public void onEntryClick(View view, int position) {
                        Post post = postList.get(position);
                        Intent passIntent = new Intent(getApplicationContext(), DetailsActivity.class);
                        passIntent.putExtra("id", post.getId());
                        passIntent.putExtra("userId", post.getUserId());
                        passIntent.putExtra("title", post.getTitle());
                        passIntent.putExtra("body", post.getBody());
                        Log.i("id", post.getId());
                        startActivity(passIntent);
                    }
                });
                recyclerView.setAdapter(rvAdapter);
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.toString());
            }
        });
    }
}
