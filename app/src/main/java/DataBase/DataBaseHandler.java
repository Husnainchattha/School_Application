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
    public static final String CREATE_TABLE_AYAT =
            " CREATE TABLE " + Tables.Student.TABLE_NAME + " ( " +
                    Tables.Student._ID + " TEXT PRIMARY KEY, " +
                    Tables.Student.COLUMN_TITLEN + " TEXT, " +
                    Tables.Student.COLUMN_TITLEF + " TEXT )" ;
    public static final String CREATE_TABLE_NOBLE=
            " CREATE TABLE " + Tables.Admin.TABLE_NAME + " ( " +
                    Tables.Admin._ID + " TEXT PRIMARY KEY, " +
                    Tables.Admin.COLUMN_ADMINNAME + " TEXT, " +
                    Tables.Admin.COLUMN_ADMINPASSWORD + " TEXT )";

    public DataBaseHandler(Context context) {
        super(context,"newsdb",null,1);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE_AYAT);
        sqLiteDatabase.execSQL(CREATE_TABLE_NOBLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public void saveAyat(String randomayat,String randomayyat ){
        SQLiteDatabase db=getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(Tables.Student.COLUMN_TITLEN,randomayat);
        values.put(Tables.Student.COLUMN_TITLEF,randomayyat);
        db.insert(Tables.Student.TABLE_NAME,null,values);
    }
    public void saveNoble(String quot,String writer){
        SQLiteDatabase data=getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(Tables.Admin.COLUMN_ADMINNAME,quot);
        values.put(Tables.Admin.COLUMN_ADMINPASSWORD,writer);
        data.insert(Tables.Admin.TABLE_NAME,null,values);
    }
    /*public ArrayList<DataBaseNoble>getAllNoble(){
        ArrayList<DataBaseNoble> nobles=new ArrayList <>();
        SQLiteDatabase db=getWritableDatabase();
        String [] selection={Tables.NobleTable.COLUMN_QUOT,Tables.NobleTable.COLUMN_WRITER};
        Cursor cursor=db.query(Tables.NobleTable.TABLE_NAME,selection,null,null,null,null,null);
        while (cursor.moveToNext()){
            DataBaseNoble noble=new DataBaseNoble();
            noble.setQuotby(cursor.getString(0));
            noble.setWriterby(cursor.getString(1));
            nobles.add(noble);
        }
        cursor.close();
        return nobles;
    }*/
    public ArrayList<DataModel> getAllAyat(){
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

   /* public DataBaseNoble getDataBaseNobleWhereTitle(String quot,String writer){
        SQLiteDatabase db=getWritableDatabase();
        String[]column={Tables.NobleTable.COLUMN_QUOT,Tables.NobleTable.COLUMN_WRITER};
        String selection=Tables.NobleTable.COLUMN_QUOT + " =?"+Tables.NobleTable.COLUMN_WRITER + " =?";
        String[]selectionArgs={quot,writer};

        Cursor cursor = db.query(Tables.NobleTable.TABLE_NAME, column, selection, selectionArgs,null, null,null,null);
        if (cursor.moveToNext()) {
            DataBaseNoble noble=new DataBaseNoble(cursor.getString(0),cursor.getString(1));
            cursor.close();
            return noble;
        }
        return null;
    }*/
    public DataModel getDataBaseAyatWhereTitle(String title,String title1){
        SQLiteDatabase db=getWritableDatabase();
        String[]column={Tables.Student.COLUMN_TITLEN,Tables.Student.COLUMN_TITLEF};
        String selection=Tables.Student.COLUMN_TITLEN + " =?"+Tables.Student.COLUMN_TITLEF + " =?";
        String[]selectionArgs={title,title1};

        Cursor cursor = db.query(Tables.Student.TABLE_NAME, column, selection, selectionArgs,null, null,null,null);
        if (cursor.moveToNext()) {
            DataModel ayat=new DataModel(cursor.getString(0),cursor.getString(1));
            cursor.close();
            return ayat;
        }
        return null;
    }
   /* public DataBaseHadith getDataBaseHadithWhereTitle(String title,String title1){
        SQLiteDatabase db=getWritableDatabase();
        String[]column={Tables.HadithTable.COLUMN_HADITH,Tables.HadithTable.COLUMN_HWRITER};
        String selection=Tables.HadithTable.COLUMN_HADITH + " =?"+Tables.HadithTable.COLUMN_HWRITER + " =?";
        String[]selectionArgs={title,title1};

        Cursor cursor = db.query(Tables.HadithTable.TABLE_NAME, column, selection, selectionArgs,null, null,null,null);
        if (cursor.moveToNext()) {
            DataBaseHadith hadith=new DataBaseHadith(cursor.getString(0),cursor.getString(1));
            cursor.close();
            return hadith;
        }
        return null;
    }*/
/*
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
       db.execSQL("DROP TABLE IF EXISTS " + CREATE_TABLE_ADMIN + CREATE_TABLE_STUDENT );
       onCreate(db);
    }

    // insert value in the table of student
    public void addInfo(DataModel dataModel) {
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put(Tables.Student.COLUMN_TITLEN, dataModel.getName());
        values.put(Tables.Student.COLUMN_TITLEF, dataModel.getFathername());
        values.put(Tables.Student.COLUMN_TITLER, dataModel.getRollno());
        values.put(Tables.Student.COLUMN_TITLEA, dataModel.getAddress());
        values.put(Tables.Student.COLUMN_TITLEC, dataModel.getContact());

        db.insert(CREATE_TABLE_STUDENT, null, values);
        db.close();
    }
    // Data Reade from database

    public ArrayList<DataModel>studentdata(){
        ArrayList<DataModel> student=new ArrayList <>();
        SQLiteDatabase db=getWritableDatabase();
        String [] selection={Tables.Student.COLUMN_TITLEN,Tables.Student.COLUMN_TITLEF};
        Cursor cursor=db.query(Tables.Student.TABLE_NAME,selection,null,null,null,null,null);
        while (cursor.moveToNext()){
            DataModel data=new DataModel();
            data.setName(cursor.getString(0));
            data.setFathername(cursor.getString(1));
            student.add(data);
        }
        cursor.close();
        return student;

    }
    public ArrayList<DataModel> studentdata(){
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
    }*/
}
