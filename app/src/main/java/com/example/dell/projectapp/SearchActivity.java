package com.example.dell.projectapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SearchActivity extends AppCompatActivity {

    DatabaseHelper myDb1;
    EditText editId1,editName1,editDesign1,editDept1,editLoc1,editLand1,editMob1;
    Button btn_find1;
    TextView showText;
    StringBuffer buffer1;
    int cursor_count;

    //strings for creating dynamic sql query
    String editid,editname,editdesign,editdept,editloc,editland,editmob,the_query;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        myDb1 = new DatabaseHelper(this);

        editId1 = (EditText)findViewById(R.id.s_id);
        editName1 = (EditText)findViewById(R.id.s_name);
        editDesign1 = (EditText)findViewById(R.id.s_design);
        editDept1 = (EditText)findViewById(R.id.s_dept);
        editLoc1 = (EditText)findViewById(R.id.s_loc);
        editLand1 = (EditText)findViewById(R.id.s_land);
        editMob1 = (EditText)findViewById(R.id.s_mob);

        btn_find1 =(Button)findViewById(R.id.button4);
        findData();

    }

    public void findData(){
        btn_find1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        editid = editId1.getText().toString().trim();
                        editname = editName1.getText().toString().trim();
                        editdesign = editDesign1.getText().toString().trim();
                        editdept = editDept1.getText().toString().trim();
                        editloc = editLoc1.getText().toString().trim();
                        editland = editLand1.getText().toString().trim();
                        editmob = editMob1.getText().toString().trim();

                        //debugging
                        //System.out.println("Tsunade" + editid + " " + editname + " " + editdesign + " " + editdept + " " + editloc);
                        // works fine

                        the_query = "SELECT * FROM "+ myDb1.TABLE_NAME+" WHERE 1=1";

                        //constructing the_query properly

                        //editid
                        if(editid.equals(""))
                            the_query+="";
                        else
                            the_query+=" AND ID= \""+ editid+"\"";

                        //editname
                        if(editname.equals(""))
                            the_query+="";
                        else
                            the_query+=" AND NAME= \""+ editname+"\"";

                        //editdesign
                        if(editdesign.equals(""))
                            the_query+="";
                        else
                            the_query+=" AND DESIGNATION= \""+ editdesign+"\"";

                        //editdept
                        if(editdept.equals(""))
                            the_query+="";
                        else
                            the_query+=" AND DEPARTMENT= \""+ editdept+"\"";

                        //editloc
                        if(editloc.equals(""))
                            the_query+="";
                        else
                            the_query+=" AND LOCATION= \""+ editloc+"\" ";

                        //editland
                        if(editland.equals(""))
                            the_query+="";
                        else
                            the_query+=" AND LOCATION= \""+ editland+"\" ";

                        //editmob
                        if(editmob.equals(""))
                            the_query+="";
                        else
                            the_query+=" AND LOCATION= \""+ editmob+"\" ";

                        //the_query+=" COLLATE NOCASE ;";
                        the_query+=";";

                        //debugging
                        System.out.println("Kakashi: the_query" + the_query);
                        // queries constructed correctly :)

                        Cursor res1 = myDb1.queryData(the_query);

                        if(res1.getCount()==-1){
                            //show message
                            showMessage1("Error!","Nothing Found!");
                        }
                        else {
                            buffer1 = new StringBuffer();
                            while(res1.moveToNext()){
                                buffer1.append("ID : " + res1.getString(0) + "\n");
                                buffer1.append("NAME : " + res1.getString(1) + "\n");
                                buffer1.append("DESIGN : " + res1.getString(2) + "\n");
                                buffer1.append("LANDLINE : " + res1.getString(3) + "\n");
                                buffer1.append("MOBILE : " + res1.getString(4) + "\n");
                                buffer1.append("DEPARTMENT : " + res1.getString(5) + "\n");
                                buffer1.append("LOCATION : " + res1.getString(6) + "\n\n");
                            }
                            //showMessage1("Data",buffer1.toString());
                            System.out.println("data bhai"+ buffer1.toString());
                            System.out.println("Kurotsuchi "+ res1.getCount());
                            cursor_count =res1.getCount();

                        }

                        Intent intent1 = new Intent(SearchActivity.this, DisplayActivity.class);
                        intent1.putExtra("message",buffer1.toString());
                        intent1.putExtra("cur_len",String.valueOf(cursor_count));
                        //System.out.println("ino btn_out onClickListener: "+ buffer1.toString());//yes data is getting passed
                        startActivity(intent1);
                    }
                }
        );
    }

    public void showMessage1(String title1,String Message1){


        AlertDialog.Builder builder1 = new AlertDialog.Builder(SearchActivity.this);
        builder1.setCancelable(true).setMessage(Message1).setNegativeButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                dialog.cancel();
            }
        });
        AlertDialog alert = builder1.create();
        alert.setTitle(title1);
        alert.show();


        //debugging
        System.out.println("showMessage function called");
        System.out.println("Title : " + title1);
        System.out.println("Yennaku Message : " + Message1);
    }
}
