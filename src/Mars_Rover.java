import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Diana Ghitun on 22/01/2017.
 */
public class Mars_Rover {

    public static void main(String[] args) {

        try {

            // use a scanner to read from the input text file
            Scanner sc = new Scanner(new File("input.txt"));


            // get the limits of the plateau representing the number of rows and columns respectively
            String upper_right = sc.nextLine();
            String[] upper_right_arr = upper_right.split(" ");


            // variables for the number of rows and columns
            int lim_x = Integer.parseInt(upper_right_arr[0]) +1;
            int lim_y = Integer.parseInt(upper_right_arr[1]) +1;


            // create the plateau matrix
            Rover[][] plateau = new Rover[lim_x][lim_y];


            // continue reading from the input file
            while(sc.hasNext()){

                String new_rover = sc.nextLine();
                String[] new_rover_arr = new_rover.split(" ");

                int x = Integer.parseInt(new_rover_arr[0]);
                int y = Integer.parseInt(new_rover_arr[1]);
                char cardinal_point = new_rover_arr[2].charAt(0);


                // create a new rover with the values from the input file
                if(cardinal_point == 'N' || cardinal_point == 'S' || cardinal_point == 'E' || cardinal_point == 'W') {
                    if(checkInterval(x,y,lim_x,lim_y)) {
                        Rover rv = new Rover(x, y, cardinal_point);


                        // the coordinate for the row of the matrix calculated using the position in the graph
                        int coord_x = lim_x-1-y;


                        if (plateau[coord_x][x] == null) {

                            // if the cell is empty, place the newly created rover there
                            plateau[coord_x][x] = rv;
                            rv.setOnMars(); // set the boolean variable onMars to true


                            // get the sequence of the moves for the current rover
                            String moves = sc.nextLine();
                            char[] moves_arr = moves.toCharArray();


                            // iterate through the sequence of moves and execute each one of them
                            for(int i=0; i<moves_arr.length; i++) {

                                // rotate left
                                if (moves_arr[i] == 'L') {
                                    rv.rotateLeft();

                                    // rotate right
                                } else if (moves_arr[i] == 'R') {
                                    rv.rotateRight();

                                    // move one cell
                                } else if (moves_arr[i] == 'M'){
                                    plateau = moveRover(rv, plateau, lim_x, lim_y);
                                } else {
                                    System.out.println(moves_arr[i] + " is not a valid move");
                                }
                            }


                            // print output for rover only if set on the plateau
                            if(rv.isOnMars())
                                System.out.println(rv.printRover());
                        }
                        else {

                            // if the cell is not empty, you cannot place a new rover here
                            System.out.println("You cannot place new rover on occupied position (" + coord_x + "," + x + ")!");
                            sc.nextLine(); // ignore the moves for this rover
                        }
                    }
                } else {
                    System.out.println("Rover with coordinates " + x + ", " + y + " and cardinal point " + cardinal_point + " cannot be placed in the plateau!");
                    sc.nextLine(); // ignore the moves for this rover
                }

            }

            // printPlateau(plateau, lim_x, lim_y);

        } catch (FileNotFoundException e) {
            System.out.println("The file input.txt does not exist");
        }
    }

    /** Method to move a rover to a new cell according to orientation of possible.
     * The rover will be moved only if the new cell is empty.
     * Otherwise, the rover will remain to the old position.
     *
     * @param rv
     * @param plateau
     * @param lim_x
     * @param lim_y
     * @return the modified plateau matrix
     */
    public static Rover[][] moveRover(Rover rv, Rover[][] plateau, int lim_x, int lim_y){

        // get the current coordinates of the rover before changing them
        int last_x = rv.getX();
        int last_y = rv.getY();


        // change the cell according to the orientation of the rover
        switch (rv.getCardinal_point()) {
            case 'N': {
                rv.setY(last_y + 1);
                break;
            }
            case 'S': {
                rv.setY(last_y - 1);
                break;
            }
            case 'E': {
                rv.setX(last_x + 1);
                break;
            }
            case 'W': {
                rv.setX(last_x - 1);
                break;
            }
        }


        // check if the new coordinates fit inside the plateau
        if(checkInterval(rv.getX(), rv.getY(), lim_x, lim_y)) {

            // check if the new cell is empty for the rover to move there
            if (plateau[lim_x - 1 - rv.getY()][rv.getX()] == null) {

                // make the old cell empty
                plateau[lim_x - 1 - last_y][last_x] = null;

                plateau[lim_x - 1 - rv.getY()][rv.getX()] = rv;
            } else {

                // if the new cell is not empty, you cannot place the current rover in here
                rv.setX(last_x);
                rv.setY(last_y);
            }
        } else {

            //if the new coordinates are outside the plateau, the rover will stay to the intial cell
            rv.setX(last_x);
            rv.setY(last_y);
        }

        return plateau;
    }

    /** Method to print all rows and columns of the plateau matrix
     *
     * @param plateau
     * @param lim_x
     * @param lim_y
     */
    public static void printPlateau (Rover[][] plateau, int lim_x, int lim_y) {

        for(int i=0;i<lim_y;i++) {
            for (int j = 0; j < lim_x; j++) {
                if (plateau[i][j] != null)
                    // print the output of the rover if there is one in this cell
                    System.out.print(plateau[i][j].printRover() + " ");
                else
                    System.out.print("NULL ");
            }
            System.out.println();
        }
    }

    public static boolean checkInterval (int x, int y, int lim_x, int lim_y) {
        return (x<lim_x && y<lim_y) && (x>=0 && y>=0);
    }
}