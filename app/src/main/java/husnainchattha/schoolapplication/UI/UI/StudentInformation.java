package husnainchattha.schoolapplication.UI.UI;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import DataBase.DataBaseHandler;
import DataBase.DataModel;
import husnainchattha.schoolapplication.R;

import static java.security.AccessController.getContext;

public class StudentInformation extends AppCompatActivity {

    ArrayList<DataModel> dataModels;
    SQLiteDatabase msqlitedatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_information);
        DataBaseHandler handler=new DataBaseHandler(this);
        List<DataModel> school=handler.getAllStudent();
        DataModel ayat=new DataModel();
        TextView textView=findViewById(R.id.storname);
        TextView textView1=findViewById(R.id.storfathername);
       // textView.setText(ayat.getFathername());
        textView1.setText(ayat.getFathername());

    }

}
