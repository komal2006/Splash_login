package com.example.splash_login;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {


    private EditText edtEmail;
    private EditText edtPassword;
    private Button btnLogin;
    private TextView txtMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    edtEmail = findViewById(R.id.edtEmail);
    edtPassword = findViewById(R.id.edtPassword);
    txtMsg = findViewById(R.id.txtMsg);

    btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(this);



    }



    private void showAlert()
    {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        //alertDialogBuilder.setIcon(R.drawable.ic_action_name);
        alertDialogBuilder.setTitle("login Error");
        alertDialogBuilder.setMessage("Please Enter correct Email or password");
        alertDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {

            }
        });
       // alertDialogBuilder.setNegativeButtonIcon(getResources().getDrawable(R.drawable.ic_action_name));
        AlertDialog mAlertDialog = alertDialogBuilder.create();
        mAlertDialog.show();
    }


    @Override
    public void onClick(View v) {
        String email = edtEmail.getText().toString();
        String pwd = edtPassword.getText().toString();

        //Check for empty and show error message

        if(email.trim().length() == 0 || TextUtils.isEmpty(email))
        {
            edtEmail.setError("Enter Email Id of user");
            return;
        }else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            edtEmail.setError("Enter Valid Email Id");
            return;
        }

        if(email.equals("komal@gmail.com") && pwd.equals("deep@123"))
        {
            txtMsg.setText("Login Success");
            txtMsg.setTextColor(Color.GREEN);


            //Navigate to NEXT Activity
            Intent mIntent = new Intent(LoginActivity.this, MainActivity.class);
            //Set value to pass on next activity
            mIntent.putExtra("name",edtEmail.getText().toString());
            startActivity(mIntent);
        }
        else
        {
            txtMsg.setText("Email/Password invalid");
            txtMsg.setTextColor(Color.RED);
            showAlert();
        }



    }
}
