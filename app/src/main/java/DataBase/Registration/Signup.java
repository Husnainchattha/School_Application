package DataBase.Registration;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import husnainchattha.schoolapplication.R;

public class Signup extends AppCompatActivity {
    private static final String TAG = "LoginActivity";
    private static final int REQUEST_SIGNUP = 0;
    TextView signup;
    EditText _name,_email,_password;
    Button btnlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        _name = findViewById(R.id.input_name);
        _email = findViewById(R.id.input_email);
        _password = findViewById(R.id.input_password);
        signup = findViewById(R.id.link_login);
        btnlogin = findViewById(R.id.btn_signup);
    }
}
