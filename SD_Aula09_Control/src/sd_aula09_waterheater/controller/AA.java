/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sd_aula09_waterheater.controller;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
import sd_aula09_waterheater.controller.IAA;

/**
 *
 * @author nathy
 */
public class AA {
    private Scanner _scanner;
    
    public AA()
    {
        try {
            // Pegando o registro 
            Registry registry = LocateRegistry.getRegistry("localhost", 18004);

            // Procurando por um registro que utilize a Interface ISmartDoor
            IAA stub = (IAA) registry.lookup("AA");

            _scanner = new Scanner(System.in);
            
            System.out.println("O que você deseja fazer (1 a 3)?\n1. Ligar/Desligar\n2. Mudar a temperatura");
            int option = _scanner.nextInt();

            switch(option)
            {
                case 1:
                    stub.turnOffOn();
                    break;
                case 2:
                    _scanner = new Scanner(System.in);
                    System.out.println("Digite a temperatura que deseja:");
                    float temp = _scanner.nextFloat();
                    stub.changeTemperature(temp);
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
