/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import servidor.util.ServidorPrincipal;

/**
 *
 * @author rache
 */
public class Servidor {

    /**
     * @param arg
     */
    public static void main(String arg[]) {
        ServidorPrincipal sp = new ServidorPrincipal(9990);
        sp.iniciar();

    }

}
