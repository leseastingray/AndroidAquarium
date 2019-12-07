package com.alese.androidaquarium;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;

public class AquariumActivity extends AppCompatActivity
{
    // Variables
    int createdCritterInt;
    String createdCritter;

    // Widget Variables
    TextView critterNameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aquarium);

        // Create support action bar
        ActionBar ab = getSupportActionBar();
        // Enable Up button
        ab.setDisplayHomeAsUpEnabled(true);

        // Get the intent and extras from Selection Activity
        Intent intent = getIntent();
        createdCritterInt = intent.getExtras().getInt(SelectionActivity.CRITTER_SELECTION);
        AquariumCritter aquariumCritter = new AquariumCritter(createdCritterInt);
        
        // Widgets
        critterNameTextView = (TextView) findViewById(R.id.critterNameTextView);
        critterNameTextView.setText(aquariumCritter.getCritterFullName());
    }

    @Override
    protected void onResume()
    {
        super.onResume();


    }
    // TODO: ImageView
    // TODO: Interaction Buttons
    // TODO: Interaction Response TextView
}
