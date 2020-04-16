/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sd_aula09_light.controller;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author nathy
 */
public interface ILight extends Remote {
    void turnOffOn() throws RemoteException; 
    void changeIntensity(int intensity) throws RemoteException; 
}
