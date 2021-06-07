package com.example.uts_akb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {
    private static final String DATABASE = "catatan.db";
    private static final String TABLE = "catatan";
    private static final String COL_1 = "id";
    private static final String COL_2 = "judul";
    private static final String COL_3 = "kategori";
    private static final String COL_4 = "isi";
    private static final String COL_5 = "date";

    public Database(@Nullable Context context) {
        super(context, DATABASE, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE + " (" +
                COL_1 + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_2 + " TEXT, " +
                COL_3 + " TEXT, " +
                COL_4 + " TEXT, " +
                COL_5 + " TEXT" +
                ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE);
    }

    public boolean insertData(String judul, String kategori, String isi, String date) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COL_2, judul);
        values.put(COL_3, kategori);
        values.put(COL_4, isi);
        values.put(COL_5, date);

        long results = db.insert(TABLE, null, values);

        return results != -1;
    }

    public boolean updateData(String id, String judul, String kategori, String isi, String date) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, id);
        contentValues.put(COL_2, judul);
        contentValues.put(COL_3, kategori);
        contentValues.put(COL_4, isi);
        contentValues.put(COL_5, date);

        long results = db.update(TABLE, contentValues, COL_1 + " = ? ", new String[]{id});

        return results != -1;
    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();

        return  db.rawQuery("SELECT * FROM " + TABLE, null);
    }

    public Integer deteleData(String id){
        SQLiteDatabase db = getWritableDatabase();
        return db.delete(TABLE, COL_1 + " = ? ", new String[]{id});
    }
}
