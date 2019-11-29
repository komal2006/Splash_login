package com.example.splash_login;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle mBundle = getIntent().getExtras();
        if(mBundle != null)
        {
            String name = mBundle.getString("name");
            Log.d("NAME", name);
        }
    }

    @Override
    public void onBackPressed()
    {
        //super.onBackPressed();
        showAlert();
    }

    private void showAlert()
    {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
       // alertDialogBuilder.setIcon(R.drawable.ic_action_name);
        alertDialogBuilder.setTitle("Back");
        alertDialogBuilder.setMessage("Are you sure you want to go back");
        alertDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which)
            {
                finish();
            }
        });
      //  alertDialogBuilder.setNegativeButtonIcon(getResources().getDrawable(R.drawable.ic_action_name));
        AlertDialog mAlertDialog = alertDialogBuilder.create();
        mAlertDialog.show();
    }
}
