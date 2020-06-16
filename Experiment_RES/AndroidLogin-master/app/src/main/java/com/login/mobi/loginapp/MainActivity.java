package com.login.mobi.loginapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button btSignIn;
    private Button btSignUp;
    private EditText edtEmail;
    private EditText edtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btSignIn = findViewById(R.id.btSignIn);
        btSignUp = findViewById(R.id.btSignUp);

        edtEmail = findViewById(R.id.emailinput);
        edtPassword = findViewById(R.id.passwordinput);

        final DatabaseHelper dbHelper = new DatabaseHelper(this);

        btSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!emptyValidation()) {
                    dbHelper.addUser(new User(edtEmail.getText().toString(), edtPassword.getText().toString()));
                    Toast.makeText(MainActivity.this, "Added User", Toast.LENGTH_SHORT).show();
                    edtEmail.setText("");
                    edtPassword.setText("");
                } else {
                    Toast.makeText(MainActivity.this, "Empty Fields", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!emptyValidation()) {
                    final User user = dbHelper.queryUser(edtEmail.getText().toString(), edtPassword.getText().toString());
                    if (user != null) {
                        final Bundle mBundle = new Bundle();
                        mBundle.putString("user", user.getEmail());
                        // showing a progress bar
                        final ProgressDialog progressDialog = new ProgressDialog(MainActivity.this,
                                R.style.Theme_AppCompat_DayNight_Dialog);
                        progressDialog.setIndeterminate(true);
                        progressDialog.setMessage("Authenticating...");
                        progressDialog.show();
                        // progress bar is now visible to the user
                        new android.os.Handler().postDelayed(
                                new Runnable() {
                                    @Override
                                    public void run() {
                                        Intent intent = new Intent(MainActivity.this, UserActivity.class);
                                        intent.putExtras(mBundle);
                                        startActivity(intent);
                                        Toast.makeText(MainActivity.this, "Welcome " + user.getEmail(), Toast.LENGTH_SHORT).show();
                                    }
                                },
                                4000);
                    } else {
                        Toast.makeText(MainActivity.this, "User not found", Toast.LENGTH_SHORT).show();
                        edtPassword.setText("");
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Empty Fields", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    private boolean emptyValidation() {
        if (TextUtils.isEmpty(edtEmail.getText().toString()) || TextUtils.isEmpty(edtPassword.getText().toString())) {
            return true;
        } else {
            return false;
        }
    }
}
