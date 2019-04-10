package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.myapplication.Adapter.HoadonchitietAdapter;
import com.example.myapplication.DAO.HoaDonChiTietDAO;

import java.util.ArrayList;
import java.util.List;

public class HoaDonChiTiet extends AppCompatActivity {
    public List<com.example.myapplication.Dulieu.HoaDonChiTiet> dsHDCT = new ArrayList<>();
    ListView lvCart;
    HoadonchitietAdapter adapter = null;
    HoaDonChiTietDAO hoaDonChiTietDAO;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("HOÁ ĐƠN CHI TIẾT");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_hoadonchitiet);
        lvCart =  findViewById(R.id.lvHoaDonChiTiet);
        hoaDonChiTietDAO = new HoaDonChiTietDAO(HoaDonChiTiet.this);
        Intent in = getIntent();
        Bundle b = in.getExtras();
        if (b != null) { dsHDCT = hoaDonChiTietDAO.getAllHoaDonChiTietByID(b.getString("MAHOADON"));
        }
        adapter = new HoadonchitietAdapter(this, dsHDCT);
        lvCart.setAdapter(adapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
            onBackPressed();
            return true;

        default:break;
        }
        return super.onOptionsItemSelected(item);
    }
}
