package com.example.dell.projectapp;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn_add,btn_search;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        onButtonClickListenerAdd();
        onButtonClickListenerSearch();
    }

    public void onButtonClickListenerAdd(){
        btn_add = (Button)findViewById(R.id.button);
        btn_add.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent1 = new Intent("com.example.dell.projectapp.AddActivity");
                        startActivity(intent1);
                        //debugging
                        //System.out.println("Naruto");
                    }
                }
        );
    }
    public void onButtonClickListenerSearch(){
        btn_search = (Button)findViewById(R.id.button2);
        btn_search.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent2 = new Intent("com.example.dell.projectapp.SearchActivity");
                        startActivity(intent2);
                    }
                }
        );
    }
}
