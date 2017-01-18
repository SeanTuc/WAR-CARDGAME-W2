package w17w2;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sean
 */
public class Card {
    private String faceName, suit;
    private int faceValue;
    
    public Card(String face, String suit, int value)
    {
        faceName = face;
        setSuit(suit);
        setValue(value);
    }
    
    /**
     * This method will return a String to represent the Card
     */
    @Override
    public String toString()
    {
        return faceName + " of " + suit;
    }
    
    /**
     *  This will validate that the input is between 2-14 and set the card value
     * accordingly
     */
    private void setValue(int value)
    {
        if (value < 2 || value > 14)
            throw new IllegalArgumentException("Face value must be 2-14 inclusive");
        else
            faceValue = value;
    }
    
    
    /**
     * This method will validate if the suit is valid (i.e. hearts, diamonds,
     * spades or clubs)
     */
    private void setSuit(String suit)
    {
        if (suit.equalsIgnoreCase("hearts") || suit.equalsIgnoreCase("diamonds")
                || suit.equalsIgnoreCase("spades") || suit.equalsIgnoreCase("clubs"))
        {
            this.suit = suit;
        }
        else
            throw new IllegalArgumentException("suit must be hearts, diamonds, clubs "
                                                + "or spades");
    }

    public String getFaceName() {
        return faceName;
    }

    public String getSuit() {
        return suit;
    }

    public int getFaceValue() {
        return faceValue;
    }
    
    
}
