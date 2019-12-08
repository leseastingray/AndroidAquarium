package com.alese.androidaquarium;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.Toast;
import android.graphics.BitmapFactory.Options;

import androidx.appcompat.app.ActionBar;

public class AquariumActivity extends AppCompatActivity
{
    // Variables
    private int createdCritterInt;
    private int critterPictureID;

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

        BitmapFactory.Options bOptions = new BitmapFactory.Options();
        bOptions.inSampleSize = 4;
        // execute method to display appropriate critter image
        critterPictureID = displayCritterImage(aquariumCritter);
        // Set the image resource to appropriate id
        aquariumImageView.setImageResource(critterPictureID);
    }

    @Override
    protected void onResume()
    {
        super.onResume();

    }
    // TODO: ImageView

    public int displayCritterImage(AquariumCritter aC)
    {
        int id = 0;
        // if a Stingray

        if (aC.getCritterType() == 0)
        {
            // if meh mood:
            if (aC.getCritterMood() == 1)
            {
                id = R.drawable.meh_stingray;
            }
            // if good mood:
            else if(aC.getCritterMood() == 2)
            {
                id = R.drawable.nice_stingray;
            }
            // if awesome mood:
            else
            {
                id = R.drawable.awesome_stingray;
            }
        }
        // if a Moray Eel:
        else if (aC.getCritterType() == 1)
        {
            // if meh mood:
            if (aC.getCritterMood() == 1)
            {
                id = R.drawable.meh_moray;
            }
            // if good mood:
            else if(aC.getCritterMood() == 2)
            {
                id = R.drawable.nice_moray;
            }
            // if awesome mood:
            else
            {
                id = R.drawable.awesome_moray;
            }
        }
        // if a Sea Snake
        else if (aC.getCritterType() == 2)
        {
            // if meh mood:
            if (aC.getCritterMood() == 1)
            {
                id = R.drawable.meh_krait;
            }
            // if good mood:
            else if(aC.getCritterMood() == 2)
            {
                id = R.drawable.nice_krait;
            }
            // if awesome mood:
            else
            {
                id = R.drawable.awesome_krait;
            }
        }
        // if a Frogfish:
        else if (aC.getCritterType() == 3)
        {
            // if meh mood:
            if (aC.getCritterMood() == 1)
            {
                id = R.drawable.meh_frogfish;
            }
            // if good mood:
            else if(aC.getCritterMood() == 2)
            {
                id = R.drawable.nice_frogfish;
             }
             // if awesome mood:
             else
             {
                id = R.drawable.awesome_frogfish;
             }
        }
        // if a Sea Slug:
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
        return id;
    }
    // TODO: Interaction Buttons
    // TODO: Interaction Response TextView
}
