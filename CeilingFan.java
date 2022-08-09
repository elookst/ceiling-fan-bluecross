/*
 * PROJECT      :   CeilingFan.java
 * PROGRAMMER   :   Erica Luksts
 * PURPOSE      :   This class models the attributes and methods of a ceiling fan. The class contains
 *                  two PullCord objects, which can alter the speed or direction that the fan may be rotating.
 *                  The fan possesses three different speeds or can be turned off completely.
 * ASSUMPTIONS  :   The fan starts in OFF mode and forward default direction. Assumed forward
 *                  direction based on email description and not clockwise / counterclockwise.
 * ADDITIONAL NOTES :   I did not include any testing code or a user interface for this class.
 */

public class CeilingFan {
    
    // constants
    // the constants here are used to set fan speed settings and fan directions

    final int FANOFF = 0; 
    final int FANSPEEDLOW = 1;
    final int FANSPEEDMED = 2;
    final int FANSPEEDHIGH = 3;

    final boolean FORWARD = true; 
    final boolean REVERSE = false;


    // attributes
    private int rotationSpeed; 
    private boolean rotationDirection; 

    // returns fan speed
    public int getSpeed()
    {
        return rotationSpeed;
    }
    // sets the fan speed
    public void setSpeed(int speed)
    {
        this.rotationSpeed = speed;
    }

    // returns fan direction
    public boolean getDirection()
    {
        return rotationDirection;
    }
    // sets the fan direction
    public void setDirection(boolean direction)
    {
        this.rotationDirection = direction;
    }

    // Abstract Class PullCord
    // This class sets the requirements for each pull cord
    // It specifies that each pull cord must be able to be pulled by the user
    // A future version of this class could implement a cord length or label attribute
    abstract class PullCord {

        // maybe abstract int attribute here for cord length if it is determined that each
        // pull cord has a different length for differing between each other
        // alternatively, maybe there is a label or tag on each pullcord (string)

        abstract void Pull();
    }  


    // CLASS    :   DirectionPullCord
    // This class is a type of pull cord, that contains one method for pulling the cord
    // Pulling the cord will reverse the current direction that the fan is rotating
    class DirectionPullCord extends PullCord {

        // attribute for pull cord length or possibly a label on the cord (string)
        
        // reverses the direction of the ceiling fan
        public void Pull() {
            setDirection(!(getDirection()));
        }
    }


    // CLASS    :   SpeedPullCord
    // This class is a type of pull cord, that contains one method for pulling the cord
    // Pulling the cord will adjust the speed of the fan
    class SpeedPullCord extends PullCord {

        // attribute for pull cord length or possible a label on the cord (string)


        // Increases the speed of the fan unless current speed is MAX
        // If at max speed, it will turn off the fan.
        public void Pull() {
            if (getSpeed() != FANSPEEDHIGH)
            {
                setSpeed(getSpeed() + 1);
            }
            else
            {
                setSpeed(FANOFF);
            }
        }
    }


    // constructor - creates the ceiling fan object and sets initial values for parameters
    // note: assumed default values
    public CeilingFan() {
        rotationSpeed = FANOFF;
        rotationDirection = FORWARD;
    }

    // Main method
    // Creates a new ceiling fan object and pull cord objects
    // returns void
    public static void main(String[] args) {
        CeilingFan fan = new CeilingFan();

        CeilingFan.DirectionPullCord directionCord = fan.new DirectionPullCord();
        CeilingFan.SpeedPullCord speedCord = fan.new SpeedPullCord();

        
    }

}
