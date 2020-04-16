/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sd_aula09_light.controller;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
import sd_aula09_light.controller.ILight;

/**
 *
 * @author nathy
 */
public class Light {
    private static Scanner _scanner;
    
    public Light()
    {
        try {
            // Pegando o registro 
            Registry registry = LocateRegistry.getRegistry("localhost", 18002);

            // Procurando por um registro que utilize a Interface ISmartDoor
            ILight stub = (ILight) registry.lookup("Light");

            _scanner = new Scanner(System.in);
            
            System.out.println("O que você deseja fazer (1 a 2)?\n1. Ligar/Desligar\n2. Mudar intensidade");
            int option = _scanner.nextInt();

            switch(option)
            {
                case 1:
                    stub.turnOffOn();
                    break;
                case 2:
                    _scanner = new Scanner(System.in);
                    System.out.println("Digite a intesidade que deseja:");
                    int intensity = _scanner.nextInt();
                    stub.changeIntensity(intensity);
                    break;
                default:
                    System.out.println("Não conseguimos processar sua opção.");
                    break;
            }
        } catch (Exception e) {
            System.err.println("Exceção do Cliente: " + e.toString());
            e.printStackTrace();
        }   
    }
}
