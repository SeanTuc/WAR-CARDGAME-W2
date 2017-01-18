package w17w2;


import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author jwright
 */
public class DeckOfCards {
    private ArrayList<Card> deck;
    
    public DeckOfCards()
    {
        deck = new ArrayList<>();
        
        String[] suits = {"hearts","diamonds","spades","clubs"};
        String[] faceNames = {"two","three","four","five","six","seven","eight",
                              "nine","ten","jack","queen","king","ace"};
        
        for (String suit : suits)
        {
            for (int i=0; i < faceNames.length; i++)
            {
                Card newCard = new Card(faceNames[i], suit, i+2);
                deck.add(newCard);
            }
        }
    }
    
    /**
     * This will return a String representing the deck of cards
     */
    @Override
    public String toString()
    {
        String deckString = "";
        
        for (Card card : deck)
        {
            deckString += card.toString() + "\n";
        }
        
        return deckString;
    }
    
    /**
     * This method will "shuffle" the deck of cards
     */
    public void shuffle()
    {
        Collections.shuffle(deck);
    }
    
    /**
     * This method will deal the top card off the deck
     */
    public Card dealTopCard()
    {
        if (deck.isEmpty())
            return null;
        else
            return deck.remove(0);
    }
            
}
