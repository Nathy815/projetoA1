/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sd_aula09_waterheater.controller;

import sd_aula09_waterheater.model.AquecedorAgua;

/**
 *
 * @author biizuka
 */
public class AA_Controller implements IAA {

    private AquecedorAgua aa;

    public AA_Controller(AquecedorAgua aa) {
        this.aa = aa;
        
    }
        

    public void turnOffOn() {
        if (aa.isPowerButton()) {
            System.out.println("Aquecedor - TurnOff");
            aa.setPowerButton(false);
        } else {
            System.out.println("Aquecedor - TurnOn");
            aa.setPowerButton(true);
        }
    }

    
    public void changeTemperature(float temp){
        aa.setTemperature(temp);
        System.out.println("Aquecedor - Tempeture");
    }
}
