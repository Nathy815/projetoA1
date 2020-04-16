/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sd_aula09_waterheater.controller;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author nathy
 */
public interface IAA extends Remote {
    void turnOffOn() throws RemoteException;
    void changeTemperature(float temp) throws RemoteException;
}
