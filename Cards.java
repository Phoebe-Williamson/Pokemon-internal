import ecs100.*;
/**
 * Support class of library.
 * A card contains a name, monetary value and image.
 *
 * @author (Phoebe Williamson)
 * @version (15/5/23)
 */
public class Cards
{
    // instance variables 
    private String name;
    private int price;
    private String image;
    private int locX = 50;
    private int locY = 50;
    private final double WIDTH = 220;
    private final double HEIGHT = 300;
    private static final String DEFALUT_IMAGE = "pokemon_card.jpeg";

    /**
     * Constructor for objects of class Cards.
     */
    public Cards(String nm, int prc, String img) {
        // initialise instance variables
        this.name = nm;
        this.price = prc;
        
        // if the user selects cancel instead of giving an image
        if (img == null) {
            this.image = DEFALUT_IMAGE;
        } else {
            this.image = img;
        }
    }
    
    /**
     * Getter for name of pokémon.
     * @return String of the pokémon.
     */
    public String getName() {
        return this.name;
        
    }
    
    /**
     * Display image on GUI.
     */
    public void displayCard() {
        UI.drawImage(this.image, this.locY, this.locY, this.WIDTH, this.HEIGHT);
    }
    
    /**
     * Getter for monetary value.
     * @return int of the price.
     */
    public int getPrice() {
        return this.price;
    }
    
    /**
     * Getter for the image.
     * @returns the image
     */
    public String getImage() {
        return this.image;
        
    }
    
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
