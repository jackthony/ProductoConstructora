/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import java.util.Vector;

/**
 *
 * @author TAKESHI
 */
public interface IVistaProyecto {
    void setPresentador(PresentadorProyecto p);
    void iniciar();
    void cerrar();
    public void limpiarCampos();
    public void setSalida(Object[][] fila);
    public void listaEncargadoComboBox(Vector lista);
    public void listaEtapaComboBox(Vector lista);
    public int getBusqueda();
    String getNombre();
    String getEtapa();
    String getEncargado();
    
}
