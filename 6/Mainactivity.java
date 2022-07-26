package com.example.parsing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button parseXMLBtn,parseJSONBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        parseXMLBtn = findViewById(R.id.parseXMLBtn);
        parseJSONBtn = findViewById(R.id.parseJSONBtn);

        parseXMLBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ViewDataActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("datatype","xml");
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });


        parseJSONBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(MainActivity.this,ViewDataActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("datatype","json");
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}
