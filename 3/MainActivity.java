package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    Button btn;
    EditText username,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String regex = "^(?=.*[0-9])"
                + "(?=.*[a-z])(?=.*[A-Z])"
                + "(?=.*[@#$%^&+=])"
                + "(?=\\S+$).{8,20}$";

        Pattern p =Pattern.compile(regex);

        btn =findViewById(R.id.signup);
        username=findViewById(R.id.username);
        password= findViewById(R.id.password);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String un=username.getText().toString();
                String ps=password.getText().toString();
                Matcher m =p.matcher(ps);

                if(un.length() ==0 && ps.length() == 0)
                {
                    Toast.makeText(MainActivity.this,"Username or pass cant be empty",Toast.LENGTH_LONG).show();
                }
                else {
                    if(m.matches() == true)
                    {
                        Intent intent=new Intent(MainActivity.this,Login.class);
                        Bundle bundle =new Bundle();
                        bundle.putString("USER_EXTRA",un);
                        bundle.putString("PASS_EXTRA",ps);
                        intent.putExtras(bundle);
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(getApplicationContext(),"Password Pattern not matched", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });




    }
}
