package com.varvet.barcodereadersample;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.varvet.barcodereadersample.model.Appointment;
import com.varvet.barcodereadersample.model.Customer;
import com.varvet.barcodereadersample.model.Worker;

import java.util.ArrayList;
import java.util.Date;

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
        defaultList.add(new Appointment(new Customer("le@gmail.com", "3", "Andrew", "Le", 32, 3), new Worker("alex@gmail.com", "3", "Alex", "Le", 32, "102b", 2), new Date(),3));
        defaultList.add(new Appointment(new Customer("le@gmail.com", "3", "Jonathan", "Lian", 32, 3), new Worker("alex@gmail.com", "3", "Alex", "Le", 32, "02a", 2), new Date(),3));
        defaultList.add(new Appointment(new Customer("le@gmail.com", "3", "Wesley", "Cheung", 32, 3), new Worker("alex@gmail.com", "3", "Jeff", "Ma", 32, "102b", 2), new Date(),3));

        adapter = new AppointmentAdapter(this, R.layout.appointment_row, defaultList);
        appointments.setAdapter(adapter);

        appointments.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                defaultList.remove(position);
                adapter.notifyDataSetChanged();
            }
            });

    }

    public void checkout(View view) {

    }

    //Updates list
    public void refresh() {
    }

}
