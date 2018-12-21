package com.osmanforhad.firstapplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button b;
    ListView lv;
    //This is The Main Method
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b = (Button) findViewById(R.id.mybutton);
        lv = (ListView) findViewById(R.id.lvid);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //For Alert Dialog Box
                AlertDialog.Builder mybuilder = new AlertDialog.Builder(MainActivity.this);
                mybuilder.setTitle("Attention!");
                mybuilder.setMessage("You are going out of 1st Page..");
                mybuilder.setIcon(R.drawable.alerticon);

                mybuilder.setPositiveButton("Yes Go..", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //For Display Message
                        Toast.makeText(getApplicationContext(), "We are going to second Page/activity..", Toast.LENGTH_LONG).show();

                        //Go to Second Activity or layout Page
                        Intent i = new Intent(MainActivity.this, SecondActivity.class);
                        startActivity(i);
                    }
                });

                mybuilder.setNegativeButton("No i Wont Go", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
Toast.makeText(getApplicationContext(), "I Want to Stay here", Toast.LENGTH_LONG).show();
                    }
                });

                AlertDialog mydialog = mybuilder.create();
                mydialog.show();


            }
        });
//Display items
        final String[] pcs = {"Java", "Android", "MYSQl", "PHP"};
        ArrayAdapter adapter = new ArrayAdapter(this, R.layout.lvlayout, R.id.txtid, pcs);
        lv.setAdapter(adapter);
        //For click on the item
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "Skilled at "+pcs[position], Toast.LENGTH_LONG).show();
            }
        });
    }
}
