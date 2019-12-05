package com.alese.androidaquarium;

import java.util.Random;

// TODO: This is a class to create an aquarium critter object and govern its behavior.
public class AquariumCritter
{
    // Variables
    private String critterType;
    private String critterFullName;
    private String critterSize;
    private String critterMeal;
    private String action;
    public String critterResponse = "";
    // Instantiate a Random object for critter reactions.
    private Random random = new Random();

    // Constructor with the different types of critter.
    public AquariumCritter(String critterType)
    {
        // Stingray
        if (critterType == "Stingray")
        {
            critterFullName = "Bluespotted ribbontail ray";
            critterSize = "Small";
            critterMeal = "Worm";
            // Meh
            // Content
            // Happy
        }
        // Moray Eel
        else if (critterType == "Moray Eel")
        {
            critterFullName = "Giant moray";
            critterSize = "Large";
            critterMeal = "Fish";
            // Meh
            // Content
            // Happy
        }
        // Sea Krait
        else if (critterType == "Sea Krait")
        {
            critterFullName = "Banded sea krait";
            critterSize = "Medium";
            critterMeal = "Eel";
            // Meh
            // Content
            // Happy
        }
        // Frogfish
        else if (critterType == "Frogfish")
        {
            critterSize = "Small";
            // Meh
            // Content
            // Happy
        }
        // Lobster
        else
        {
            critterSize = "Small";
            // Meh
            // Content
            // Happy
        }
    }
    // Returns the type of critter.
    public String getCritterType()
    {
        return critterType;
    }
    public String getCritterFullName()
    {
        return critterFullName;
    }
    public String getCritterSize()
    {
        return critterSize;
    }
    public String getCritterMeal()
    {
        return critterMeal;
    }
    // Returns the critter response.
    public String CritterResponse()
    {
        // Random selection
        int randomResponse = random.nextInt(3) + 1;

        if (randomResponse == 1)
        {
            critterResponse = "Meh.";
        }
        else if (randomResponse == 2)
        {
            critterResponse = "Nice, thanks.";
        }
        else
        {
            critterResponse = "Awesome!";
        }
        return critterResponse;
    }

}
