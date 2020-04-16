/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sd_aula09_light.connection;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *
 * @author bmoritani
 */
public class LightClient {

    public static void main(String[] args)
            throws UnknownHostException, IOException {
        Socket cliente = new Socket("127.0.0.1", 12345);
        System.out.println("O cliente se conectou ao servidor!");
        PrintStream saida = new PrintStream(cliente.getOutputStream());

        saida.println("Hello Server");

        saida.close();
        cliente.close();
    }

}
