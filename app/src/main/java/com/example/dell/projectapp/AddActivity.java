package com.example.dell.projectapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddActivity extends AppCompatActivity {

    DatabaseHelper myDb;
    EditText editId,editName,editDesign,editLand,editMob,editDept,editLoc;
    Button btn_add,btn_update,btn_delete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        myDb = new DatabaseHelper(this);

        editId =(EditText)findViewById(R.id.edit_id);
        editName =(EditText)findViewById(R.id.edit_name);
        editDesign =(EditText)findViewById(R.id.edit_design);
        editLand =(EditText)findViewById(R.id.edit_land);
        editMob =(EditText)findViewById(R.id.edit_mob);
        editDept =(EditText)findViewById(R.id.edit_dept);
        editLoc =(EditText)findViewById(R.id.edit_loc);
        btn_add = (Button)findViewById(R.id.button3);
        btn_update = (Button)findViewById(R.id.button5);
        btn_delete = (Button)findViewById(R.id.button8);

        AddData();
        UpdateData();
        DeleteData();
        //debugging
        System.out.println("Typecasting working fine");
    }

    public void AddData(){
        btn_add.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        //debugging
                        System.out.println("Sakura1");// till here working fine
                        boolean isInserted = myDb.insertData(Integer.parseInt(String.valueOf(editId.getText()).trim()), editName.getText().toString().trim(),
                                                            editDesign.getText().toString().trim(), editLand.getText().toString().trim(),
                                                            editMob.getText().toString().trim(), editDept.getText().toString().trim(),
                                                            editLoc.getText().toString().trim());
                        //debugging
                        System.out.println("Sakura2");

                        if(isInserted == true) {
                            Toast.makeText(AddActivity.this, "Data inserted successfully", Toast.LENGTH_SHORT).show();
                            //instead of "AddActivity.this" u can also use "getApplicationContext()"
                            System.out.println("true");

                        }
                        else {
                            Toast.makeText(AddActivity.this, "Data not inserted ", Toast.LENGTH_SHORT).show();
                            System.out.println("false");
                        }


                    }
                }
        );
    }
        public void UpdateData() {
            btn_update.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            boolean isUpdated = myDb.updateData(Integer.parseInt(String.valueOf(editId.getText()).trim()), editName.getText().toString().trim(),
                                    editDesign.getText().toString().trim(), editLand.getText().toString().trim(),
                                    editMob.getText().toString().trim(), editDept.getText().toString().trim(),
                                    editLoc.getText().toString().trim());

                            if(isUpdated == true) {
                                Toast.makeText(AddActivity.this, "Data updated successfully", Toast.LENGTH_SHORT).show();
                                //instead of "AddActivity.this" u can also use "getApplicationContext()"
                                System.out.println("true");

                            }
                            else {
                                Toast.makeText(AddActivity.this, "Data not updated ", Toast.LENGTH_SHORT).show();
                                System.out.println("false");
                            }
                        }
                    }
            );
        }

        public void DeleteData(){
            btn_delete.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Integer deletedRows = myDb.deleteData(editId.getText().toString());
                            if(deletedRows>0)
                                Toast.makeText(AddActivity.this, "Data deleted ", Toast.LENGTH_SHORT).show();
                            else
                                Toast.makeText(AddActivity.this, "Data not deleted ", Toast.LENGTH_SHORT).show();
                        }
                    }
            );
        }

}
