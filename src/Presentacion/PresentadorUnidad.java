/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Dominio.Unidad;
import Logica.LogicaUnidad;
import java.util.List;

/**
 *
 * @author TAKESHI
 */
public class PresentadorUnidad {
    private IVistaUnidad vista;
    private Unidad modelo;
    private LogicaUnidad logica= new LogicaUnidad();
    
    public PresentadorUnidad(IVistaUnidad vista, Unidad u){
        this.vista=vista;
        this.modelo=u;
        mostrarUnidades();
    }
    
    public void insertar(){
        modelo.setNombre(vista.getNombre());
        modelo.setPrefijo(vista.getPrefijo());
        logica.crear(modelo);
        mostrarUnidades();
        vista.limpiarCampos();
    }
    public Unidad buscar(int id){
        modelo=logica.buscar(id);
        return modelo;
    }
    public void editar(){
        modelo.setNombre(vista.getNombre());
        modelo.setPrefijo(vista.getPrefijo());
        logica.actualizar(modelo);
        mostrarUnidades();
        vista.limpiarCampos();
    }
    
    public void eliminar(){
        modelo= buscar(vista.getBusqueda());
        logica.eliminar(modelo);
        mostrarUnidades();
        vista.limpiarCampos();
    }
    
    private void mostrarUnidades(){
        List<Unidad> unidad = logica.listado();
            
        Object fila[][] = new Object[unidad.size()][3];
        int i=0;
        for (Unidad r : unidad) {
            fila[i][0]= r.getIdUnidad();
            fila[i][1]= r.getNombre();
            fila[i][2]= r.getPrefijo();

            i++;
        }    
        vista.setSalida(fila);
    }
}
