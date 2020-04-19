/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sd_aula09_arcondicionado.controller;

import sd_aula09_arcondicionado.model.ArCondicionado;

/**
 *
 * @author biizuka
 */
public class AC_Controller implements IAC {

    private ArCondicionado ac;

    public AC_Controller(ArCondicionado ac) {
        this.ac = ac;
        
    }
        

    public void turnOffOn() {
        if (ac.isPowerButton()) {
            ac.setPowerButton(false);
            System.out.println("Ar - TurnOff");
        } else {
            ac.setPowerButton(true);
            System.out.println("Ar - TurnOn");
        }
    }

    public void turnWindOffOn() {
        if (ac.isWind()) {
            ac.setWind(false);
            System.out.println("Ar - TurnOffWind");
        } else {
            ac.setWind(true);
            System.out.println("Ar - TurnOnWind");
        }
    }
    
    public void changeTemperature(float temp){
        ac.setTemperature(temp);
        System.out.println("Ar - Tempeture");
    }
}
