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
    final int FANSPEED1 = 1;
    final int FANSPEED2 = 2;
    final int FANSPEED3 = 3;

    final boolean CLOCKWISE = true; // fan direction
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


    // constructor
    // note: assumed default values
    public CeilingFan() {
        rotationSpeed = FANOFF;
        rotationDirection = COUNTERCLOCKWISE;
    }


    public static void main(String[] args) {
        CeilingFan fan = new CeilingFan();

    }

}
