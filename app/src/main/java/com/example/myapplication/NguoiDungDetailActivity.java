package com.example.myapplication;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.example.myapplication.DAO.NguoidungDAO;

public class NguoiDungDetailActivity extends AppCompatActivity {
    EditText edFullName, edPhone;
    NguoidungDAO nguoiDungDAO;
    String username,fullname,phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("CHI TIẾT NGƯỜI DÙNG");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_nguoi_dung_detail);
        edFullName =  findViewById(R.id.edFullName);
        edPhone =  findViewById(R.id.edPhone);
        TextView text =  findViewById(R.id.text);;
        Typeface type=Typeface.createFromAsset(getAssets(), "fonts/f.ttf");
        text.setTypeface(type);
        nguoiDungDAO = new NguoidungDAO(this);
        Intent in = getIntent();
        Bundle b = in.getExtras();
        fullname = b.getString("FULLNAME");
        phone = b.getString("PHONE");
        username = b.getString("USERNAME");
        edFullName.setText(fullname);
        edPhone.setText(phone);
    }
    public void updateUser(View view){
        if (nguoiDungDAO.updateInfoNguoiDung(username,edPhone.getText().toString(),edFullName.getText().toString())>0){
            Toast.makeText(getApplicationContext(),"Lưu thành công",Toast.LENGTH_SHORT).show();
        }
    }
    public void Huy(View view){
        finish();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;

            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    }

