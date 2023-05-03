/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Dominio.Etapa;
import Logica.LogicaEtapa;
import java.util.List;

/**
 *
 * @author TAKESHI
 */
public class PresentadorEtapa {
    private IVistaEtapa vista;
    private Etapa etapa;
    private LogicaEtapa logica= new LogicaEtapa();
    
    public PresentadorEtapa(IVistaEtapa vista, Etapa etapa){
        this.vista=vista;
        this.etapa=etapa;
        mostrarEtapa();
    }
    
    public void insertar(){
        etapa.setNombre(vista.getNombre());
        logica.crear(etapa);
        mostrarEtapa();
        vista.limpiarCampos();
    }
    public Etapa buscar(int id){
        etapa=logica.buscar(id);
        return etapa;
    }
    public void editar(){
        etapa= buscar(vista.getBusqueda());
        etapa.setNombre(vista.getNombre());
        logica.actualizar(etapa);
        mostrarEtapa();
        vista.limpiarCampos();
    }
    
    public void eliminar(){
        etapa= buscar(vista.getBusqueda());
        logica.eliminar(etapa);
        mostrarEtapa();
        vista.limpiarCampos();
    }
    
    private void mostrarEtapa(){
        List<Etapa> etapa = logica.listado();
            
        Object fila[][] = new Object[etapa.size()][2];
        int i=0;
        for (Etapa r : etapa) {
            fila[i][0]= r.getIdEtapa();
            fila[i][1]= r.getNombre();

            i++;
        }    
        vista.setSalida(fila);
    }
}
