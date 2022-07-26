package com.example.labp4;

import androidx.appcompat.app.AppCompatActivity;

import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.time.Period;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn;
    boolean running;
    int[] ia=new int[]{R.drawable.image1,R.drawable.image2,R.drawable.image3,R.drawable.image4,R.drawable.image5};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=(Button)findViewById(R.id.btn_wall);
        btn.setOnClickListener(this);
    }
    @Override
    public void onClick(View view){
        if(!running)
        {
            new Timer().schedule(new MyTimer(),0,3000);
            running=true;


        }
    }

    private class MyTimer extends TimerTask {
        public void run()
        {
            try {
                WallpaperManager wallpaperManager=WallpaperManager.getInstance(getBaseContext());
                Random random=new Random();
                //wallpaperManager.setBitmap(BitmapFactory.decodeResource(getResources().ia[random.nextInt(5)]));
                int randomInt= random.nextInt(5);
                Bitmap bitmap=BitmapFactory.decodeResource(getResources(),ia[randomInt]);
                wallpaperManager.setBitmap(bitmap);
            }catch(IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}
