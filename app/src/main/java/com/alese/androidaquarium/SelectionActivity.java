package com.alese.androidaquarium;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Spinner;
import android.widget.Button;
import android.widget.Toast;
import com.alese.androidaquarium.AquariumCritter;

public class SelectionActivity extends AppCompatActivity
    implements AdapterView.OnItemSelectedListener
{
    // Fields
    public static final String CRITTER_SELECTION = "critterSelection";
    //public static final String CRITTER_NAME = "critterName";
    // Variables
    public int critterSelection = 0;
    //public String critterName = "Default";
    // Widget Variables
    Spinner selectionSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);

        // Set up Spinner
        selectionSpinner = (Spinner)findViewById(R.id.selectionSpinner);
        selectionSpinner.setOnItemSelectedListener(this);

        // Create the ArrayAdapter and layout
        ArrayAdapter<CharSequence> selectionAdapter = ArrayAdapter.createFromResource
                (this, R.array.selection_array, android.R.layout.simple_spinner_dropdown_item);
        selectionAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Set up Spinner with ArrayAdapter data
        selectionSpinner.setAdapter(selectionAdapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
    {
        switch (position)
        {
            case 0:
                critterSelection = 0;
                break;
            case 1:
                critterSelection = 1;
                break;
            case 2:
                critterSelection = 2;
                break;
            case 3:
                critterSelection = 3;
                break;
            case 4:
                critterSelection = 4;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent)
    {
        // Stub
    }

    // Handler for newAquariumButton: should create Intent, put Extras, and start new Activity
    public void createNewAquarium(View v)
    {
        // Start second activity and send it the user's critter selection
        Intent intent = new Intent(this, AquariumActivity.class);
        intent.putExtra(CRITTER_SELECTION, critterSelection);
        startActivity(intent);
    }
}
