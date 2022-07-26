package com.example.myapplication;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    Button btn;
    EditText username,password;
    private int count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btn=findViewById(R.id.signup);
        username=findViewById(R.id.username);
        password= findViewById(R.id.password);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(count<2)
                {
                    String user = username.getText().toString();
                    String pass = password.getText().toString();

                    Intent intent=getIntent();
                    Bundle bundle = intent.getExtras();
                    String un = bundle.getString("USER_EXTRA");
                    String  ps = bundle.getString("PASS_EXTRA");

                    if(user.equals(un)==true && pass.equals(ps)==true)
                    {
                        Toast.makeText(getApplicationContext(), "Login Successfull", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(), "Login failed", Toast.LENGTH_SHORT).show();
                        count++;
                    }
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Too Many Login Attempt please try again later", Toast.LENGTH_SHORT).show();
                    btn.setEnabled(false);
                }

            }
        });

    }
}
