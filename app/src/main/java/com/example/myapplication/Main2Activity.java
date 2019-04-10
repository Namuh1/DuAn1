package com.example.myapplication;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    ImageView ngdung,theloai,imageHoadon,imageSach,imageBanchay,imageThongke;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2_main);
        setTitle("QUẢN LÍ");
        ngdung= findViewById(R.id.nguoidung);
        theloai= findViewById(R.id.theloai);
        imageHoadon= findViewById(R.id.imageHoadon);
        imageSach= findViewById(R.id.imageSach);
        imageBanchay=findViewById(R.id.imageBanchay);
        imageThongke= findViewById(R.id.imageThongke);

        TextView text = findViewById(R.id.text);;
        Typeface type=Typeface.createFromAsset(getAssets(), "fonts/f.ttf");

        text.setTypeface(type);
        ngdung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Main2Activity.this, ListNguoiDungActivity.class);
                startActivity(i);
            }
        });
        theloai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Main2Activity.this, ListTheLoaiActivity.class);
                startActivity(i);
            }
        });
        imageHoadon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Main2Activity.this, ListHoaDonActivity.class);
                startActivity(i);
            }
        });
        imageSach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Main2Activity.this, ListSachActivity.class);
                startActivity(i);
            }
        });
        imageBanchay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Main2Activity.this, ListBanChayActivity.class);
                startActivity(i);
            }
        });
        imageThongke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Main2Activity.this, ListThongKeActivity.class);
                startActivity(i);
            }
        });
    }
}
