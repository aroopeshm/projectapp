package com.example.dell.projectapp;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DisplayActivity extends AppCompatActivity {

    Bundle bundle;
    int row_count;
    List<String> myList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        bundle = getIntent().getExtras();
        String message = bundle.getString("message");

        System.out.println("onCreate ke andar");
        myList = new ArrayList<String>(Arrays.asList(message.split("\\s+")));

        init();
    }

    public void init() {

        String[] arr = myList.toArray(new String[myList.size()]);

        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i].replaceAll("[^\\w]", "");// after doing this whatever it is, each of the element in words[] is a single word!!!! hurray!!
        }

        //debugging
        for (int i = 0; i < arr.length; i++) {
            System.out.print("Temari" + i + " "+arr[i] + "\n");
        }

        System.out.println("arr.length" + arr.length);
        row_count = arr.length/7;

        TableLayout stk = (TableLayout) findViewById(R.id.table_disp);

        TableRow tbrow0 = new TableRow(this);

        TextView tv0 = new TextView(this);
        tv0.setText(" ID ");
        tv0.setTextColor(Color.WHITE);
        tbrow0.addView(tv0);

        TextView tv1 = new TextView(this);
        tv1.setText(" NAME ");
        tv1.setTextColor(Color.WHITE);
        tbrow0.addView(tv1);

        TextView tv2 = new TextView(this);
        tv2.setText(" DESIGNATION ");
        tv2.setTextColor(Color.WHITE);
        tbrow0.addView(tv2);

        TextView tv3 = new TextView(this);
        tv3.setText(" LANDLINE ");
        tv3.setTextColor(Color.WHITE);
        tbrow0.addView(tv3);

        TextView tv4 = new TextView(this);
        tv4.setText(" CALL ");
        tv4.setTextColor(Color.WHITE);
        tbrow0.addView(tv4);

        TextView tv5 = new TextView(this);
        tv5.setText(" MOBILE ");
        tv5.setTextColor(Color.WHITE);
        tbrow0.addView(tv5);

        TextView tv6 = new TextView(this);
        tv6.setText(" CALL ");
        tv6.setTextColor(Color.WHITE);
        tbrow0.addView(tv6);

        TextView tv7 = new TextView(this);
        tv7.setText(" DEPARTMENT ");
        tv7.setTextColor(Color.WHITE);
        tbrow0.addView(tv7);

        TextView tv8 = new TextView(this);
        tv8.setText(" LOCATION ");
        tv8.setTextColor(Color.WHITE);
        tbrow0.addView(tv8);

        stk.addView(tbrow0);

        int c=0;


        /*
        for (int i = 2; i < arr.length;i+=21 ) { // i need this loop to run for row_count  number of times only!!
            TableRow tbrow = new TableRow(this);

            TextView t1v = new TextView(this);
            t1v.setText(String.valueOf(i+c));
            t1v.setTextColor(Color.WHITE);
            t1v.setGravity(Gravity.CENTER);
            tbrow.addView(t1v);
            c+=3;

            TextView t2v = new TextView(this);
            t2v.setText(String.valueOf(i+c));
            t2v.setTextColor(Color.WHITE);
            t2v.setGravity(Gravity.CENTER);
            tbrow.addView(t2v);
            c+=3;

            TextView t3v = new TextView(this);
            t3v.setText(String.valueOf(i+c));
            t3v.setTextColor(Color.WHITE);
            t3v.setGravity(Gravity.CENTER);
            tbrow.addView(t3v);
            c+=3;

            TextView t4v = new TextView(this);
            t4v.setText(String.valueOf(i+c));
            t4v.setTextColor(Color.WHITE);
            t4v.setGravity(Gravity.CENTER);
            tbrow.addView(t4v);
            c+=3;

            TextView t5v = new TextView(this);
            t5v.setText(String.valueOf(i+c));
            t5v.setTextColor(Color.WHITE);
            t5v.setGravity(Gravity.CENTER);
            tbrow.addView(t5v);
            c+=3;

            TextView t6v = new TextView(this);
            t6v.setText(String.valueOf(i+c));
            t6v.setTextColor(Color.WHITE);
            t6v.setGravity(Gravity.CENTER);
            tbrow.addView(t6v);
            c+=3;

            TextView t7v = new TextView(this);
            t7v.setText(String.valueOf(i+c));
            t7v.setTextColor(Color.WHITE);
            t7v.setGravity(Gravity.CENTER);
            tbrow.addView(t7v);
            c=0;

            stk.addView(tbrow);
        }*/


        /* don't touch this code!!!!!!!!!!!!
        for (int i = 2; i < arr.length; i+=21) { // i need this loop to run for row_count  number of times only!!
            TableRow tbrow = new TableRow(this);

            TextView t1v = new TextView(this);
            t1v.setText(arr[i+c]);
            t1v.setTextColor(Color.WHITE);
            t1v.setGravity(Gravity.CENTER);
            tbrow.addView(t1v);
            c+=3;

            TextView t2v = new TextView(this);
            t2v.setText(arr[i+c]);
            t2v.setTextColor(Color.WHITE);
            t2v.setGravity(Gravity.CENTER);
            tbrow.addView(t2v);
            c+=3;

            TextView t3v = new TextView(this);
            t3v.setText(arr[i+c]);
            t3v.setTextColor(Color.WHITE);
            t3v.setGravity(Gravity.CENTER);
            tbrow.addView(t3v);
            c+=3;

            TextView t4v = new TextView(this);
            t4v.setText(arr[i+c]);
            t4v.setTextColor(Color.WHITE);
            t4v.setGravity(Gravity.CENTER);
            tbrow.addView(t4v);
            c+=3;

            TextView t5v = new TextView(this);
            t5v.setText(arr[i+c]);
            t5v.setTextColor(Color.WHITE);
            t5v.setGravity(Gravity.CENTER);
            tbrow.addView(t5v);
            c+=3;

            TextView t6v = new TextView(this);
            t6v.setText(arr[i+c]);
            t6v.setTextColor(Color.WHITE);
            t6v.setGravity(Gravity.CENTER);
            tbrow.addView(t6v);
            c+=3;

            TextView t7v = new TextView(this);
            t7v.setText(arr[i+c]);
            t7v.setTextColor(Color.WHITE);
            t7v.setGravity(Gravity.CENTER);
            tbrow.addView(t7v);
            c=0;

            stk.addView(tbrow);
        } */

        for (int i = 2; i < arr.length; i+=21) { // i need this loop to run for row_count  number of times only!!
            TableRow tbrow = new TableRow(this);

            TextView t1v = new TextView(this);
            t1v.setText(arr[i+c]);
            t1v.setTextColor(Color.WHITE);
            t1v.setGravity(Gravity.CENTER);
            tbrow.addView(t1v);
            c+=3; //c=3

            TextView t2v = new TextView(this);
            t2v.setText(arr[i+c]);
            t2v.setTextColor(Color.WHITE);
            t2v.setGravity(Gravity.CENTER);
            tbrow.addView(t2v);
            c+=3; //c=6

            TextView t3v = new TextView(this);
            t3v.setText(arr[i+c]);
            t3v.setTextColor(Color.WHITE);
            t3v.setGravity(Gravity.CENTER);
            tbrow.addView(t3v);
            c+=3; //c=9

            final TextView t4v = new TextView(this);
            t4v.setText(arr[i+c]);
            t4v.setTextColor(Color.WHITE);
            t4v.setGravity(Gravity.CENTER);
            tbrow.addView(t4v);
            c+=3;  //c=12

            Button btn_phone = new Button(this);
            btn_phone.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent callIntent1 = new Intent(Intent.ACTION_CALL);
                            callIntent1.setData(Uri.parse("tel:"+t4v.getText().toString()));

                            if(ActivityCompat.checkSelfPermission(DisplayActivity.this, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){return;}
                            startActivity(callIntent1);
                        }
                    }
            );
            btn_phone.setText("Press");
            tbrow.addView(btn_phone);


            final TextView t6v = new TextView(this);
            t6v.setText(arr[i+c]);
            t6v.setTextColor(Color.WHITE);
            t6v.setGravity(Gravity.CENTER);
            tbrow.addView(t6v);
            c+=3; //c=15

            btn_phone = new Button(this);
            btn_phone.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent callIntent = new Intent(Intent.ACTION_CALL);
                            callIntent.setData(Uri.parse("tel:"+t6v.getText().toString()));

                            if(ActivityCompat.checkSelfPermission(DisplayActivity.this, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){return;}
                            startActivity(callIntent);
                        }
                    }
            );
            btn_phone.setText("Press");
            tbrow.addView(btn_phone);



            TextView t8v = new TextView(this);
            t8v.setText(arr[i+c]);
            t8v.setTextColor(Color.WHITE);
            t8v.setGravity(Gravity.CENTER);
            tbrow.addView(t8v);
            c+=3;   //c=18

            TextView t9v = new TextView(this);
            t9v.setText(arr[i+c]);
            t9v.setTextColor(Color.WHITE);
            t9v.setGravity(Gravity.CENTER);
            tbrow.addView(t9v);
            c=0;

            stk.addView(tbrow);
        }


    }
}
