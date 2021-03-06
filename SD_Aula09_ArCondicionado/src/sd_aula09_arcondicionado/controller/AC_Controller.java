/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sd_aula09_arcondicionado.controller;

import sd_aula09_arcondicionado.model.ArCondicionado;
import sd_aula09_arcondicionado.view.ArCondicionadoJFrame;

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
        } else {
            ac.setPowerButton(true);
        }
        ArCondicionadoJFrame.getInstance().OnOffVisibility();
    }

    public void turnWindOffOn() {
        if (ac.isWind()) {
            ac.setWind(false);
        } else {
            ac.setWind(true);
        }
        ArCondicionadoJFrame.getInstance().WindVisibility();
    }
    
    public void changeTemperature(float temp){
        ac.setTemperature(temp);
        ArCondicionadoJFrame.getInstance().TemperatureVisibility();
    }
}
