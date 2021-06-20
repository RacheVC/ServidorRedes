/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor.util;

/**
 *
 * @author rache
 */
import java.io.*;
import java.net.*;
import java.util.*;

public class ServidorPrincipal //Se hereda de conexión para hacer uso de los sockets y demás
{
    private ServerSocket sServidor;
    private Socket sCliente;
    private Scanner entrada;
    private PrintStream salida;
    private final int puerto;
    private String mensaje = "";

    public ServidorPrincipal(int p) {
        puerto = p;
    }

    public void iniciar() {
        try {
            sServidor = new ServerSocket(puerto);
            System.out.println(" - SERVIDOR INICIADO - ");
            System.out.println(" - Esperando Cliente - ");
            sCliente = sServidor.accept();
            entrada = new Scanner(sCliente.getInputStream());
            salida = new PrintStream(sCliente.getOutputStream());
//Se reenvía los mensajes que van llegando hasta q el cliente introduzca la palabra
//”bye”,
            while (!mensaje.equals("fin")) {
                mensaje = entrada.next();
                System.out.println("Mensaje cliente: " + mensaje);
                salida.println("Eco:_" + mensaje);
            }
            finalizar();
        } catch (IOException e) {
            System.out.println(e);
            finalizar();
        }
    }

    public void finalizar() {
        try {
            salida.close();
            entrada.close();
            sCliente.close();
            sServidor.close();
            System.out.print("Conexion Finalizada!!");
        } catch (IOException e) {
           System.out.println(e);
        }
    }
}


