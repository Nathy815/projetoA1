/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sd_aula09_geral.control;

import java.util.Scanner;
import sd_aula09_arcondicionado.controller.AC;
import sd_aula09_light.controller.Light;
import sd_aula09_smartdoor.controller.SmartDoor;
import sd_aula09_smarttv.controller.SmartTV;
import sd_aula09_waterheater.controller.AA;

/**
 *
 * @author nathy
 */
public class SD_Aula09_Control {

    private static Scanner _scanner;
    
    /*public static void main(String args[]) {
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
    }*/
    
    public boolean SmartDoor_Open(String pass)
    {
        SmartDoor door = new SmartDoor();
        return door.checkPassword(pass);
    }
 
    public void SmartDoor_Close()
    {
        SmartDoor door = new SmartDoor();
        door.closeDoor();
    }
    
    public void SmartLight_TurnOffOn()
    {
        Light light = new Light();
        light.SmartLight_TurnOnOff();
    }
    
    public void SmartLight_ChangeIntensity(int intensity) 
    {
        Light light = new Light();
        light.SmartLight_Intensity(intensity);
    }
    
    public void SmartAquecedor_TurnOffOn()
    {
        AA aquecedor = new AA();
        aquecedor.turnOffOn();
    }
    
    public void SmartAquecedor_ChangeTemperature(float temp)
    {
        AA aquecedor = new AA();
        aquecedor.changeTemperature(temp);
    }
    
    public void SmartAr_TurnOnOff()
    {
        AC ar = new AC();
        ar.turnOffOn();
    }
    
    public void SmartAr_TurnOnOffWind()
    {
        AC ar = new AC();
        ar.turnWindOffOn();
    }
    
    public void SmartAr_ChangeTempeture(float temp)
    {
        AC ar = new AC();
        ar.changeTemperature(temp);
    }
    
    public void SmartTV_TurnOnOff()
    {
        SmartTV tv = new SmartTV();
        tv.turnOffOn();
    }
    
    public void SmartTV_Channel(int channel)
    {
        SmartTV tv = new SmartTV();
        tv.changeChannel(channel);
    }
    
    public void SmartTV_Volume(int volume)
    {
        SmartTV tv = new SmartTV();
        tv.changeVolume(volume);
    }
}
