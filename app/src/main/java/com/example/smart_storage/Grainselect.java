package com.example.smart_storage;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.lang.reflect.Array;

public class Grainselect extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grainselect);

        Spinner spinner = findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Grain, R.layout.spinner_color);
        adapter.setDropDownViewResource(R.layout.spinner_dropdown);
        spinner.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);

    }



    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {
        if (parent.getItemAtPosition(i).equals("Wheat"))
        {
            String item = parent.getItemAtPosition(i).toString();
            Toast.makeText(parent.getContext(), "Selected: "+item,Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Grainselect.this,Wheat.class);
            startActivity(intent);
            finish();
        }
        /*else
        {
            String item = parent.getItemAtPosition(i).toString();
            Toast.makeText(parent.getContext(), "Selected: "+item,Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Grainselect.this,Wheat.class);
            startActivity(intent);
            finish();
        }
        String text = parent.getItemAtPosition(i).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
  */
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}