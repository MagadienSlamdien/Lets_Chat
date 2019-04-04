package com.hybridsoftsolutions.letschat.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.github.nkzawa.socketio.client.IO;
import com.github.nkzawa.socketio.client.Socket;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.hybridsoftsolutions.letschat.utils.Values;

import java.net.URISyntaxException;

/**
 * Created by Magadien on 2018/08/16.
 */

public class SplashActivity extends AppCompatActivity {

    FirebaseAuth auth;
    public Socket socket;

    private static final String TAG = "SplashActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            auth = new FirebaseAuth(FirebaseApp.getInstance());
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

//        if (auth.getCurrentUser() != null) {
//            startActivity(new Intent(SplashActivity.this, MainActivity.class));
//        } else {
            startActivity(new Intent(SplashActivity.this, LoginActivity.class));
//        }

        finish();
    }
}
