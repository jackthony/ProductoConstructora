/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Presentacion.IVistaLogin;
import Presentacion.PresentadorLogin;
import Presentacion.VistaLogin;



/**
 *
 * @author TAKESHI
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        IVistaLogin vista= new VistaLogin();
        PresentadorLogin presentador= new PresentadorLogin(vista);
        vista.setPresentador(presentador);
        vista.iniciar();
    }
    
}
