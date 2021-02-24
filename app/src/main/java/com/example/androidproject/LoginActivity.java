package com.example.androidproject;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.androidproject.fragment.ArticlesFragmentWithRecyclerView;
import com.example.androidproject.utils.Constants;


public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    /**
     * This class handle the login and the sign in button
     */

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);

        findViewById(R.id.loginButton).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        startActivity(getHomeIntent());
    }

    private Intent getHomeIntent(){
        Intent intent = new Intent(this, HomeActivity.class);
        return intent;
    }




}