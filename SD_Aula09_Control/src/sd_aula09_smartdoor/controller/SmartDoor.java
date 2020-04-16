/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sd_aula09_smartdoor.controller;

import sd_aula09_smartdoor.controller.ISmartDoor;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

/**
 *
 * @author nathy
 */
public class SmartDoor {
    private static Scanner _scanner;
    
    public SmartDoor()
    {
        try {
            // Pegando o registro 
            Registry registry = LocateRegistry.getRegistry("localhost", 18000);

            // Procurando por um registro que utilize a Interface ISmartDoor
            ISmartDoor stub = (ISmartDoor) registry.lookup("SmartDoor");

            _scanner = new Scanner(System.in);
            
            System.out.println("O que você deseja fazer (1 a 2)?\n1. Abrir\n2. Fechar");
            int option = _scanner.nextInt();

            switch(option)
            {
                case 1:
                    boolean correct = true;
                    do
                    {
                        _scanner = new Scanner(System.in);
                        System.out.println("Digite a senha:");
                        String pass = _scanner.next();
                        correct = stub.checkPassword(pass);
                        if (!correct)
                            System.out.println("Senha incorreta! Tente novamente.");
                    }
                    while(!correct);
                    break;
                case 2:
                    stub.closeDoor();
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
