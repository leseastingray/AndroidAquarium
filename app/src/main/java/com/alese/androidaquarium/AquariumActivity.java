package com.alese.androidaquarium;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;

public class AquariumActivity extends AppCompatActivity
{
    // Variables
    int createdCritterInt;
    String createdCritterPicture;
    int critterPictureID;


    // Widget Variables
    ImageView aquariumImageView;
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
        aquariumImageView = (ImageView)findViewById(R.id.aquariumImageView);

        critterNameTextView = (TextView) findViewById(R.id.critterNameTextView);
        critterNameTextView.setText(aquariumCritter.getCritterFullName());

        // execute method to display appropriate critter image
        displayCritterImage(aquariumCritter);
    }

    @Override
    protected void onResume()
    {
        super.onResume();

    }
    // TODO: ImageView
    public void displayCritterImage(AquariumCritter aC)
    {
        int id = 0;

        if (aC.getCritterType() == 2)
        {
            if (aC.getCritterMood() == 1)
            {
                id = R.drawable.meh_krait;
            }
            else if(aC.getCritterMood() == 2)
            {
                id = R.drawable.nice_krait;
            }
            else
            {
                id = R.drawable.awesome_krait;
            }
        }
        else
        {
            if (aC.getCritterMood() == 1)
            {
                id = R.drawable.meh_slug;
            }
            else if(aC.getCritterMood() == 2)
            {
                id = R.drawable.nice_slug;
            }
            else
            {
                id = R.drawable.awesome_slug;
            }
        }
        // Set the image resource to appropriate id
        aquariumImageView.setImageResource(id);
    }
    // TODO: Interaction Buttons
    // TODO: Interaction Response TextView
}
