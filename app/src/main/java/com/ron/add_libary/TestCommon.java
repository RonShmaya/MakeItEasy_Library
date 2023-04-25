package com.ron.add_libary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;
import com.ron.common_rs_tools.LatLangRs;
import com.ron.common_rs_tools.MakeItEasy;

import java.util.Date;

public class TestCommon extends AppCompatActivity {
    private FloatingActionButton addDate;
    private FloatingActionButton addTime;
    private TextInputEditText country;
    private TextInputEditText city;
    private TextInputEditText street;
    private TextInputEditText streetNum;
    private MaterialButton find_location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_libary);
        findViews();
        init_actions();
    }

    private void init_actions() {
        addDate.setOnClickListener(view -> MakeItEasy.getInstance().make_date_picker(callback_date,TestCommon.this));
        addTime.setOnClickListener(view -> MakeItEasy.getInstance().make_hour_minutes_picker(callback_time, TestCommon.this));
        find_location.setOnClickListener(listener);

    }

    private void findViews() {
        addDate = findViewById(R.id.addDate);
        addTime = findViewById(R.id.addTime);
        country = findViewById(R.id.country);
        city = findViewById(R.id.city);
        street = findViewById(R.id.street);
        streetNum = findViewById(R.id.streetNum);
        find_location = findViewById(R.id.find_location);
    }
    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(country.getText() == null || city.getText() == null || street.getText() == null || streetNum.getText() == null ){
                Toast.makeText(TestCommon.this, "cant be empty", Toast.LENGTH_SHORT).show();
            }
            LatLangRs latlang =  MakeItEasy.getInstance().getLocationFromAddress(TestCommon.this,
                    country.getText().toString(),
                    city.getText().toString() ,
                    street.getText().toString(),
                    streetNum.getText().toString());
            if (latlang == null){

                Toast.makeText(TestCommon.this, "empty" ,Toast.LENGTH_SHORT).show();
                return;
            }
            Toast.makeText(TestCommon.this, latlang.toString(),Toast.LENGTH_SHORT).show();
        }
    };
    private MakeItEasy.Callback_date callback_date = date -> {
        if(date == null){
            Toast.makeText(TestCommon.this, "", Toast.LENGTH_SHORT).show();
            return;
        }
        Toast.makeText(TestCommon.this, date.toString(), Toast.LENGTH_SHORT).show();

    };

    private MakeItEasy.Callback_time callback_time = (hour, minutes) -> Toast.makeText(TestCommon.this,hour+" : "+minutes, Toast.LENGTH_SHORT).show();
}