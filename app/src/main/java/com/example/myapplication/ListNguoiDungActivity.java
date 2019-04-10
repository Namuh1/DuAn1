package com.example.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.myapplication.Adapter.NguoidungAdapter;
import com.example.myapplication.DAO.NguoidungDAO;
import com.example.myapplication.Dulieu.NguoiDung;

import java.util.ArrayList;
import java.util.List;

public class ListNguoiDungActivity extends AppCompatActivity {
    public static List<NguoiDung> nguoiDungs = new ArrayList<>();
    ListView lvNguoiDung;
    NguoidungAdapter adapter = null;
    NguoidungDAO nguoiDungDAO;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_listnguoidung);
        lvNguoiDung =  findViewById(R.id.lvNguoiDung);
        nguoiDungDAO = new NguoidungDAO(ListNguoiDungActivity.this);
        nguoiDungs = nguoiDungDAO.getAllNguoiDung();
        adapter = new NguoidungAdapter(this, nguoiDungs);
        lvNguoiDung.setAdapter(adapter);
        lvNguoiDung.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ListNguoiDungActivity.this,NguoiDungDetailActivity.class);
                Bundle b = new Bundle();
                b.putString("USERNAME", nguoiDungs.get(position).getUserName());
                b.putString("PHONE", nguoiDungs.get(position).getPhone());
                b.putString("FULLNAME", nguoiDungs.get(position).getHoTen());
                intent.putExtras(b);
                startActivity(intent);
            }
        });
        lvNguoiDung.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                return false;
            }
        });
    }
    @Override
    protected void onResume() {
        super.onResume();
        nguoiDungs.clear();
        nguoiDungs = nguoiDungDAO.getAllNguoiDung();
        adapter.changeDataset(nguoiDungDAO.getAllNguoiDung());
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menuuser, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch(item.getItemId()) {
            case R.id.add:
                intent = new Intent(ListNguoiDungActivity.this, ThemNguoiDungActivity.class);
                startActivity(intent);
                return(true);
            case R.id.btnChangePass:
                intent = new Intent(ListNguoiDungActivity.this,ChangePass.class);
                startActivity(intent);
                return(true);
            case android.R.id.home:
                onBackPressed();
                return true;

            default:break;
            case R.id.btnLogout:
                SharedPreferences pref = getSharedPreferences("USER_FILE",MODE_PRIVATE);
                SharedPreferences.Editor edit = pref.edit();
                //xoa tinh trang luu tru truoc do
                edit.clear();
                edit.commit();
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
                // Setting Alert Dialog Title
                alertDialogBuilder.setTitle("Xác nhận");
                // Icon Of Alert Dialog
                alertDialogBuilder.setIcon(R.drawable.ifo);
                // Setting Alert Dialog Message
                alertDialogBuilder.setMessage("Bạn có muốn đăng xuất?");
                alertDialogBuilder.setCancelable(false);

                alertDialogBuilder.setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        Intent intent = new Intent(ListNguoiDungActivity.this, LoginActivity.class);
                        startActivity(intent);
                    }
                });

                alertDialogBuilder.setNegativeButton("Không đồng ý", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(ListNguoiDungActivity.this,"Bạn đã click vào nút không đồng ý",Toast.LENGTH_SHORT).show();
                    }
                });

                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    }


