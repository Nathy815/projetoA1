/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sd_aula09_light.controller;

import sd_aula09_light.model.Light;

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
            System.out.println("Light - turnOff");
        } else {
            lig.setPowerButton(true);
            System.out.println("Light - turnOn");
        }
    }

    public void changeIntensity(int intensity) {
        lig.setIntensity(intensity);
        System.out.println("Light - intensidade");
    }
    
}
