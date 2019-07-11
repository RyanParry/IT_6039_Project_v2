package packer;

/**
 *This Class is for the coordinates for each address, it is used to
 * determine which depot is closest to the customers delivery address. 
 * 
 * @author I.M.Bad
 */
public class Coordinates {
    
    private final double x;
    private final double y;
    
    /**
     * This is the constructor
     * 
     * @param x is the x coordinate on a flat plain
     * @param y is the y coordinate on a flat plain
     */
    public Coordinates(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    /**
     * This gets the x coordinate
     * 
     * @return a double that is distance form a fixed point along an x axis in km
     */
    public double getX() {
        return x;
    }

    /**
     * This gets the y coordinate
     * 
     * @return a double that is distance form a fixed point along an y axis in km
     */
    public double getY() {
        return y;
    }
    
    /**
     * This method is used to get euclidean distance from the current coordinates 
     * to a different coordinate position.
     * 
     * @param other the coordinates of the address being determined how far away
     * @return a double euclidean distance in km
     */
    public double euclideanDistanceTo(Coordinates other) {
        double xDiff = other.getX() - this.getX();
        double yDiff = other.getY() - this.getY();
        double dist = Math.pow((xDiff * xDiff + yDiff * yDiff),0.5);
        return dist;
    }
    
    /**
     *  This method is used to get manhattan distance from the current coordinates 
     * to a different coordinate position.
     * 
     * @param other the coordinates of the address being determined how far away
     * @return a double manhattan distance in km 
     */
    public double manhattanDistanceTo(Coordinates other) {
        double xDiff = other.getX() - this.getX();
        double yDiff = other.getY() - this.getY();
        double dist = Math.abs(xDiff) + Math.abs(yDiff);
        return dist;
    }
    
     /**This method is used to get company distance from the current coordinates 
     * to a different coordinate position.
     * 
     * @param other the coordinates of the address being determined how far away
     * @return a double company distance in km
     * */
    public double companyDistanceTo(Coordinates other) {
        double xDiff1 = other.getX() - this.getX();
        double yDiff1 = other.getY() - this.getY();
        double dist1 = Math.pow((xDiff1 * xDiff1 + yDiff1 * yDiff1),0.5);
        double xDiff2 = other.getX() - this.getX();
        double yDiff2 = other.getY() - this.getY();
        double dist2 = Math.abs(xDiff2) + Math.abs(yDiff2);
        return (dist1 + dist2 + 2)/2;
    }

}
