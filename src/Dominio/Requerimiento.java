/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import java.sql.Date;
import java.util.List;

/**
 *
 * @author TAKESHI
 */
public class Requerimiento {

    private int idRequerimiento;
    private CentroCostos centrocostos;
    private Usuario responsable;
    private Usuario encargado;
    private EstadoRequerimiento estado;
    private Date fecha;
    private Proyecto proyecto;
    
    private List<ItemRequerimiento> listaItems;

    public List<ItemRequerimiento> getListaItems() {
        return listaItems;
    }

    public void setListaItems(List<ItemRequerimiento> listaItems) {
        this.listaItems = listaItems;
    }
    

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    public int getIdRequerimiento() {
        return idRequerimiento;
    }

    public void setIdRequerimiento(int idRequerimiento) {
        this.idRequerimiento = idRequerimiento;
    }

    public CentroCostos getCentrocostos() {
        return centrocostos;
    }

    public void setCentrocostos(CentroCostos centrocostos) {
        this.centrocostos = centrocostos;
    }

    public Usuario getResponsable() {
        return responsable;
    }

    public void setResponsable(Usuario responsable) {
        this.responsable = responsable;
    }

    public EstadoRequerimiento getEstado() {
        return estado;
    }

    public void setEstado(EstadoRequerimiento estado) {
        this.estado = estado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Usuario getEncargado() {
        return encargado;
    }

    public void setEncargado(Usuario encargado) {
        this.encargado = encargado;
    }

}
