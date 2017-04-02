package com.varvet.barcodereadersample;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import com.varvet.barcodereadersample.model.Appointment;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Alex Thien An Le on 4/1/2017.
 */

public class AppointmentAdapter extends ArrayAdapter<Appointment> {
    private Context context;
    private int resource;
    private ArrayList<Appointment> appointmentList;
    Calendar cal = Calendar.getInstance();

    public AppointmentAdapter(Context context, int resource, ArrayList<Appointment> appointmentList) {
        super(context, resource, appointmentList);
        this.context = context;
        this.resource = resource;
        this.appointmentList = appointmentList;
    }

    @Override
    public View getView(int pos, View convertView, ViewGroup parent) {
        View v = convertView;
        Appointment item = appointmentList.get(pos);

        final int position = pos;

        if (v == null) {
            LayoutInflater inflater = ((Activity) getContext()).getLayoutInflater();
            v = inflater.inflate(resource, parent, false);

            final TextView worker = (TextView) v.findViewById(R.id.appointment_worker);
            final TextView customer = (TextView) v.findViewById(R.id.appointment_customer);
            final TextView room = (TextView) v.findViewById(R.id.appointment_room);
            final TextView time = (TextView) v.findViewById(R.id.appointment_time);
            final TextView id = (TextView) v.findViewById(R.id.appointment_Id);

            worker.setText(item.getWorker().getName());
            customer.setText(item.getCustomer().getName());
            room.setText(item.getRoom());
            cal.setTime(item.getTime());
            time.setText(cal.get(Calendar.DATE) + " " + cal.get(Calendar.HOUR) + ":" + cal.get(Calendar.MINUTE));
            //id.setText(item.getId());
        }
        return v;
    }
}
