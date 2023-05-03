/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Dominio.Requerimiento;
import Dominio.Usuario;

/**
 *
 * @author TAKESHI
 */
public class PresentadorPrincipalEncargado {
    private IVistaPrincipalEncargado vista;
    private Usuario encargado;

    public PresentadorPrincipalEncargado(IVistaPrincipalEncargado vista, Usuario encargado) {
        this.vista = vista;
        this.encargado=encargado;
    }
    public void vistaGestionRequerimiento(){
        IVistaRequerimiento vista= new VistaRequerimiento();
        Requerimiento requerimiento= new Requerimiento();
        PresentadorRequerimiento presentador= new PresentadorRequerimiento(vista,encargado,requerimiento);
        vista.setPresentador(presentador);
        vista.iniciar();
    }
    public void salir() {

        IVistaLogin v = new VistaLogin();
        PresentadorLogin presentador = new PresentadorLogin(v);
        v.setPresentador(presentador);
        v.iniciar();
        this.vista.cerrar();

    }
}
