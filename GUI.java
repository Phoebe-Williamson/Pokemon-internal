import ecs100.*;
/**
 * Class to handle the GUI functionality.
 *
 * @author (Phoebe Williamson)
 * @version (10/5/23)
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
        library = new Library();
        UI.initialise();
        UI.setMouseListener(this::doMouse);
        
        // buttons for the user to click
        UI.addButton("Add card", this::addCard);
        UI.addButton("Print All", this::printCards);
        UI.addButton("Clear all", this::clearAll);  // button which clears the screen
        UI.addButton("Quit", UI::quit); // button which quits the program
        
        // this statement is printed out each time the program is run.
        UI.println("Welcome to the Pokémon card library. \nClick a Button to start your adventure");
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
        String name = UI.askString("Enter the Pokemon card name: ").toUpperCase();
        int price = UI.askInt("Enter the monetary value of the card: ");
 
        String imgFileName = UIFileChooser.open("Choose Image File: ");
        library.addCard(name, price, imgFileName);
    }
    
    /**
     *  Check that the input for name is valid and then returns it.
     */
    public String addCardName() {
        boolean getCard = true;
        String name = UI.askString("Enter the Pokemon card name: ").toUpperCase();
        while(getCard = true) {
            if (name.equals("")) {
                name = UI.askString("Enter the Pokemon card name: ").toUpperCase();
            } else {
                getCard = false;
            }
        }
        return name;
    }
    
    /**
     * Checks that the input for monetray value is valid and then returns it.
     */
    public int addPrice() {
        final int MIN_PRICE = 1;
        final int MAX_PRICE = 5275000;
        
        boolean getPrc = true;
        int price = UI.askInt("Enter the monetary value of the card: ");
        while (getPrc) {
            if (price > MAX_PRICE || price < MIN_PRICE) {
                price = UI.askInt("Enter the monetary value of the card (between 1 - 9 dollars): ");
            } else {
                getPrc = false;
            }
        }
        return price;
    }
    
    /**
     * finds the pokémon card based on the name.
     * Printout the monetary value and displays the image.
     */
    
    /** 
     * mouse listener in response to being clicked
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
    public void printCards() {
        library.printAll();
    }
}
