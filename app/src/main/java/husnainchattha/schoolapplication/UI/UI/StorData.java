package husnainchattha.schoolapplication.UI.UI;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import DataBase.DataBaseHandler;
import husnainchattha.schoolapplication.R;

public class StorData extends AppCompatActivity {
private EditText name,fname,rollno,address,contact;
private DataBaseHandler db;
private String s_name,s_fname,s_rollno,s_address,s_contact;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stor_data);
        db=new DataBaseHandler(this);
        name=findViewById(R.id.storname);
        name=findViewById(R.id.storfathername);

        name=findViewById(R.id.storrollno);

        name=findViewById(R.id.storaddress);

        name=findViewById(R.id.storcontact);

    }
    public void buttonClicked(View v){
        int id=v.getId();

        switch(id){

            case R.id.submitt:
                addContact();

                break;

        }
    }

}
