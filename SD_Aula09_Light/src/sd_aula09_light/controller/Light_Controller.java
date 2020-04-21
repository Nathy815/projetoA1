/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sd_aula09_light.controller;

import sd_aula09_light.model.Light;
import sd_aula09_light.view.LightJFrame;

/**
 *
 * @author biizuka
 */
public class Light_Controller implements ILight {

    private Light lig;

    public Light_Controller(Light lig) {
        this.lig = lig;
        
    }
        

    public void turnOffOn() {
        if (lig.isPowerButton()) {
            lig.setPowerButton(false);
        } else {
            lig.setPowerButton(true);
        }
        LightJFrame.getInstance().PowerVisibility();
    }

    public void changeIntensity(int intensity) {
        lig.setIntensity(intensity);
        LightJFrame.getInstance().IntensityVisibility();
    }
    
}
