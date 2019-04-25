package com.example.gyana.demoofsql;

import android.app.AlertDialog;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText e1,e2,e3;
    Button b1,b2;

    MyDatabase myDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDatabase=new MyDatabase(this);

        e1=findViewById(R.id.et_nem);
        e2=findViewById(R.id.et_sur);
        e3=findViewById(R.id.et_roll);
        b1=findViewById(R.id.btn_save);
        b2=findViewById(R.id.btn_read);
      //  b3=findViewById(R.id.btn_update);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean isInsert=myDatabase.isInserted(e1.getText().toString(),e2.getText().toString(),e3.getText().toString());

                if (isInsert=true)
                {
                    Toast.makeText(MainActivity.this, "Data is Saved Successfully", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Data is Not Inserted", Toast.LENGTH_SHORT).show();
                }

            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Cursor res=myDatabase.getAllData();

                if (res.getCount()==0)
                {
                    showMessage("Error","No Data");
                }
                else
                {
                    StringBuffer buffer=new StringBuffer();

                    while (res.moveToNext())
                    {
                        buffer.append("ID: "+res.getString(0)+"\n");
                        buffer.append("Name: "+res.getString(1)+"\n");
                        buffer.append("Surname: "+res.getString(2)+"\n");
                        buffer.append("RollNo: "+res.getString(3)+"\n\n");
                    }
                    showMessage("Data",buffer.toString());
                }


            }
        });

        /*b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name=e1.getText().toString();
                myDatabase.update();



            }
        });*/

    }

    public  void showMessage(String title,String message)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);

        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

}

/*
 <Button
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Update"
        android:id="@+id/btn_update"/>
 */
