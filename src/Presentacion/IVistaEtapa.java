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
public interface IVistaEtapa {
    void setPresentador(PresentadorEtapa p);
    void iniciar();
    void cerrar();
    public String getNombre();
    public void setSalida(Object[][] fila);
    public void limpiarCampos();
    public int getBusqueda();
    
}
