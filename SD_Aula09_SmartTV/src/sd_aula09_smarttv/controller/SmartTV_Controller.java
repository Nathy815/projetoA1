/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sd_aula09_smarttv.controller;

import java.io.IOException;
import sd_aula09_smarttv.model.SmartTV;
import sd_aula09_smarttv.view.SmartTVJFrame;

/**
 *
 * @author biizuka
 */
public class SmartTV_Controller implements ISmartTV {

    private SmartTV stv;

    public SmartTV_Controller(SmartTV stv) {
        this.stv = stv;
    }

    public void turnOffOn() {
        if (stv.isPowerButton()) {
            stv.setPowerButton(false);
        } else {
            stv.setPowerButton(true);
        }    
        SmartTVJFrame.getIntance().PowerVisibility();
    }

    public void changeChannel(int channel) {
        stv.setChannel(channel);
        SmartTVJFrame.getIntance().ChannelVisibility();
    }
    
    public void changeVolume(int volume){
        stv.setVolume(volume);
        SmartTVJFrame.getIntance().VolumeVisibility();
    }
}
