package DataBase;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DataBaseHandler extends SQLiteOpenHelper {
    public static final String CREATE_TABLE_STUDENT =
            " CREATE TABLE  " + Tables.Student.TABLE_NAME + " ( " +
                    Tables.Student._ID + " TEXT PRIMARY KEY, " +
              Tables.Student.COLUMN_TITLEN + " TEXT, " +
                    Tables.Student.COLUMN_TITLEF + " TEXT, " +
                    Tables.Student.COLUMN_TITLER + " TEXT, " +
                    Tables.Student.COLUMN_TITLEA + " TEXT, " +
                    Tables.Student.COLUMN_TITLEC + " TEXT) ";
    public static final String CREATE_TABLE_ADMIN  =
            " CREATE TABLE " + Tables.Admin.TABLE_NAME + " ( " +
                    Tables.Admin._ID + " TEXT PRIMARY KEY, " +
                    Tables.Admin.COLUMN_ADMINPASSWORD + " TEXT) ";
    public DataBaseHandler(Context context) {
        super(context, "studentdb", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
         db.execSQL(CREATE_TABLE_STUDENT);
         db.execSQL(CREATE_TABLE_ADMIN);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
