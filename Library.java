import ecs100.*;
import java.util.HashMap;
/**
 * Holds collection of pokémon cards in a hashamp.
 * Allows the user to add, find, and print all pokémon cards.
 *
 * @author (Phoebe Williamson)
 * @version (18/5/23)
 */

public class Library {
    // instance variables 
    private HashMap<Integer, Cards> cardsMap; // declares the hashmap
    private int currCardId; // store the current id of the card being added
    private Cards currCard;  // store the instance of the found card

    /**
     * Constructor for objects of class Library.
     */
    public Library() {
        // initialise instance variables
        cardsMap = new HashMap<Integer, Cards>();    // initialise hashmap
        
        // Creates some Pokémon cards
        Cards c1 = new Cards("PLASMA STORM CHARIZARD", 572, "charizard.jpeg");
        Cards c2 = new Cards("BULBASUR", 8, "bulbasaur.jpeg");
        Cards c3 = new Cards("GRENINJA", 3, "greninja.jpg");
        
        // adds the cards to collection
        cardsMap.put(1, c1);
        cardsMap.put(2, c2);
        cardsMap.put(3, c3);
        
        this.currCardId = 3;
    }

    /**
     * Adds cards the hashmap.
     */
    public void addCard(String nm, int prc, String img) {
        currCardId++;
        cardsMap.put(currCardId, new Cards(nm, prc, img));
    }
    
    /** 
     * looks for card in hashmap.

     * @return boolean if found
     */
    public boolean findCard(String name) {
        for (int cardId : cardsMap.keySet()) {
            if (cardsMap.get(cardId).getName().equals(name)) {
                currCard = cardsMap.get(cardId);
                return true; // if found in the hashmap
            }
        }
        
        return false; // if not found
    }
    
    /**
     * prints all cards in hashmap.
     */
    public void printAll() {
        UI.println("\nHere are all of the cards in the collection");
        for (int cardId : cardsMap.keySet()) {
            // gets all the cards in the collection and goes through hashmap 
            //print out all card names and their respective values
            currCard = cardsMap.get(cardId);
            UI.println("-------------------");
            UI.println("Card name: " + currCard.getName());
            UI.println("Card value: $" + currCard.getPrice());  
            }
        }
    
    /**
     * getter for the currrent card.

     * @return current instance of card found.
     */
    public Cards getCard() {
        return this.currCard;
    }
}
