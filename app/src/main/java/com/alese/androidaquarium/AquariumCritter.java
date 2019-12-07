package com.alese.androidaquarium;

import java.util.Random;

// TODO: This is a class to create an aquarium critter object and govern its behavior.
public class AquariumCritter
{
    // Variables
    private int critterType;
    private String critterFullName;
    private String critterSize;
    private String critterMeal;
    private String critterAbility;
    // Variable for concatenating into picture file names for given critter
    private String critterPictureName;
    // Variable for holding critter picture file name (created via concatenation)
    private String critterPictureFile;
    private String action;
    public String critterResponse = "";
    // Instantiate a Random object for critter reactions.
    private Random random = new Random();

    // Constructor with the different types of critter.
    public AquariumCritter(int critterType)
    {
        // Stingray
        if (critterType == 0)
        {
            critterFullName = "Bluespotted ribbontail ray";
            critterSize = "Small";
            critterMeal = "Worm";
            critterAbility = "Venomous tail sting";
            critterPictureName = "stingray";
            // Meh
            // Content
            // Happy
        }
        // Moray Eel
        else if (critterType == 1)
        {
            critterFullName = "Giant moray";
            critterSize = "Large";
            critterMeal = "Large Fish";
            critterAbility = "Cooperative hunting";
            critterPictureName = "eel";
            // Meh
            // Content
            // Happy
        }
        // Sea Krait
        else if (critterType == 2)
        {
            critterFullName = "Banded sea krait";
            critterSize = "Medium";
            critterMeal = "Eel";
            critterAbility = "Venomous bite";
            critterPictureName = "krait";
            // Meh
            // Content
            // Happy
        }
        // Frogfish
        else if (critterType == 3)
        {
            critterFullName = "Painted Frogfish";
            critterSize = "Small";
            critterMeal = "Small fish";
            critterAbility = "Dorsal spine lure";
            critterPictureName = "frogfish";
            // Meh
            // Content
            // Happy
        }
        // Sea slug
        else
        {
            critterFullName = "Loch's Chromodoris";
            critterSize = "Tiny";
            critterMeal = "Sponge";
            critterAbility = "Poisonous skin";
            critterPictureName = "slug";
            // Meh
            // Content
            // Happy
        }
    }
    // Returns AquariumCritter attributes.
    public int getCritterType()
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
    public String getCritterPictureName() {return critterPictureName; }

    // Setters
    public void setCritterType(int critterType)
    {
        this.critterType = critterType;
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
            critterResponse = "Nice.";
        }
        else
        {
            critterResponse = "Awesome!";
        }
        return critterResponse;
    }
    // Returns critter response picture
    public String CritterResponsePicture()
    {
        if (critterResponse == "Meh.")
        {
            critterPictureFile = "meh_" + critterPictureName + ".png";
        }
        else if (critterResponse == "Nice.")
        {
            critterPictureFile = "nice_" + critterPictureName + ".png";
        }
        else
        {
            critterPictureFile = "awesome_" + critterPictureName + ".png";
        }
        return critterPictureFile;
    }

}
