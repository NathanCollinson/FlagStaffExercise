// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a Onslow College 13DTC assignment.
// You may not distribute it in any other way without permission.

/* Exercise for Onslow College 13DTC
 * Name: Takumi G, Nathan C, Jamie T (didn't do anything)
 * Email: Nathan.Collinson@student.onslow.school.nz,
 * Takumi.Grainger@student.onslow.school.nz,
 * Jamie.Truman@student.onslow.school.nz
 * Date: 12/05/2020
 */

import ecs100.*;
import java.awt.Color;

/** Exercise for defining objects.
 *  This program contains methods for testing Lamp, PartyBalloon, and FlagStaff objects.
 *  It is all written for you, but you need to read it to see what the
 *  Lamp, PartyBalloon, and FlagStaff classes should do
 */

public class FlagStaffExercise{

    private static final double GROUND = 400;
    private static final int STAFF = 110;
    private FlagStaff flag1 = new FlagStaff(STAFF, GROUND-1); // offset so it's flush to the ground
    private static final double MIN = 1;
    private static final double MAX = 50;
    private double amount = 25.0;
    private String lastCountry = " ";

    /** 
     * Makes two FlagStaff objects and makes the flags go up and down.
     */
    public void doFlagStaff(){
        this.clear();
        
        flag1.redraw();
        UI.sleep(500);

        int steps = 0;
        UI.println("Make flags go up");
        while (steps < 8){
            // make flags go up by a random amount 
            flag1.raise(Math.random()*100);

            //UI.clearGraphics();
            //this.drawGround();
            //flag1.redraw();

            UI.sleep(500);
            steps++;   //(shorthand for steps = steps + 1;
        }
        UI.println("Make flags go down");
        while (steps> 0){
            // make flags go down by a random fraction
            flag1.lower(Math.random()*100);

            //UI.clearGraphics();
            //this.drawGround();
            //flag1.redraw();

            UI.sleep(500);
            steps--;   //(shorthand for steps = steps - 1;
        }
    }

    public void drawGround(){
        UI.setColor(new Color(120, 80, 0));   // dark brown
        UI.fillRect(0,GROUND,600,10);  
    }

    public void clear(){
        UI.clearPanes();
        this.drawGround();
    }

    /** doRaise method:
     * raise the flag*/
    private void doRaise() {
        flag1.raise(amount);
    } 
    
    /** doLower method:
     * lower the flag*/
    private void doLower() {
        flag1.lower(amount);
    }    
        
    /** setAmount method:
     * @param the amount to raise or lower flag by*/
    private void setAmount(double amt) {
        amount = amt;
    }    
    
    /** printCountry method:
     * @param words to print to screen
     * Prints at the base of the Flag
     */
    private void printCountry(String words){
        UI.setColor(new Color(255, 255, 255)); // white
        UI.drawString(lastCountry, STAFF, GROUND + 24); // clear last string
        UI.setColor(new Color(0, 0, 0)); // black
        UI.drawString(words, 110, GROUND + 24); // new string
        lastCountry = words; // update last string
    }
    
    /** Create a new FlagStaff object and setup the interface */
    public static void main(String[] args){
        FlagStaffExercise fse = new FlagStaffExercise();
        fse.drawGround();
        UI.addButton("Clear", fse::clear );
        UI.addButton("FlagStaff", fse::doFlagStaff );
        
        // Add buttons, textfield, slider
        UI.addButton("Raise", fse::doRaise);
        UI.addButton("Lower", fse::doLower);
        UI.addSlider("Amount", MIN, MAX, fse::setAmount);
        UI.addTextField("Country", fse::printCountry);
        UI.addButton("Quit", UI::quit );
    }

}
