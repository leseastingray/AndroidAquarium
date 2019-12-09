package com.alese.androidaquarium;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.Button;
import android.widget.Toast;
import android.graphics.BitmapFactory.Options;

import androidx.appcompat.app.ActionBar;

public class AquariumActivity extends AppCompatActivity
{
    // Variables
    private int createdCritterInt;
    private String createdCritterName;
    private int critterPictureID;
    private String critterFood;
    private String critterShortName;
    private int critterResponseNumber;
    private String critterResponseText;
    private AquariumCritter aquariumCritter;

    // Widget Variables
    ImageView aquariumImageView;
    TextView critterNameTextView;
    TextView critterCreatedNameTextView;
    TextView critterResponseTextView;
    Button feedButton;
    Button interactButton;
    Button cleanButton;

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
        createdCritterName = intent.getExtras().getString(SelectionActivity.CRITTER_NAME);
        aquariumCritter = new AquariumCritter(createdCritterInt);

        // Widgets
        aquariumImageView = (ImageView)findViewById(R.id.aquariumImageView);
        critterCreatedNameTextView = (TextView)findViewById(R.id.critterCreatedNameTextView);
        critterCreatedNameTextView.setText(createdCritterName);

        critterNameTextView = (TextView) findViewById(R.id.critterNameTextView);
        critterNameTextView.setText(aquariumCritter.getCritterFullName());

        critterResponseTextView = (TextView)findViewById(R.id.responseTextView);
        feedButton = (Button)findViewById(R.id.feedButton);
        interactButton = (Button)findViewById(R.id.interactButton);
        cleanButton = (Button)findViewById(R.id.cleanButton);

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
    public void Feed(View v)
    {
        // Get the critter's food and name
        critterFood = aquariumCritter.getCritterMeal();
        critterShortName = aquariumCritter.getCritterPictureName();
        // Display action
        Toast.makeText(this, "You feed a " + critterFood + " to your " + critterShortName, Toast.LENGTH_SHORT).show();
        // Call critter response method
        CritterInteractResponse(aquariumCritter);

    }
    public void Interact(View v)
    {
        // Get the critter's name
        critterShortName = aquariumCritter.getCritterPictureName();
        // Display action
        Toast.makeText(this, "You interact with your " + critterShortName, Toast.LENGTH_SHORT).show();
        // Call critter response method
        CritterInteractResponse(aquariumCritter);

    }
    public void Clean(View v)
    {
        // Get the critter's name
        critterShortName = aquariumCritter.getCritterPictureName();
        // Display action
        Toast.makeText(this, "You clean your " + critterShortName, Toast.LENGTH_SHORT).show();
        // Call critter response method
        CritterInteractResponse(aquariumCritter);

    }
    public void CritterInteractResponse(AquariumCritter aC)
    {
        // Get response int and text
        critterResponseNumber = aC.CritterResponseNumber();
        critterResponseText = aC.CritterResponse(critterResponseNumber);
        // Use response int to set mood
        aC.setCritterMood(critterResponseNumber);
        // Use mood to get drawable and set image resource
        aquariumImageView.setImageResource(displayCritterImage(aC));
        // Set text view with response text
        critterResponseTextView.setText(critterResponseText);
    }
}
