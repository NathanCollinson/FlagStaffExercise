// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a Onslow College 13DTC assignment.
// You may not distribute it in any other way without permission.

/* Exercise for Onslow College 13DTC
 * Name:
 * Email:
 * Date:
 */
import ecs100.*;
import java.awt.Color;

/** A FlagStaff object represents a flag on a flagstaff.
 *   The flagstaff has a pole that is FLAGSTAFF_HEIGHT units high.
 *   It has a flag whose position can be anywhere from the bottom of the pole to the top

 *   The constructor specifies the position of the base of the flagstaff.

 *   The bottom left corner of the flag is initially at the bottom of the pole.
 *   The flag is FLAG_SIZE units high.
 *   The flag can be raised or lowered.
 *
 *   The flag can be as simple as a blue square, but you can draw a more fancy flag if you want
 *
 *   The class has three methods:
 *     - raise(double dist), which changes the flag position on the staff but does not let it go over the top of the flagstaff
 *     - lower(double dist), which changes the flag position on the staff but does not let it go below the bottom of the flagstaff.
 *           Both methods change the field, but do not redraw the flag.
 *     - redraw() which draws the flagstaff [UI.drawLine(....)] and the flag [UI.fillRect(....)]
 */
public class FlagStaff{

    public static final double FLAGSTAFF_HEIGHT = 300;  // 
    public static final double FLAG_SIZE = 30;  //

    // fields,
    // position of the base of the flag staff
    // position of the flag (eg, the position of the bottom of the flag)
    // position of the ground
    
    //Flag Staff Fields
    private double flagStaffBase;
    private double flagStaffHeight = 300;
    private double flagStaffXPosition;
    
    //Flag Fields
    private double flagHeight = 30;
    private double flagWidth = 30;
    private double flagYPosition;
    

    /** Constructor:
     * Parameters: the position of the base of the flag staff
     * Initialises the fields, but does not draw the flag.
     */
    public FlagStaff(double x, double base){
        this.flagStaffXPosition = x;
        this.flagStaffBase = base;
        this.flagYPosition = flagStaffBase;
    }

    /** redraw method:
     * Draws the flagstaff (a line) and the flag (a blue rectangle)*/
    public void redraw(){
        erase();
        UI.setColor(Color.black);
        UI.drawLine(this.flagStaffXPosition, this.flagStaffBase, this.flagStaffXPosition, this.flagStaffBase-FLAGSTAFF_HEIGHT);
        UI.setColor(Color.blue);
        UI.fillRect(this.flagStaffXPosition, this.flagYPosition-flagHeight, this.flagWidth, this.flagHeight);
        UI.sleep(500);
    }

    /** raise method:
     * Parameter:  amount to raise the flag
     * Changes the field, but does not let it go over the top of the flagstaff.
     * Does not redraw the flag.
     */
    public void raise(double amount){
        erase();
        if (this.flagYPosition-flagHeight-amount > 100){
            this.flagYPosition = this.flagYPosition-amount;
        }
        this.redraw();
    }  
    
    /** lower method:
     * Parameter:  amount to lower the flag
     * Changes the field, but does not let it go below the bottom of the flagstaff.
     * Does not redraw the flag.
     */
    public void lower(double amount){
        erase();
        if (this.flagYPosition + amount < this.flagStaffBase){
            this.flagYPosition = this.flagYPosition+amount;
        }
        this.redraw();
    }
    
    /**
     * Erases the flag so that it can be drawn again
     */
    private void erase(){
        UI.eraseRect(this.flagStaffXPosition, this.flagYPosition-flagHeight, this.flagWidth, this.flagHeight);
    }   
}


