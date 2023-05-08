import ecs100.*;
/**
 * Support class of library.
 * A card contains a name, monetary value and image.
 *
 * @author (Phoebe Williamson)
 * @version (9/5/23)
 */
public class Cards
{
    // instance variables 
    private String name;
    private String price;
    private String image;
    private int locX = 50;
    private int locY = 50;
    private final double WIDTH = 220;
    private final double HEIGHT = 300;
    private static final String DEFALUT_IMAGE = "pokemon_card.jpg";

    /**
     * Constructor for objects of class Cards.
     */
    public Cards() {
        // initialise instance variables
        
    }

    /**
     * Constructer overloading the objects of class Cards.
     */
    
    /**
     * Getter for name of pokémon.
     * @return String of the pokémon.
     */
    
    /**
     * Display image on GUI.
     */
    
    /**
     * Getter for monetary value.
     * @return int of tthe price.
     */
    
    /**
     * Getter for the image.
     * @returns the image
     */
    
    /**
     * Checks if the image is clicked on.
     */
    public boolean isOnCard(double x, double y ) {
        if ((x >= locX) && (x <= locX + WIDTH) && (y >= locY) && (y <= locY + HEIGHT)) {
            return true;
            
        } else {
            return false;
        }
    }
}
