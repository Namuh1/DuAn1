package com.example.myapplication;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    ImageView ngdung,theloai,imageHoadon,imageSach,imageBanchay,imageThongke;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2_main);
        setTitle("QUẢN LÍ");
        ngdung=(ImageView)findViewById(R.id.nguoidung);
        theloai=(ImageView)findViewById(R.id.theloai);
        imageHoadon=(ImageView)findViewById(R.id.imageHoadon);
        imageSach=(ImageView)findViewById(R.id.imageSach);
        imageBanchay=(ImageView)findViewById(R.id.imageBanchay);
        imageThongke=(ImageView)findViewById(R.id.imageThongke);

        TextView text = (TextView) findViewById(R.id.text);;
        Typeface type=Typeface.createFromAsset(getAssets(), "fonts/f.ttf");
        text.setTypeface(type);
        ngdung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Main2Activity.this,Listnguoidung.class);
                startActivity(i);
            }
        });
    }
}
