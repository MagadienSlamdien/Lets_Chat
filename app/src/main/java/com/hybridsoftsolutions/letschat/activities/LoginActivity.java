package com.hybridsoftsolutions.letschat.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.hybridsoftsolutions.letschat.R;

public class LoginActivity extends AppCompatActivity {

    private EditText editTextMobile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextMobile = findViewById(R.id.editTextMobile);

        findViewById(R.id.buttonContinue).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String mobile = editTextMobile.getText().toString().trim();

                if(mobile.isEmpty() || mobile.length() < 10){
                    editTextMobile.setError("Enter a valid mobile");
                    editTextMobile.requestFocus();
                    return;
                }

                Intent intent = new Intent(LoginActivity.this, VerifyPhoneActivity.class);
                intent.putExtra("mobile", mobile);
                startActivity(intent);
            }
        });

    }
}
