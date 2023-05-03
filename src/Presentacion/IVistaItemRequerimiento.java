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
public interface IVistaItemRequerimiento {
    
    void setPresetador(PresentadorItemRequerimiento p);
    void iniciar();
    void cerrar();
    String getMaterial();
    int getCantidad();
    String getObservaciones();
    int getBusqueda1();
    int getIdRequerimiento();
    public void listaMaterialesComboBox(Vector lista);
    void mostrarDatosRequerimiento(int id, String encargado,int centro, int proyecto, String responsable,Date fecha, String estado);
    public void setSalida(Object[][] fila);
}
