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
private EditText sname,fname,rollno,address,phone;
private DataBaseHandler db;
private String s_name,s_fname,s_rollno,s_address,p_no;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stor_data);
       /* db=new DataBaseHandler(this);
        sname=findViewById(R.id.storname);
        fname=findViewById(R.id.storfathername);

        rollno=findViewById(R.id.storrollno);

        address=findViewById(R.id.storaddress);

        contact=findViewById(R.id.storcontact);

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
        s_fname = fname.getText().toString();
        s_name = sname.getText().toString();
        s_rollno = rollno.getText().toString();
        s_address=address.getText().toString();
        s_contact=contact.getText().toString();

    }

    //Function Insert data to the database
    private void addContact(){
        getValues();
        db.addContacts(new DataModel(s_name,s_fname,s_contact));
        Toast.makeText(getApplicationContext(),"Saved successfully", Toast.LENGTH_LONG).show();
    }*/

        //Instantiate database handler
        db=new DataBaseHandler(this);
      //  db=new DatabaseHandler(this);


        fname=(EditText) findViewById(R.id.storfathername);
        sname=(EditText) findViewById(R.id.storname);
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
     String   s_fname = fname.getText().toString();
    String    s_name = sname.getText().toString();
     String   p_no = phone.getText().toString();
    }

    //Function Insert data to the database
    private void addContact(){
        getValues();

        db.saveAyat(s_name,s_fname);
        Toast.makeText(getApplicationContext(),"Saved successfully", Toast.LENGTH_LONG).show();
    }
    }

