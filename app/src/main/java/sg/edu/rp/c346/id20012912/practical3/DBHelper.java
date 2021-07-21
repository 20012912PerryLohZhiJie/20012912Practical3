package sg.edu.rp.c346.id20012912.practical3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper
{
    private final static String dbName = "practical3.db";
    private final static int dbVersion = 1;
    private static final String TABLE_ClIENT = "client";
    private static final String COLUMN_NAME = "client";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_AMOUNT = "amount";


    public DBHelper(@Nullable Context context)
    {
        super(context, dbName, null, dbVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String createTableSql = "CREATE TABLE " + TABLE_ClIENT + "("
                + COLUMN_NAME +"TEXT " + COLUMN_ID + "INTEGER PRIMARY KEY AUTOINCREMENT,"+ COLUMN_AMOUNT + " INTEGER)";
        db.execSQL(createTableSql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {

    }

    public void insertClient(String name, int salespotential)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME,name);
        values.put(COLUMN_AMOUNT,salespotential);

    }

    public ArrayList<Client> getClients()
    {
        ArrayList<Client> clients = new ArrayList<>();


        String selectQuery = "SELECT " + COLUMN_NAME + ","
                + COLUMN_ID+ COLUMN_AMOUNT+ " FROM " + TABLE_ClIENT;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst())
        {
            do
            {
                String name = cursor.getString(0);
                int id = cursor.getInt(1);
                int salespotential = Integer.parseInt(cursor.getString(2));
                Client client = new Client(name,id, salespotential);
                clients.add(client);
            }
            while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return clients;

    }
}

