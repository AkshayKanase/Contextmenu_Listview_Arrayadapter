package com.example.contextlistviewarrayadapter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView contactListView;
    List<String> contactData = new ArrayList<>();
    String[] contactDetails = {"Akshay Kanase", "Rahul Patil", "Aditya Salunkhe", "Rushi Magar"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addContactDetails();
        initViews();

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, contactData);
        contactListView.setAdapter(arrayAdapter);
        registerForContextMenu(contactListView);
    }

    private void initViews(){
        contactListView = findViewById(R.id.contactListView);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.context_menu, menu);


    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {


        switch (item.getItemId()) {

            case R.id.callContextOption:
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                builder.setTitle("CALL FEATURE");
                builder.setMessage("Do you Want to call ?");
                builder.setIcon(R.mipmap.ic_launcher);
                DialogInterface.OnClickListener listener = new AlertButtonClickListener();
                builder.setPositiveButton("YES", listener);
                builder.setNegativeButton("NO", listener);
                builder.setNeutralButton("Cancel", listener);

                AlertDialog callerDialog = builder.create();
                callerDialog.show();
                break;

            case R.id.msgContextOption:
                AlertDialog.Builder builder2 = new AlertDialog.Builder(MainActivity.this);

                builder2.setTitle("TEXT FEATURE");
                builder2.setMessage("Do you Want to txt ?");
                builder2.setIcon(R.mipmap.ic_launcher);
                DialogInterface.OnClickListener listener2 = new AlertTextClickListner();
                builder2.setPositiveButton("YES", listener2);
                builder2.setNegativeButton("NO", listener2);
                builder2.setNeutralButton("Cancel", listener2);


                AlertDialog msgDialog = builder2.create();
                msgDialog.show();
                break;

            case R.id.whatsappContextOption:
                AlertDialog.Builder builder3 = new AlertDialog.Builder(MainActivity.this);

                builder3.setTitle("WhATSAPP FEATURE");
                builder3.setMessage("Do you Want to wtsApp ?");
                builder3.setIcon(R.mipmap.ic_launcher);
                DialogInterface.OnClickListener listener3 = new AlertWhtsAppClickListner();
                builder3.setPositiveButton("YES", listener3);
                builder3.setNegativeButton("NO", listener3);
                builder3.setNeutralButton("Cancel", listener3);


                AlertDialog whtsAppDialog = builder3.create();
                whtsAppDialog.show();
                break;

        }


        return super.onContextItemSelected(item);
    }

    class AlertButtonClickListener implements DialogInterface.OnClickListener {

        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            if (i == DialogInterface.BUTTON_POSITIVE) {
                Toast.makeText(MainActivity.this, "Calling...", Toast.LENGTH_SHORT).show();
            }
            if (i == DialogInterface.BUTTON_NEGATIVE) {
                Toast.makeText(MainActivity.this, "Cancelling call..", Toast.LENGTH_SHORT).show();
            }
            if (i == DialogInterface.BUTTON_NEUTRAL) {

            }
        }
    }
    class AlertTextClickListner implements DialogInterface.OnClickListener {

        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            if (i == DialogInterface.BUTTON_POSITIVE) {
                Toast.makeText(MainActivity.this, "sending text", Toast.LENGTH_SHORT).show();
            }
            if (i == DialogInterface.BUTTON_NEGATIVE) {
                Toast.makeText(MainActivity.this, "Cancelling txt..", Toast.LENGTH_SHORT).show();
            }

        }
    }

    class AlertWhtsAppClickListner implements DialogInterface.OnClickListener {

        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            if (i == DialogInterface.BUTTON_POSITIVE) {
                Toast.makeText(MainActivity.this, "Sending whtsApp txt...", Toast.LENGTH_SHORT).show();
            }
            if (i == DialogInterface.BUTTON_NEGATIVE) {
                Toast.makeText(MainActivity.this, "Cancelling whtsapp..", Toast.LENGTH_SHORT).show();
            }
            if (i == DialogInterface.BUTTON_NEUTRAL) {

            }
        }
    }
    private void addContactDetails() {
        for (String contact : contactDetails) {
            contactData.add(contact);
        }
    }
    }
