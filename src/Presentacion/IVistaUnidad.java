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
public interface IVistaUnidad {
    void setPresentador(PresentadorUnidad p);
    void iniciar();
    void cerrar();
    public void setSalida(Object[][] fila);
    public void limpiarCampos();
    public String getNombre();
    public String getPrefijo();
    public int getBusqueda();
    
}
