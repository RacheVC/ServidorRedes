/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sockets;
import java.io.IOException;
import sockets.Cliente;


/**
 *
 * @author PC
 */
public class Main {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        Cliente c=new Cliente("25.100.179.146", 9990);
        c.iniciar();
    }
    
}
