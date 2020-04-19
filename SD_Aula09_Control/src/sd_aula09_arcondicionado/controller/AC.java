/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sd_aula09_arcondicionado.controller;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
import sd_aula09_arcondicionado.controller.IAC;

/**
 *
 * @author nathy
 */
public class AC {
    private static Scanner _scanner;
    
    public AC()
    {
        /*try {
            _scanner = new Scanner(System.in);
            
            System.out.println("O que você deseja fazer (1 a 2)?\n1. Ligar/Desligar\n2. Ligar/Desligar ventilador\n3. Mudar temperatura");
            int option = _scanner.nextInt();

            switch(option)
            {
                case 1:
                    turnOffOn();
                    break;
                case 2:
                    turnWindOffOn();
                    break;
                case 3:
                    _scanner = new Scanner(System.in);
                    System.out.println("Digite a temperatura que deseja:");
                    float temp = _scanner.nextFloat();
                    changeTemperature(temp);
                    break;
                default:
                    System.out.println("Não conseguimos processar sua opção.");
                    break;
            }
        } catch (Exception e) {
            System.err.println("Exceção do Cliente: " + e.toString());
            e.printStackTrace();
        }   */
    }
    
    public void turnOffOn() 
    {
        try
        {
            Registry registry = LocateRegistry.getRegistry("localhost", 18003);
            IAC stub = (IAC) registry.lookup("AC");
            stub.turnOffOn();
        }
        catch (Exception e) {
            System.err.println("Exceção do Cliente: " + e.toString());
            e.printStackTrace();
        }  
    }
    
    public void turnWindOffOn()
    {
        try
        {
            Registry registry = LocateRegistry.getRegistry("localhost", 18003);
            IAC stub = (IAC) registry.lookup("AC");
            stub.turnWindOffOn();
        }
        catch (Exception e) {
            System.err.println("Exceção do Cliente: " + e.toString());
            e.printStackTrace();
        }  
    }
    
    public void changeTemperature(float temp)
    {
        try
        {
            Registry registry = LocateRegistry.getRegistry("localhost", 18003);
            IAC stub = (IAC) registry.lookup("AC");
            stub.changeTemperature(temp);
        }
        catch (Exception e) {
            System.err.println("Exceção do Cliente: " + e.toString());
            e.printStackTrace();
        }  
    }
}
