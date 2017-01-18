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
}
