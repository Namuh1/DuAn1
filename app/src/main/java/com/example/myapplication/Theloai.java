package com.example.myapplication;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.DAO.TheloaiDAO;


public class TheLoai extends AppCompatActivity {
    Button btnThemTheLoai;
    TheloaiDAO theloaiDAO;
    EditText edMa,edTen,edVi,edMo;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theloai);
        setTitle("THÊM THỂ LOẠI");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        btnThemTheLoai = findViewById(R.id.btnThem);
        edMa = findViewById(R.id.edMa);
        edTen = findViewById(R.id.edTen);
        edVi = findViewById(R.id.edVi);
        edMo = findViewById(R.id.edMo);
        TextView textView = findViewById(R.id.text);
        Typeface type = Typeface.createFromAsset(getAssets(), "fonts/f.ttf");
        textView.setTypeface(type);
    }
    public void showtheloai(View view){
        finish();
    }
    public void quaylai(View view){
        onBackPressed();
    }
    public void themtheloai( View view){
    theloaiDAO = new TheloaiDAO(TheLoai.this);
        com.example.myapplication.Dulieu.TheLoai user = new com.example.myapplication.Dulieu.TheLoai(
    edMa.getText().toString(), edTen.getText().toString(), edMo.getText().toString(), edVi.getText().toString());
        try {
            if (validateForm()>0){
                if (theloaiDAO.inserTheLoai(user) > 0) {
                    Toast.makeText(getApplicationContext(), "Thêm thành công",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Thêm thất bại",
                            Toast.LENGTH_SHORT).show();
                }
            }
        } catch (Exception ex) {
            Log.e("Lỗi:", ex.toString());
        }
    }
    public int validateForm(){
        int check = 1;
        if (edMa.getText().length() == 0 || edTen.getText().length() == 0
                || edVi.getText().length() == 0 || edMo.getText().length()==0) {
            Toast.makeText(getApplicationContext(), "Bạn phải nhập đầy đủ thông tin ",
                    Toast.LENGTH_SHORT).show();
            check = -1;
        }
        return check;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case android.R.id.home:
                onBackPressed();
                return true;

            default:break;
        }

        return super.onOptionsItemSelected(item);
    }


}

