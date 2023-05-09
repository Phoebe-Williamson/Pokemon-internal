import java.util.HashMap;
import ecs100.*;
/**
 * Holds collection of pokémon cards in a hashamp.
 * Allows the user to add, find, and print all pokémon crads.
 *
 * @author (Phoebe Williamson)
 * @version (9/5/23)
 */
public class Library
{
    // instance variables 
    private HashMap<Integer, Cards> cardsMap; // declares the hashmap
    private int currCardId; // store the current id of the card being added
    private Cards currCard;  // store the instance of the found card

    /**
     * Constructor for objects of class Library
     */
    public Library()
    {
        // initialise instance variables
        cardsMap = new HashMap<Integer, Cards>();    // initialise hashmap
        
        // Creates some Pokémon cards
        Cards c1 = new Cards("PLASMA STORM CHARIZARD", 572, "charizard.jpeg");
        Cards c2 = new Cards("BULBASUR", 8, "bulbasaur.jpg");
        Cards c3 = new Cards("GRENINJA", 3, "greninja.jpg");
        
        // adds the cards to collection
        cardsMap.put(1, c1);
        cardsMap.put(2, c2);
        cardsMap.put(3, c3);
    }

    /**
     * Adds cards the hashmap.
     */
    public void addCard() {
        
    }
    
    /** 
     * looks for card in hashmap.
     * @return boolean if found
     */
    
    /**
     * prints all cards in hashmap.
     */
    
    /**
     * getter for the currrent card.
     * @return current instance of card found.
     */
    
}
