package DataBase;

import android.provider.BaseColumns;

public class Tables {
    public static class Student implements BaseColumns{
        public static final String TABLE_NAME="studentRecord";
        public static final String COLUMN_TITLEN="studentname";
        public static final String COLUMN_TITLEF= "studentfathername";
        public static final String COLUMN_TITLER="studentrollno";
        public static final String COLUMN_TITLEA="studentaddress";
        public static final String COLUMN_TITLEC="studentcontact";
    }
    public class Admin implements BaseColumns{

        public static final String TABLE_NAME="adminrecord";
        public static final String COLUMN_ADMINNAME="adminname";
        public static final String COLUMN_ADMINPASSWORD="adminpassword";

    }
}
