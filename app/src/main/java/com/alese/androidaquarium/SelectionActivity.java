package com.alese.androidaquarium;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.TextView;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Spinner;
import android.widget.Button;
import android.widget.Toast;
import com.alese.androidaquarium.AquariumCritter;

public class SelectionActivity extends AppCompatActivity
    implements AdapterView.OnItemSelectedListener, TextView.OnEditorActionListener
{
    // Fields
    public static final String CRITTER_SELECTION = "critterSelection";
    public static final String CRITTER_NAME = "critterName";
    // Variables
    public int critterSelection = 0;
    public String critterName;
    //public String critterName = "Default";
    // Widget Variables
    Spinner selectionSpinner;
    Button newAquariumButton;
    EditText critterNameEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);

        // Set up Widgets
        critterNameEditText = (EditText)findViewById(R.id.critterNameEditText);
        newAquariumButton = (Button)findViewById(R.id.newAquarium);
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
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event)
    {
        if(actionId == EditorInfo.IME_ACTION_DONE ||
                actionId == EditorInfo.IME_ACTION_UNSPECIFIED ||
                actionId == EditorInfo.IME_ACTION_NEXT ||
                event.getKeyCode() == KeyEvent.KEYCODE_ENTER)
        {
            critterName = critterNameEditText.getText().toString();
            newAquariumButton.hasFocus();
        }
        // Hide the soft keyboard
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
        return false;
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent)
    {
        // Stub
    }
    // TODO : for saving state
    @Override
    protected void onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState);

        outState.putString("name", critterName);
    }

    // Handler for newAquariumButton: should create Intent, put Extras, and start new Activity
    public void createNewAquarium(View v)
    {
        // Start second activity and send it the user's critter selection
        Intent intent = new Intent(this, AquariumActivity.class);
        intent.putExtra(CRITTER_SELECTION, critterSelection);
        intent.putExtra(CRITTER_NAME, critterName);
        startActivity(intent);
    }
}
