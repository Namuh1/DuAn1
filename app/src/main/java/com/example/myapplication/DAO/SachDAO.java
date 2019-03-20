package com.example.myapplication.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.myapplication.Database.DatabaseHelper;
import com.example.myapplication.Dulieu.Sach;

import java.util.ArrayList;
import java.util.List;

public class SachDAO {
    private SQLiteDatabase db;
    private DatabaseHelper dbHelper;
    public static final String TABLE_NAME = "Sach";
    public static final String SQL_SACH ="CREATE TABLE Sach (maSach text primary key, maTheLoai text, tensach text," + "tacGia text, NXB text, giaBia double, soLuong number);";
    public static final String TAG = "SachDAO";
    public SachDAO(Context context) {
        dbHelper = new DatabaseHelper(context);
        db = dbHelper.getWritableDatabase();
    }

}
