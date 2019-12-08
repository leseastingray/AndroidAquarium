package com.alese.androidaquarium;

import java.util.Random;

// This is a class to create an aquarium critter object and govern its behavior.
public class AquariumCritter
{
    // Variables
    private int critterType;
    private int createdCritterType;
    private String critterFullName;
    private String critterSize;
    private String critterMeal;
    private String critterAbility;
    // Variable for concatenating into picture file names for given critter
    private String critterPictureName;
    // Variable for holding critter picture file name (created via concatenation)
    private String critterPictureFile;
    public int critterMood;
    public String critterResponse = "";
    // Instantiate a Random object for critter reactions.
    private Random random = new Random();

    // Constructor with the different types of critter.
    public AquariumCritter(int createdCritterType)
    {
        // Stingray
        if (createdCritterType == 0)
        {
            critterType = 0;
            critterFullName = "Bluespotted ribbontail ray";
            critterSize = "Small";
            critterMeal = "Worm";
            critterAbility = "Venomous tail sting";
            critterPictureName = "stingray";
            critterMood = 3;
            // Meh
            // Content
            // Happy
        }
        // Moray Eel
        else if (createdCritterType == 1)
        {
            critterType = 1;
            critterFullName = "Giant moray";
            critterSize = "Large";
            critterMeal = "Large Fish";
            critterAbility = "Cooperative hunting";
            critterPictureName = "moray";
            critterMood = 1;
            // Meh
            // Content
            // Happy
        }
        // Sea Krait
        else if (createdCritterType == 2)
        {
            critterType = 2;
            critterFullName = "Banded sea krait";
            critterSize = "Medium";
            critterMeal = "Eel";
            critterAbility = "Venomous bite";
            critterPictureName = "krait";
            critterMood = 2;
            // Meh
            // Content
            // Happy
        }
        // Frogfish
        else if (createdCritterType == 3)
        {
            critterType = 3;
            critterFullName = "Painted Frogfish";
            critterSize = "Small";
            critterMeal = "Small fish";
            critterAbility = "Dorsal spine lure";
            critterPictureName = "frogfish";
            critterMood = 1;
            // Meh
            // Content
            // Happy
        }
        // Sea slug
        else
        {
            critterType = 4;
            critterFullName = "Loch's chromodoris";
            critterSize = "Tiny";
            critterMeal = "Sponge";
            critterAbility = "Poisonous skin";
            critterPictureName = "slug";
            critterMood = 2;
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
    public int getCritterMood() {return critterMood; }

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
            critterMood = 1;
            critterResponse = "Meh.";
        }
        else if (randomResponse == 2)
        {
            critterMood = 2;
            critterResponse = "Nice.";
        }
        else
        {
            critterMood = 3;
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
