package com.example.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.DAO.NguoidungDAO;
import com.example.myapplication.Dulieu.NguoiDung;


public class LoginActivity extends AppCompatActivity {
    EditText edUserName, edPassword;
    Button btnLogin, btnCancel;
    CheckBox chkRememberPass;
    String strUser, strPass;
    NguoidungDAO nguoiDungDAO;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setTitle("ĐĂNG NHẬP");
        edUserName =  findViewById(R.id.edUserName);
        edPassword =  findViewById(R.id.edPassword);
        btnLogin =  findViewById(R.id.btnLogin);
        btnCancel =  findViewById(R.id.btnCancel);
        chkRememberPass =  findViewById(R.id.chkRememberPass);
        nguoiDungDAO = new NguoidungDAO(LoginActivity.this);

        TextView text= findViewById(R.id.text) ;
        Typeface type=Typeface.createFromAsset(getAssets(), "fonts/f.ttf");
        text.setTypeface(type);

        Drawable img = getApplicationContext().getResources().getDrawable( R.drawable.nguoi);
        img.setBounds(0, 0, 60, 60);
        edUserName.setCompoundDrawables(img, null, null, null);
        Drawable im = getApplicationContext().getResources().getDrawable( R.drawable.khoa);
        im.setBounds(0, 0, 60, 60);
        edPassword.setCompoundDrawables(im, null, null, null);
    }
    public void checkLogin(View v){
        strUser = edUserName.getText().toString();
        strPass = edPassword.getText().toString();
        NguoiDung user= new NguoiDung(strUser,strPass);
        Boolean ds=nguoiDungDAO.Luu(strUser,strPass);
        if (strUser.isEmpty()||strPass.isEmpty()){
            Toast.makeText(getApplicationContext(),"Tên đăng nhập và mật khẩu không được bỏ trống",
                    Toast.LENGTH_SHORT).show();
        }else {
            if (strUser.equalsIgnoreCase("admin")&&strPass.equalsIgnoreCase("admin")){
                Toast.makeText(getApplicationContext(),"Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                Intent intent =new Intent(LoginActivity.this,Main2Activity.class);
                startActivity(intent);
            }else if(ds==true){
                Toast.makeText(getApplicationContext(),"Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                Intent intent =new Intent(LoginActivity.this,Main2Activity.class);
                startActivity(intent);
            }else{
                Toast.makeText(getApplicationContext(),"Thất bại", Toast.LENGTH_SHORT).show();
            }
        }
    }
    public void exit(View view){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        // Setting Alert Dialog Title
        alertDialogBuilder.setTitle("Xác nhận");
        // Icon Of Alert Dialog
        alertDialogBuilder.setIcon(R.drawable.ifo);
        // Setting Alert Dialog Message
        alertDialogBuilder.setMessage("Bạn có muốn thoát?");
        alertDialogBuilder.setCancelable(false);

        alertDialogBuilder.setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                //Đóng Activity hiện tại
                finish();
            }
        });

        alertDialogBuilder.setNegativeButton("Không đồng ý", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(LoginActivity.this,"Bạn đã click vào nút không đồng ý",Toast.LENGTH_SHORT).show();
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
    public void rememberUser(String u, String p, boolean status){
        SharedPreferences pref = getSharedPreferences("USER_FILE",MODE_PRIVATE);
        SharedPreferences.Editor edit = pref.edit();
        if (!status){
            //xoa tinh trang luu tru truoc do
            edit.clear();
        }else {
            //luu du lieu
            edit.putString("USERNAME",u);
            edit.putString("PASSWORD",p);
            edit.putBoolean("REMEMBER",status);
        }
        //luu lai toan bo
        edit.commit();
    }
}
