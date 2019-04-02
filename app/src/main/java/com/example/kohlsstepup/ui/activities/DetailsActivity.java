package com.example.kohlsstepup.ui.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.kohlsstepup.R;
import com.example.kohlsstepup.data.model.ApiHelper;
import com.example.kohlsstepup.data.model.Post;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailsActivity extends AppCompatActivity {

    public static final String TAG = "FRANK ";

    TextView tv_UserId;
    TextView tv_Id;
    TextView tv_Title;
    TextView tv_Body;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        tv_UserId = findViewById(R.id.tv_userId);
        tv_Id = findViewById(R.id.tv_id);
        tv_Title = findViewById(R.id.tv_title);
        tv_Body = findViewById(R.id.tv_body);

        //Get passedIntent
        Intent passedIntent = getIntent();
        //Get userId and message id from intent
        final String passedId =  passedIntent.getStringExtra("id");
        final String passedUserId = passedIntent.getStringExtra("userId");
        Log.d(TAG, "onCreate: userId: " + passedUserId + " Id: " + passedId);
        //Make repository call using userId and id
        ApiHelper.getPost(passedUserId, passedId).enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                Post post = response.body();
                String id = "ID: " + post.getId();
                String userId = "UserId: " + post.getUserId();
                String title = "Title: " + post.getTitle();
                String body = "Body: " + post.getBody();
                Log.d(TAG, "onCreate: " + userId + " " + id + " " + title + " " + body);
                tv_UserId.setText(userId);
                tv_Id.setText(id);
                tv_Title.setText(title);
                tv_Body.setText(body);
                            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.toString());
            }
        });

    }
}
