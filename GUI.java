import ecs100.*;
/**
 * Class to handle the GUI functionality.
 *
 * @author (Phoebe Williamson)
 * @version (19/5/23)
 */

public class GUI {
    // instance variables - replace the example below with your own
    private Library library;
    private Cards cards;

    /**
     * Constructor for objects of class GUI.
     */
    public GUI() {
        // initialise instance variables
        library = new Library();
        UI.initialise();
        UI.setMouseListener(this::doMouse);
        
        // buttons for the user to click
        UI.addButton("Add card", this::addCard);  // goes to method addcard
        UI.addButton("Find card", this::findCard);  // goes to method findCaed
        UI.addButton("Print All", this::printCards);  // goes to method printCards 
        UI.addButton("Clear all", this::clearAll);  // button which clears the screen
        UI.addButton("Quit", UI::quit); // button which quits the program
         
        
        // this statement is printed out each time the program is run.
        UI.println("Welcome to the Pokémon card library. \nClick a Button to start your adventure");
    }

    /**
     * Clears the screen.
     */
    public void clearAll() {
        // clear both text and graphics pane
        UI.clearText();
        UI.clearGraphics();
        cards = null;
    }
    
    /**
     * Add a pokémon card to the collection.
     * The methods for name, value and image will be added to the adding card.
     */
    public void addCard() {
        //keeps the loop running to get price adn image if not the duplicate
        boolean continueAdding = true;
        // calls method addCardName which checks for valid input of name
        String name = addCardName();
        
        if (name == null) {
            continueAdding = false;
        } else {
            // calls the method addPrice which checks for valid input of price
            int price = addPrice();
            
            // tells user what is expected when image file chooser appears
            UI.println("Chose the image file for the pokemon, or click cancel to not select one."); 
            String imgFileName = UIFileChooser.open();
            library.addCard(name, price, imgFileName); 
        }
    }
    
    /**
     *  Check that the input for name is valid and then returns it.
     */
    public String addCardName() {
        boolean getCard = true;
        String name = UI.askString("\nEnter the Pokemon card name: ").toUpperCase();
        while (getCard) {
            if (library.findCard(name)) {
                UI.println("Card is already in collection.");
                UI.println("Click another button to continue.");
                // stops and ends loop from asking for price
                getCard = false; 
                return null;
            } else if (name.isBlank()) {
                // if input is white spaces 
                name = UI.askString("Enter a valid name for the Pokemon card: ").toUpperCase();
            } else {
                getCard = false;  // if a valid input for name is eneterd
            }
        }
        return name; // returns the name if it is a valid one
    }
    
    /**
     * Checks that the input for monetray value is valid and then returns it.
     */
    public int addPrice() {
        // sets the max and minimum price allowed for the card
        final int MIN_PRICE = 1;
        final int MAX_PRICE = 5275000;
        
        // makes loop happen until a valid input
        boolean getPrc = true;
        int price = UI.askInt("Enter the monetary value of the card: ");
        while (getPrc) {
            if (price > MAX_PRICE || price < MIN_PRICE) {
                // print line ou tif it lower or higher than the min and max prices
                price = UI.askInt("Enter the monetary value of the card (between 1 - 5,275,000 dollars): ");
            } else {
                getPrc = false; // ends loop as valid price is entered
            }
        }
        return price; // returns the valid price
    }
    
    /**
     * finds the pokémon card based on the name.
     * Printout the monetary value and displays the image.
     */
    public void findCard() {
        // checks if card is in hasmap 
        String cardName = UI.askString("\nName of pokemon card: ").toUpperCase();
        if (library.findCard(cardName)) {
            // prints out card info and image if found
            UI.println("-------------------");
            UI.println("Found Card!");
            cards = library.getCard();
            UI.println("Card name: " + cards.getName());
            UI.println("Price of card: $" + cards.getPrice());
            cards.displayCard();
        } else {
            //print if it is not fond and loop ends
            UI.println("Card not found!");
        }
    }
    
    /** 
     * mouse listener in response to being clicked.
     */
    private void doMouse(String action, double x, double y) {
        if (action.equals("clicked")) {
            if (cards != null) {
                if (cards.isOnCard(x,y)) {
                    // runs clearAll function if clciked on
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
