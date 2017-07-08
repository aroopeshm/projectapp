package com.example.dell.projectapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class HomeActivity extends AppCompatActivity {

    EditText editUser,editPass;
    Button btn_login;
    TextView txt_link;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        editUser = (EditText)findViewById(R.id.editText_username);
        editPass = (EditText)findViewById(R.id.editText_password);
        btn_login = (Button)findViewById(R.id.button6);
        txt_link = (TextView)findViewById(R.id.textView21);

        editUser.requestFocus();
        loginButton();
        onTextViewClickListener();
        onLongClickListener();

    }

    public void loginButton(){
        btn_login.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(editUser.getText().toString().trim().equals("lucian") && editPass.getText().toString().trim().equals("lucian")){
                            Toast.makeText(HomeActivity.this,"Login Successful", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent("com.example.dell.projectapp.MainActivity");
                            startActivity(intent);
                        }
                        else {

                            Toast.makeText(HomeActivity.this,"Login Unsuccessful",Toast.LENGTH_SHORT).show();

                        }

                    }
                }
        );
    }

    public void onTextViewClickListener(){
        txt_link.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent1 = new Intent("com.example.dell.projectapp.SearchActivity");
                        startActivity(intent1);
                    }
                }
        );
    }

    public void onLongClickListener(){
        txt_link.setOnLongClickListener(
                new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {
                        Toast.makeText(HomeActivity.this,"Click Here to skip login and continue as a Guest User",Toast.LENGTH_SHORT).show();
                        return true;
                    }
                }
        );
    }
}
