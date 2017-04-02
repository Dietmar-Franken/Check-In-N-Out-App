package com.varvet.barcodereadersample;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import com.varvet.barcodereadersample.model.Appointment;

import java.util.ArrayList;

public class CheckOut extends AppCompatActivity {
    private ListView appointments;
    private ArrayList<Appointment> defaultList = new ArrayList<>();
    private AppointmentAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_out);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        appointments = (ListView) findViewById(R.id.appointment_list);
        //Set defaultlist for database
        //Set adapter
        //list as clickable
        //in clickable create dialog input box
    }

    public void checkout(View view) {

    }

    //Updates list
    public void refresh() {

    }

}
