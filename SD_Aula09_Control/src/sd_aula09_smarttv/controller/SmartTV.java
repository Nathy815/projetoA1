/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sd_aula09_smarttv.controller;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
import sd_aula09_smarttv.controller.ISmartTV;

/**
 *
 * @author nathy
 */
public class SmartTV {
    
    private Scanner _scanner;
    
    public SmartTV()
    {
        /*try {
            _scanner = new Scanner(System.in);
            
            System.out.println("O que você deseja fazer (1 a 3)?\n1. Ligar/Desligar\n2. Mudar o canal\n3. Alterar o volume");
            int option = _scanner.nextInt();

            switch(option)
            {
                case 1:
                    turnOffOn();
                    break;
                case 2:
                    _scanner = new Scanner(System.in);
                    System.out.println("Digite o canal que deseja:");
                    int canal = _scanner.nextInt();
                    changeChannel(canal);
                    break;
                case 3:
                    _scanner = new Scanner(System.in);
                    System.out.println("Digite o volume que deseja:");
                    int vol = _scanner.nextInt();
                    changeVolume(vol);
                    break;
                default:
                    System.out.println("Não conseguimos processar sua opção.");
                    break;
            }
        } catch (Exception e) {
            System.err.println("Exceção do Cliente: " + e.toString());
            e.printStackTrace();
        } */
    }
    
    public void turnOffOn()
    {
        try
        {
            Registry registry = LocateRegistry.getRegistry("localhost", 18001);
            ISmartTV stub = (ISmartTV) registry.lookup("SmartTV");
            stub.turnOffOn();
        }
        catch (Exception e) {
            System.err.println("Exceção do Cliente: " + e.toString());
            e.printStackTrace();
        } 
    }
    
    public void changeChannel(int channel)    
    {
        try
        {
            Registry registry = LocateRegistry.getRegistry("localhost", 18001);
            ISmartTV stub = (ISmartTV) registry.lookup("SmartTV");
            stub.changeChannel(channel);
        }
        catch (Exception e) {
            System.err.println("Exceção do Cliente: " + e.toString());
            e.printStackTrace();
        } 
    }
    
    public void changeVolume(int volume)
    {
        try
        {
            Registry registry = LocateRegistry.getRegistry("localhost", 18001);
            ISmartTV stub = (ISmartTV) registry.lookup("SmartTV");
            stub.changeVolume(volume);
        }
        catch (Exception e) {
            System.err.println("Exceção do Cliente: " + e.toString());
            e.printStackTrace();
        } 
    }
}
