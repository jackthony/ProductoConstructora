/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Dominio.CentroCostos;
import Logica.LogicaCentroCosto;
import java.util.List;

/**
 *
 * @author TAKESHI
 */
public class PresentadorCentroCosto {
    
    private IVistaCentroCosto vista;
    private CentroCostos modelo;
    private LogicaCentroCosto logica= new LogicaCentroCosto();
    public PresentadorCentroCosto(IVistaCentroCosto vista, CentroCostos modelo) {
        this.vista = vista;
        this.modelo = modelo;
        mostrarCentro();
    }
    
    public void insertar(){
        modelo.setTipo(vista.getNombre());
        logica.crear(modelo);
        mostrarCentro();
        vista.limpiarCampos();
    }
    public CentroCostos buscar(int id){
        modelo=logica.buscar(id);
        return modelo;
    }
    public void editar(){
        modelo= buscar(vista.getBusqueda());
        modelo.setTipo(vista.getNombre());
        logica.actualizar(modelo);
        mostrarCentro();
        vista.limpiarCampos();
    }
    
    public void eliminar(){
        modelo= buscar(vista.getBusqueda());
        logica.eliminar(modelo);
        mostrarCentro();
        vista.limpiarCampos();
    }
    
    private void mostrarCentro(){
        List<CentroCostos> centro = logica.listado();
            
        Object fila[][] = new Object[centro.size()][2];
        int i=0;
        for (CentroCostos r : centro) {
            fila[i][0]= r.getIdCentroCostos();
            fila[i][1]= r.getTipo();

            i++;

        }    
        vista.setSalida(fila);
    }
    
    
}
