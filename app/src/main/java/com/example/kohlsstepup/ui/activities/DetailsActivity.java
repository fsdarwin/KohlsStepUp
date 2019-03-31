package com.example.kohlsstepup.ui.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.kohlsstepup.R;

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

        Intent passedIntent = getIntent();
        String userId = passedIntent.getExtras().getString("userId");
        Log.d(TAG, "onCreate: " + userId);
        //tv_UserId.setText(passedIntent.getExtras("userId"));

    }
}
