/**
 * Created by Diana Ghitun on 22/01/2017.
 */
public class Rover {

    private int x;
    private int y;
    private char cardinal_point;

    boolean onMars = false; //variable to check if current rover is on the plateau

    public Rover(int x, int y, char cardinal_point){
        this.x = x;
        this.y = y;
        this.cardinal_point = cardinal_point;
    }


    /** Method for rotating the rover to the left.
     * It will change the cardinal_point variable of the rover accordingly.
     */
    public void rotateLeft(){
        switch (cardinal_point) {
            case 'N':
                cardinal_point = 'W';
                break;
            case 'S':
                cardinal_point = 'E';
                break;
            case 'E':
                cardinal_point = 'N';
                break;
            case 'W':
                cardinal_point = 'S';
                break;
            default:
                System.out.println(cardinal_point + " is not a valid cardinal point");
                break;
        }
    }


    /** Method for rotating the rover to the right.
     * It will change the cardinal_point variable of the rover accordingly.
     */
    public void rotateRight(){
        switch (cardinal_point) {
            case 'N':
                cardinal_point = 'E';
                break;
            case 'S':
                cardinal_point = 'W';
                break;
            case 'E':
                cardinal_point = 'S';
                break;
            case 'W':
                cardinal_point = 'N';
                break;
            default:
                System.out.println(cardinal_point + " is not a valid cardinal point");
                break;
        }
    }


    /** Method to print the coordinates and orientation of the rover.
     *
     * @return the String to be used as output
     */
    public String printRover(){
        return x+ " "+ y+ " "+ cardinal_point;
    }


    /** Accessor methods for private attributes of the rover.
     *
     * @return one of the x, y coordinates or the cardinal point of the rover
     */
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public char getCardinal_point(){
        return cardinal_point;
    }


    /** Setter methods to modify private attributes of the rover.
     *
     * @param x,y
     */
    public void setX(int x) { this.x = x;}

    public void setY(int y) { this.y = y;}


    /** Setter method to modify the boolean attribute onMars when the rover is set on the plateau.
     *
     */
    public void setOnMars(){ onMars = true; }


    /** Check method to determine if the rover is set on the plateau.
     *
     * @return the value of the private boolean attribute onMars
     */
    public boolean isOnMars() { return onMars; }
}

