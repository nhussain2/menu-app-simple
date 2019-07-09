package com.example.listapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.view.Display;
import android.widget.ImageView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent in = getIntent();
        int index = in.getIntExtra("com.listapp.ITEM_INDEX", -1);
        if (index > -1) {
            int pic = getImg(index);
            ImageView img = (ImageView) findViewById(R.id.imageView);
            scaleImg(img, pic);
        }
    }
    private int getImg(int index) {
        switch (index) {
            case 0: return R.drawable.pic;
            case 1: return R.drawable.picagain;
            case 2: return R.drawable.picagainagain;
            default: return -1;

        }

    }
    private void scaleImg(ImageView img, int pic){
        Display screen = getWindowManager().getDefaultDisplay(); //determines size of screen display default
        BitmapFactory.Options options = new BitmapFactory.Options();

        //^ called instances

        options.inJustDecodeBounds = true;
        //turned on boundaries

        BitmapFactory.decodeResource(getResources(), pic, options);
        int imgWidth = options.outWidth;
        int screenWidth = screen.getWidth();
        if (imgWidth > screenWidth){
            int ratio = Math.round((float) imgWidth/ (float)screenWidth);
            options.inSampleSize = ratio;
        }
        options.inJustDecodeBounds = false;
        Bitmap scaledImage = BitmapFactory.decodeResource(getResources(), pic, options);
        img.setImageBitmap(scaledImage);



    }
}
