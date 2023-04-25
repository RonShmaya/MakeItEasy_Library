package com.ron.common_rs_tools;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.FragmentManager;
import android.app.TimePickerDialog;
import android.content.Context;
import android.icu.util.Calendar;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.widget.DatePicker;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import com.google.android.gms.maps.model.LatLng;

import java.util.Date;
import java.util.List;

public class MakeItEasy {

    private static MakeItEasy _instance = new MakeItEasy();

    private MakeItEasy() {

    }
    public static MakeItEasy getInstance(){
        return _instance;
    }

    /************************************* Time Picker *************************************/

    public interface Callback_time {
        void get_input_time(int hour,int minutes);
    }
    public void make_hour_minutes_picker(Callback_time callback_time , AppCompatActivity activity){
        TimePickerFragment timePickerFragment =  new TimePickerFragment().setCallback_time(callback_time);
        timePickerFragment.show(activity.getSupportFragmentManager(), "TimePicker");
    }

    public static class TimePickerFragment extends DialogFragment
            implements TimePickerDialog.OnTimeSetListener {

        private Callback_time callback_time;

        private TimePickerFragment setCallback_time(Callback_time callback_time) {
            this.callback_time = callback_time;
            return this;
        }

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current time as the default values for the picker
            final Calendar c = Calendar.getInstance();
            int hour = c.get(Calendar.HOUR_OF_DAY);
            int minute = c.get(Calendar.MINUTE);

            // Create a new instance of TimePickerDialog and return it
            return new TimePickerDialog(getActivity(), this, hour, minute,
                    DateFormat.is24HourFormat(getActivity()));
        }

        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            if(this.callback_time != null){
                this.callback_time.get_input_time(hourOfDay , minute);
            }
        }
    }

    /************************************* Date Picker *************************************/

    public interface Callback_date {
        void get_input_date(Date date);
    }
    public void make_date_picker(Callback_date callback_date , AppCompatActivity activity){
        DatePickerFragment datePickerFragment =  new DatePickerFragment().setCallback_date(callback_date);
        datePickerFragment.show(activity.getSupportFragmentManager(), "datePicker");
    }

    public static class DatePickerFragment extends DialogFragment
            implements DatePickerDialog.OnDateSetListener {


        private Callback_date callback_date;

        private DatePickerFragment setCallback_date(Callback_date callback_date) {
            this.callback_date = callback_date;
            return this;
        }

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            // Create a new instance of DatePickerDialog and return it
            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        public void onDateSet(DatePicker view, int year, int month, int day) {
            // Do something with the date chosen by the user
            if(this.callback_date != null){
                final Calendar c = Calendar.getInstance();
                c.set(year, month, day , 0, 0 ,0);
                this.callback_date.get_input_date(c.getTime());
            }
        }
    }

    /************************************* Make Lng Lat from address *************************************/

    public LatLangRs getLocationFromAddress(Context context, String country,String city,String street ,String street_num) {
        Geocoder coder = new Geocoder(context);
        List<Address> address;
        String strAddress = street_num+" ,"+street+" ,"+city+" ,"+country;
        LatLangRs p1 = null;

        try {
            address = coder.getFromLocationName(strAddress, 1);
            if (address == null) {
                return null;
            }
            Address location = address.get(0);

            p1 = new LatLangRs(location.getLatitude(), location.getLongitude());
        } catch (Exception e) {
            return null;
        }
        return p1;

    }
}
