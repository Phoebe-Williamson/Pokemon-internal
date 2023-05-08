import ecs100.*;
/**
 * Write a description of class GUI here.
 *
 * @author (Phoebe Williamson)
 * @version (9/5/23)
 */
public class GUI
{
    // instance variables - replace the example below with your own
    private Library library;
    private Cards cards;

    /**
     * Constructor for objects of class GUI.
     */
    public GUI()
    {
        // initialise instance variables
        cards = new Cards();
        UI.initialise();
        UI.setMouseListener(this::doMouse);
        
        // buttons for the user to click
        
        //
        UI.println("Welcome to the Pokémon card library. \n CLick a Button to start your adventure");
    }

    /**
     * Clears the screen.
     */
    public void clearAll(){
        UI.clearText();
        UI.clearGraphics();
        cards = null;
    }
    
    /**
     * Add a pokémon card to the collection.
     * The methods for name, value and image will be added to the adding card.
     */
    public void addCard() {
        
    }
    
    /**
     *  Check that the input for name is valid and then returns it.
     */
    
    /**
     * Checks that the input for monetray value is valid and then returns it.
     */
    
    /**
     * finds the pokémon card based on the name.
     * Printout the monetary value and displays the image.
     */
    
    /** 
     * mouse listener in response  
     */
    private void doMouse(String action, double x, double y) {
        if (action.equals("clicked")) {
            if (cards != null) {
                if (cards.isOnCard(x,y)) {
                    this.clearAll();
                }
            }
        }
    }
    /**
     * Calls method in library to print out all cards
     */
}
