/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package w17w2;

import java.util.ArrayList;

/**
 *
 * @author Sean
 */
public class GameOfWar {
    private ArrayList<Card> p1Hand;
    private ArrayList<Card> p2Hand;
    public GameOfWar()
    {
        p1Hand = new ArrayList<>();
        p2Hand = new ArrayList<>();
        
        DeckOfCards theDeck = new DeckOfCards();
        theDeck.shuffle();
        
        dealTheCards(theDeck);
        
    }// end of the constructor
    
    private void dealTheCards(DeckOfCards theDeck)
    {
        for(int cardNum = 0; cardNum < 52; cardNum ++)
        {
            if (cardNum % 2 == 0)
                p1Hand.add(theDeck.dealTopCard());
            else 
                p2Hand.add(theDeck.dealTopCard());
        }
    }
    
    public void playWar ()
    {
        while(!p1Hand.isEmpty() && !p2Hand.isEmpty())
        {
            playHand();
        }
        
        if (p1Hand.isEmpty())
            System.out.println("Player 2 is the Winner");
        else 
            System.out.println("Player 1 is the Winner");
    } //end of playWar
    
    public void playHand()
    {
        Card p1Card = p1Hand.remove(0);
        Card p2Card = p1Hand.remove(0);
        // player 2 wins hand
        if (p1Card.getFaceValue() > p2Card.getFaceValue())
        {
            p1Hand.add(p1Card);
            p1Hand.add(p2Card);
        }
        // player 2 wins hand
        else if (p1Card.getFaceValue() < p2Card.getFaceValue())
        {
            p2Hand.add(p1Card);
            p2Hand.add(p2Card);
        }
        else
        {
            ArrayList<Card> warPile = new ArrayList<>();
            warPile.add(p1Card);
            warPile.add(p2Card);
            playWarHand(warPile);
        }
        
    }//end of playHand
    
    /**
     * This method will simulate playing war hand
     */
    private void playWarHand(ArrayList<Card> warPile)
    {
        if(p1Hand.size() < 3)
        {
            p2Hand.addAll(p1Hand);
            p1Hand.clear();
            p2Hand.addAll(warPile);
        }
                if(p2Hand.size() < 3)
        {
            p1Hand.addAll(p1Hand);
            p2Hand.clear();
            p1Hand.addAll(warPile);
        }
        warPile.add(p1Hand.remove(0));
        warPile.add(p1Hand.remove(0));
        warPile.add(p2Hand.remove(0));
        warPile.add(p2Hand.remove(0));
        
        Card p1Card = p1Hand.remove(0);
        Card p2Card = p2Hand.remove(0);
        
        if (p1Card.getFaceValue() > p2Card.getFaceValue())
        {
            p1Hand.addAll(warPile);
            p1Hand.add(p2Card);
            p1Hand.add(p1Card);
        }
            else if (p1Card.getFaceValue() < p2Card.getFaceValue())
        {
            p2Hand.addAll(warPile);
            p2Hand.add(p2Card);
            p2Hand.add(p1Card);
        }
            else 
        {
                warPile.add(p2Card);
                warPile.add(p1Card);
                this.playWarHand(warPile);
        }           
               
    } // end of play war hand
} // the end of all