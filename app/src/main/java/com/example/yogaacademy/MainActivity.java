package com.example.yogaacademy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.table_list_layout);

         //Dropdown Starts
        String[] daysOfWeek = {"All","Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, daysOfWeek);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Spinner daySelector = findViewById(R.id.daySelector);
        daySelector.setAdapter(adapter);
        daySelector.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String selectedDay = daysOfWeek[position];
                // Handle the selected day (e.g., display a toast message)
                Toast.makeText(MainActivity.this, "Selected day: " + selectedDay, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Handle nothing selected if needed
                //End DropDown
            }
        });

        //Edit Start
        ImageView imageView = findViewById(R.id.edit);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create an Intent to navigate to the new activity
                Intent intent = new Intent(MainActivity.this,EditDetails.class);
                // You can pass data to the new activity if needed
                intent.putExtra("extraKey", "extraValue");

                // Start the new activity
                startActivity(intent);
            }
        });
        //Edit Ends
    }
}
