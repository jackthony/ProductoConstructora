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
public class PresentadorPrincipalResponsable {
    private IVistaPrincipalResponsable vista;
    private Usuario responsable;

    public PresentadorPrincipalResponsable(IVistaPrincipalResponsable vista,Usuario responsable) {
        this.vista = vista;
        this.responsable=responsable;
    }
    
    public void listaRequerimientos(){
        IVistaRequerimientoResponsable vista= new VistaRequerimientosResponsable();
        Requerimiento req= new Requerimiento();
        PresentadorRequerimientosResponsable presentador= new PresentadorRequerimientosResponsable(vista, req, responsable);
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
