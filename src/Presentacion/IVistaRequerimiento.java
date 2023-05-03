/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import java.sql.Date;
import java.util.Vector;

/**
 *
 * @author TAKESHI
 */
public interface IVistaRequerimiento {
    void setPresentador(PresentadorRequerimiento p);
    void iniciar();
    void cerrar();
    String getResponsable();
    String getCentroCostos();
    String getProyecto();
    int getBusqueda();
    Date getFecha();
    public void setSalida(Object[][] fila);
    public void listaCentroComboBox(Vector lista);
    public void listaResponsableComboBox(Vector lista);
    public void inhabilitarEdicion();
    public void listaProyectosComboBox(Vector lista);
}
