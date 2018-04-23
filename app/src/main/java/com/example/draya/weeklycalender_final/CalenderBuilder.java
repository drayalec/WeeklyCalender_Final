package com.example.draya.weeklycalender_final;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

public class CalenderBuilder extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender_builder);

        final Switch swAmPm = (Switch) findViewById(R.id.swAmPm);
        final Spinner spnWeekday = (Spinner) findViewById(R.id.spnWeekday);
        final Button btnAddActivity = (Button) findViewById(R.id.btnAddActivity);
        final Button btnShowCalendar = (Button) findViewById(R.id.btnViewCalendar);

        final EditText txtTime = (EditText) findViewById(R.id.txtTime);
        final EditText txtInfo = (EditText) findViewById(R.id.txtInfo);


        // if statement for the switch will go here
        // if statement to check if a event with the time already exists - if not will create
        //
        //All other work will be made when I make the third screen - will be easier to implement

        //error testing:

        btnAddActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkData()){
                    Intent nextScreen = new Intent (CalenderBuilder.this, VisaulCalendar.class);
                    nextScreen.putExtra("Time",txtTime.getText().toString());
                    nextScreen.putExtra("info",txtInfo.getText().toString());
                }

            }
        });

    }

    private boolean checkData(){

        final EditText txtTime = (EditText) findViewById(R.id.txtTime);
        final EditText txtInfo = (EditText) findViewById(R.id.txtInfo);

        if (txtTime.getText().toString().isEmpty()){
            //system error
            txtTime.setError("Invalid Time");
            txtTime.requestFocus();
            return false;
        }
        if (txtInfo.getText().toString().isEmpty()){

            txtInfo.setError("Invalid info");
            txtInfo.requestFocus();
            return  false;
        }
    return true;
    }
}
