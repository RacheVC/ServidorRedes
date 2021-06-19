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
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ServidorPrincipal extends Conexion //Se hereda de conexión para hacer uso de los sockets y demás
{
    public ServidorPrincipal() throws IOException{super("servidor");} //Se usa el constructor para servidor de Conexion

    public void startServer()//Método para iniciar el servidor
    {
        try
        {
            System.out.println("Esperando..."); //Esperando conexión

            cs = ss.accept(); //Accept comienza el socket y espera una conexión desde un cliente

            System.out.println("Cliente en línea");

            //Se obtiene el flujo de salida del cliente para enviarle mensajes
            salidaCliente = new DataOutputStream(cs.getOutputStream());

            //Se le envía un mensaje al cliente usando su flujo de salida
            salidaCliente.writeUTF("Petición recibida y aceptada");

            //Se obtiene el flujo entrante desde el cliente
            BufferedReader entrada = new BufferedReader(new InputStreamReader(cs.getInputStream()));

            while("Fin".equals(mensajeServidor = entrada.readLine())) //Mientras haya mensajes desde el cliente
            {
                System.out.println("Fin de la conexión");

                ss.close();//Se finaliza la conexión con el cliente
                //Se muestra por pantalla el mensaje recibido

            }

              System.out.println(mensajeServidor);
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
}

