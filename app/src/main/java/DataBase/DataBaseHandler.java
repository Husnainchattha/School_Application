package DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.hardware.camera2.CaptureRequest;

import java.util.ArrayList;
import java.util.List;


public class DataBaseHandler extends SQLiteOpenHelper {
    public static final String CREATE_TABLE_STUDENTRECORD =
            " CREATE TABLE " + Tables.Student.TABLE_NAME + " ( " +
                    Tables.Student._ID + " TEXT PRIMARY KEY, " +
                    Tables.Student.COLUMN_TITLEN + " TEXT, " +
                    Tables.Student.COLUMN_TITLEF + " TEXT, " +
                    Tables.Student.COLUMN_TITLER + " TEXT, " +
                    Tables.Student.COLUMN_TITLEA + " TEXT, " +
                    Tables.Student.COLUMN_TITLEC + " TEXT) ";
    public static final String CREATE_TABLE_ADMINRECORD=
            " CREATE TABLE " + Tables.Admin.TABLE_NAME + " ( " +
                    Tables.Admin._ID + " TEXT PRIMARY KEY, " +
                    Tables.Admin.COLUMN_ADMINNAME + " TEXT, " +
                    Tables.Admin.COLUMN_ADMINPASSWORD + " TEXT )";

    public DataBaseHandler(Context context) {
        super(context,"newsdb",null,1);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE_STUDENTRECORD);
        sqLiteDatabase.execSQL(CREATE_TABLE_ADMINRECORD);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        onCreate(db);

    }
    public void saveStudentRecord(String name,String fathername,String rollno,String address,String phonno ){
        SQLiteDatabase db=getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(Tables.Student.COLUMN_TITLEN,name);
        values.put(Tables.Student.COLUMN_TITLEF,fathername);
        values.put(Tables.Student.COLUMN_TITLEF,rollno);
        //values.put(Tables.Student.COLUMN_TITLEA,address);
        //values.put(Tables.Student.COLUMN_TITLEC,phonno);
        db.insert(Tables.Student.TABLE_NAME,null,values);
    }
    public void saveAdminRecord(String aname,String apassword){
        SQLiteDatabase data=getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(Tables.Admin.COLUMN_ADMINNAME,aname);
        values.put(Tables.Admin.COLUMN_ADMINPASSWORD,apassword);
        data.insert(Tables.Admin.TABLE_NAME,null,values);
    }
    public ArrayList<AdminDataModel>getAllAdmin(){
        ArrayList<AdminDataModel> nobles=new ArrayList <>();
        SQLiteDatabase db=getWritableDatabase();
        String [] selection={Tables.Admin.COLUMN_ADMINNAME,Tables.Admin.COLUMN_ADMINPASSWORD};
        Cursor cursor=db.query(Tables.Admin.TABLE_NAME,selection,null,null,null,null,null);
        while (cursor.moveToNext()){
            AdminDataModel noble=new AdminDataModel();
            noble.setAdminname(cursor.getString(0));
            noble.setAdminpassword(cursor.getString(1));
            nobles.add(noble);
        }
        cursor.close();
        return nobles;
    }
    public ArrayList<DataModel> getAllStudent(){
        ArrayList<DataModel> ayat=new ArrayList <>();
        SQLiteDatabase db=getWritableDatabase();

        String[] selection = {Tables.Student.COLUMN_TITLEN,Tables.Student.COLUMN_TITLEF};

        Cursor cursor = db.query(Tables.Student.TABLE_NAME, selection, null, null, null, null,null);
        while (cursor.moveToNext()) {
            DataModel ayat1 = new DataModel();
            ayat1.setName(cursor.getString(0));
            ayat1.setFathername(cursor.getString(1));
            ayat.add(ayat1);
        }
        cursor.close();
        return ayat;
    }

}
