package DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import static DataBase.Tables.SignUp.COLUMN_USER_EMAIL;
import static DataBase.Tables.SignUp.COLUMN_USER_NAME;
import static DataBase.Tables.SignUp.COLUMN_USER_PASSWORD;
import static DataBase.Tables.SignUp.TABLE_NAME;


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
    public static final String CREATE_TABLE_SIGNUP =
            " CREATE TABLE " + Tables.SignUp.TABLE_NAME + " ( " +
                    Tables.SignUp.COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    COLUMN_USER_NAME + " TEXT," +
                    COLUMN_USER_EMAIL +  " TEXT," +
            COLUMN_USER_PASSWORD + " TEXT" + ")";

    public DataBaseHandler(Context context) {
        super(context,"newsdb",null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE_SIGNUP);
        sqLiteDatabase.execSQL(CREATE_TABLE_STUDENTRECORD);
        sqLiteDatabase.execSQL(CREATE_TABLE_ADMINRECORD);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        onCreate(db);

    }
    public void saveStudentRecord(String name,String fathername,String rolno,String address,String contact){
        SQLiteDatabase db=getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(Tables.Student.COLUMN_TITLEN,name);
        values.put(Tables.Student.COLUMN_TITLEF,fathername);
        values.put(Tables.Student.COLUMN_TITLER,rolno);
       // values.put(Tables.Student.COLUMN_TITLEA,address);
       // values.put(Tables.Student.COLUMN_TITLEC,phonno);
        db.insert(Tables.Student.TABLE_NAME,null,values);
    }
    public void addUser(SignupDataModel user) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_USER_NAME, user.getName());
        values.put(COLUMN_USER_EMAIL, user.getEmail());
        values.put(COLUMN_USER_PASSWORD, user.getPassword());
        db.insert(Tables.SignUp.TABLE_NAME, null, values);
        db.close();
    }
    public void saveAdminRecord(String aname,String apassword){
        SQLiteDatabase data=getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(Tables.Admin.COLUMN_ADMINNAME,aname);
        values.put(Tables.Admin.COLUMN_ADMINPASSWORD,apassword);
        data.insert(Tables.Admin.TABLE_NAME,null,values);
    }
    public ArrayList<SignupDataModel>getAllUser(){
        ArrayList<SignupDataModel> user=new ArrayList <>();
        SQLiteDatabase db=getWritableDatabase();
        String [] selection={Tables.SignUp.COLUMN_USER_NAME,Tables.SignUp.COLUMN_USER_PASSWORD};
        Cursor cursor=db.query(Tables.Admin.TABLE_NAME,selection,null,null,null,null,null);
        while (cursor.moveToNext()){
            SignupDataModel obj=new SignupDataModel();
            obj.setName(cursor.getString(0));
            obj.setEmail(cursor.getString(1));
            obj.setPassword(cursor.getString(2));
            user.add(obj);
        }
        cursor.close();
        return user;
        
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
    public ArrayList<StudentRecord> getAllStudent(){
        ArrayList<StudentRecord> student=new ArrayList <>();
        SQLiteDatabase db=getWritableDatabase();

        String[] selection = {Tables.Student.COLUMN_TITLER,Tables.Student.COLUMN_TITLEN};

        Cursor cursor = db.query(Tables.Student.TABLE_NAME, selection, null, null, null, null,null);
        while (cursor.moveToNext()) {
            StudentRecord obj = new StudentRecord();
            obj.setName(cursor.getString(0));
            obj.setFathername(cursor.getString(1));
            student.add(obj);
        }
        cursor.close();
        return student;
    }

}
