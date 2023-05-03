/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import java.util.List;

/**
 *
 * @author jackt
 */
enum EstadoOC{
    APROBADO, CANCELADO;
}
public class OrdenDeCompra {
    
    private List<Requerimiento> listaRequerimientos;
    private int numOC;
    private String moneda;
    private EstadoOC estado;
    
    
    
    public List<Requerimiento> getListaRequerimientos() {
        return listaRequerimientos;
    }

    public void setListaRequerimientos(List<Requerimiento> listaRequerimientos) {
        this.listaRequerimientos = listaRequerimientos;
    }

    public int getNumOC() {
        return numOC;
    }

    public void setNumOC(int numOC) {
        this.numOC = numOC;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }
    
    
    
}
