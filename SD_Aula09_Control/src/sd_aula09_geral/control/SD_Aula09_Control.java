/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sd_aula09_geral.control;

import java.util.Scanner;
import sd_aula09_smartdoor.controller.SmartDoor;

/**
 *
 * @author nathy
 */
public class SD_Aula09_Control {

    private static Scanner _scanner;
    
    public static void main(String args[]) {
        _scanner = new Scanner(System.in);
            
        System.out.println("O que você deseja controlar (1 a 5)?\n1. Aquecedor de Água\n2. Ar Condicionado\n3. Luzes\n4. Porta\n5. Smart TV");
        int option = _scanner.nextInt();
        
        switch(option)
        {
            case 1:
                System.out.println("Aquecedor");
                break;
            case 2:
                System.out.println("Ar");
                break;
            case 3:
                System.out.println("Luzes");
                break;
            case 4:
                SmartDoor porta = new SmartDoor();
                break;
            case 5:
                System.out.println("TV");
                break;
            default:
                System.out.println("Não conseguimos processar sua opção.");
                break;
        }
    }
    
}
