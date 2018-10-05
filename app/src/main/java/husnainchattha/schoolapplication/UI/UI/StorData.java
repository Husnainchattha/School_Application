package husnainchattha.schoolapplication.UI.UI;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import DataBase.DataBaseHandler;
import DataBase.DataModel;
import husnainchattha.schoolapplication.R;

public class StorData extends AppCompatActivity {
    public static final String DataBaseHandler= "mydatabase";
private EditText sname,fname,srno,address,phone;
private DataBaseHandler db;
public String s_name,s_fname,s_rollno,s_address,p_no;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stor_data);



        db=new DataBaseHandler(this);


        fname=(EditText) findViewById(R.id.storfathername);
        sname=(EditText) findViewById(R.id.storname);
        srno=(EditText) findViewById(R.id.storrollno);
        address=(EditText)findViewById(R.id.storaddress);
        phone=(EditText) findViewById(R.id.storcontact);
    }
    public void Clicked(View view){
        Intent intent= new Intent(this,StudentName.class);
        startActivity(intent);
    }

    public void buttonClicked(View v){
        int id=v.getId();

        switch(id){

            case R.id.submitt:
                addContact();

                break;

        }
    }

    // function to get values from the Edittext
    private void getValues(){
            s_name = sname.getText().toString();
       s_fname = fname.getText().toString();
    s_rollno=srno.getText().toString();
    s_address=address.getText().toString();
        p_no = phone.getText().toString();
    }

    //Function Insert data to the database
    private void addContact(){
        getValues();



        db.saveStudentRecord(s_name,s_fname,s_rollno,s_address,p_no);
        Toast.makeText(getApplicationContext(),"Saved successfully", Toast.LENGTH_LONG).show();
    }
    }

