package com.example.myapplication.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.myapplication.DAO.NguoidungDAO;
import com.example.myapplication.DAO.SachDAO;
import com.example.myapplication.DAO.TheloaiDAO;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "dbBookManager";
    public static final int VERSION = 1;
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(NguoidungDAO.SQL_NGUOI_DUNG);
        db.execSQL(TheloaiDAO.SQL_THE_LOAI);
        db.execSQL(SachDAO.SQL_SACH);

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop table if exists "+NguoidungDAO.TABLE_NAME);
        db.execSQL("Drop table if exists "+TheloaiDAO.TABLE_NAME);
        db.execSQL("Drop table if exists "+SachDAO.TABLE_NAME);

        onCreate(db);
    }
}
