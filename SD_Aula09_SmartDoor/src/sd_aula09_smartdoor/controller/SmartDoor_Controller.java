/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sd_aula09_smartdoor.controller;

import javax.swing.SwingUtilities;
import sd_aula09_smartdoor.model.SmartDoor;
import sd_aula09_smartdoor.view.SmartDoorJFrame;

/**
 *
 * @author biizuka
 */
public class SmartDoor_Controller implements ISmartDoor {

    private SmartDoor sd;
    private SmartDoorJFrame frame;

    public SmartDoor_Controller(SmartDoor sd) {
        this.sd = sd;
    }
        
    public boolean checkPassword(String pwd) {
        System.out.println("SmartDoor - checkPassword");
        if (pwd.equals(sd.getPassword())){
            sd.setOpened(true);
            return true;
        }
        return false;
    }
    
    public void closeDoor(){
        System.out.println("SmartDoor - closeDoor");
        this.sd.setOpened(false);
    }
    
}
