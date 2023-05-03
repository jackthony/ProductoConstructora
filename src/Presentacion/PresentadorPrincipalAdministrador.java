/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Dominio.AreaNegocio;
import Dominio.CentroCostos;
import Dominio.Material;
import Dominio.Proyecto;
import Dominio.Unidad;
import Dominio.Usuario;

/**
 *
 * @author TAKESHI
 */
public class PresentadorPrincipalAdministrador {
    private IVistaPrincipalAdministrador vista;

    public PresentadorPrincipalAdministrador(IVistaPrincipalAdministrador vista) {
        this.vista = vista;
    }
    
    public void vistaGestionMaterial(){
        IVistaMaterial vista= new VistaMaterial();
        Material material= new Material();
        PresentadorMaterial presentador= new PresentadorMaterial(vista,material);
        vista.setPresentador(presentador);
        vista.iniciar();
    }
    public void vistaGestionCentroCostos(){
        IVistaCentroCosto vista= new VistaCentroCosto();
        CentroCostos centro= new CentroCostos();
        PresentadorCentroCosto presentador= new PresentadorCentroCosto(vista, centro);
        vista.setPresentador(presentador);
        vista.iniciar();
    }
    
    public void vistaGestionUsuario(){
        IVistaUsuario vista= new VistaUsuario();
        Usuario usuario= new Usuario();
        PresentadorUsuario presentador= new PresentadorUsuario(vista, usuario);
        vista.setPresentador(presentador);
        vista.iniciar();
    }
    
    public void vistaGestionUnidad(){
        IVistaUnidad vista= new VistaUnidad();
        Unidad unidad= new Unidad();
        PresentadorUnidad presentador= new PresentadorUnidad(vista, unidad);
        vista.setPresentador(presentador);
        vista.iniciar();
    }
    
    public void vistaGestionAreaNegocio(){
        IVistaAreaNegocio vista= new VistaAreaNegocio();
        AreaNegocio area= new AreaNegocio();
        PresentadorAreaNegocio presentador= new PresentadorAreaNegocio(vista, area);
        vista.setPresentador(presentador);
        vista.iniciar();
    }
    public void vistaGestionProyecto(){
        IVistaProyecto vista= new VistaProyecto();
        Proyecto proyecto= new Proyecto();
        PresentadorProyecto presentador= new PresentadorProyecto(vista, proyecto);
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
