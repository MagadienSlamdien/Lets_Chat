package com.hybridsoftsolutions.letschat.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.hybridsoftsolutions.letschat.R;

public class LoginActivity extends AppCompatActivity {

    private Button btn;
    private EditText name;
    public static final String NICKNAME = "usernickname";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btn = (Button) findViewById(R.id.btn_login);
        name = (EditText) findViewById(R.id.et_username);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!name.getText().toString().isEmpty()) {
                    Intent i = new Intent(LoginActivity.this, ChatActivity.class);

                    i.putExtra(NICKNAME, name.getText().toString());

                    startActivity(i);
                }
            }
        });
    }
}
