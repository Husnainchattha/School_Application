package husnainchattha.schoolapplication.UI.UI;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import DataBase.DataBaseHandler;
import husnainchattha.schoolapplication.R;

public class StorData extends AppCompatActivity {
private EditText sname,fname,rollno,address,contact;
private DataBaseHandler db;
private String s_name,s_fname,s_rollno,s_address,s_contact;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stor_data);
        db=new DataBaseHandler(this);
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

        db.addContacts(new Contact(f_name, s_name, p_no));
        Toast.makeText(getApplicationContext(),"Saved successfully", Toast.LENGTH_LONG).show();
    }

}
