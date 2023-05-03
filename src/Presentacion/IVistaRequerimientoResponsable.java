/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

/**
 *
 * @author TAKESHI
 */
public interface IVistaRequerimientoResponsable {
    void setPresentador(PresentadorRequerimientosResponsable p);
    void iniciar();
    void cerrar();
    int getBusqueda();
    public void setSalida(Object[][] fila);
}
