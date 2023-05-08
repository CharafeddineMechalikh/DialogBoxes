package com.mechalikh.myapplication;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private Button btnAlert, btnTime, btnDate, btnCustom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get references to the buttons
        btnAlert = findViewById(R.id.btn_alert);
        btnTime = findViewById(R.id.btn_time);
        btnDate = findViewById(R.id.btn_date);
        btnCustom = findViewById(R.id.btn_custom);

        // Set click listeners for the buttons
        btnAlert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlert();
            }
        });

        btnTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTimePicker();
            }
        });

        btnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePicker();
            }
        });

        btnCustom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCustomDialog();
            }
        });
    }

    // Shows an alert dialog with a message and OK button
    private void showAlert() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Alert Dialog")
                .setMessage("This is an example of an alert dialog.")
                .setPositiveButton("OK", null)
                .show();
    }

    // Shows a time picker dialog and displays the selected time in a Toast message
    private void showTimePicker() {
        final Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay,
                                          int minute) {
                        Toast.makeText(getApplicationContext(), "Selected time: " + hourOfDay + ":" + minute,
                                Toast.LENGTH_LONG).show();
                    }
                }, hour, minute, false);
        timePickerDialog.show();
    }

    // Shows a date picker dialog and displays the selected date in a Toast message
    private void showDatePicker() {
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {
                        Toast.makeText(getApplicationContext(), "Selected date: " + dayOfMonth + "/" + (monthOfYear + 1) + "/" + year,
                                Toast.LENGTH_LONG).show();
                    }
                }, year, month, day);
        datePickerDialog.show();
    }

    // Shows a custom dialog with two buttons and displays a Toast message when the Submit button is clicked
    private void showCustomDialog() {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.custom_dialog);
        dialog.setTitle("Custom Dialog");

        Button btnCancel = dialog.findViewById(R.id.btn_cancel);
        Button btnSubmit = dialog.findViewById(R.id.btn_submit);

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Submitted", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        dialog.show();
    }
}