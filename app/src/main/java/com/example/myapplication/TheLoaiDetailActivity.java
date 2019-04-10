package com.example.myapplication;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.DAO.TheloaiDAO;

public class TheLoaiDetailActivity extends AppCompatActivity {
    EditText edMatheloai,edTentheloai,edMota,edVitri;
    TheloaiDAO theloaiDAO;
    String ma,ten,vi,mo,user;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("CHI TIẾT THỂ LOẠI");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_theloaidetail);
        edMatheloai = findViewById(R.id.edMatheloai);
        edTentheloai = findViewById(R.id.edTentheloai);
        edMota = findViewById(R.id.edMota);
        edVitri = findViewById(R.id.edVitri);
        theloaiDAO = new TheloaiDAO(this);
        TextView text = findViewById(R.id.text);
        Typeface type=Typeface.createFromAsset(getAssets(), "fonts/f.ttf");
        text.setTypeface(type);
        Intent intent= getIntent();
        Bundle c = intent.getExtras();
        user=c.getString("MATHELOAI");
        ten = c.getString("TENTHELOAI");
        mo = c.getString("MOTA");
        vi = c.getString("VITRI");
        edMatheloai.setText(user);
        edTentheloai.setText(ten);
        edMota.setText(mo);
        edVitri.setText(vi);
    }
    public void updateU(View view){
    if(theloaiDAO.updateInfoTheLoai(user,edMatheloai.getText().toString(), edTentheloai.getText().toString(),
            edMota.getText().toString(), edVitri.getText().toString())>0){
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
