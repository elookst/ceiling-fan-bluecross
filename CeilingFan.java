/*
 * PROJECT      :   CeilingFan.java
 * PROGRAMMER   :   Erica Luksts
 * PURPOSE      :   This class models the attributes and methods of a ceiling fan. The class contains
 *                  two PullCord objects, which can alter the speed or direction that the fan may be rotating.
 *                  The fan possesses three different speeds or can be turned off completely.
 * ASSUMPTIONS  :   The fan starts in OFF mode and counterclockwise default direction.
 */

public class CeilingFan {
    
    // constants
    final int FANOFF = 0; // fan speed settings
    final int FANSPEEDLOW = 1;
    final int FANSPEEDMED = 2;
    final int FANSPEEDHIGH = 3;

    final boolean CLOCKWISE = true; // fan direction, might change these to forward / reverse
    final boolean COUNTERCLOCKWISE = false;


    // attributes
    private int rotationSpeed; 
    private boolean rotationDirection; 

    public int getSpeed()
    {
        return rotationSpeed;
    }
    public void setSpeed(int speed)
    {
        this.rotationSpeed = speed;
    }

    public boolean getDirection()
    {
        return rotationDirection;
    }
    public void setDirection(boolean direction)
    {
        this.rotationDirection = direction;
    }

    abstract class PullCord {

        // maybe attribute here for cord length

        abstract void Pull();
    }  

    class DirectionPullCord extends PullCord {

        public void Pull() {
            setDirection(!(getDirection()));
        }
    }

    class SpeedPullCord extends PullCord {

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



    // constructor
    // note: assumed default values
    public CeilingFan() {
        rotationSpeed = FANOFF;
        rotationDirection = COUNTERCLOCKWISE;
    }


    public static void main(String[] args) {
        CeilingFan fan = new CeilingFan();

        CeilingFan.DirectionPullCord directionCord = fan.new DirectionPullCord();
        CeilingFan.SpeedPullCord speedCord = fan.new SpeedPullCord();

        
    }

}
