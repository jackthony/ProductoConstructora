/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Dominio.Usuario;
import java.util.Vector;

/**
 *
 * @author TAKESHI
 */
public interface IVistaAreaNegocio {
    
    void setPresentador(PresentadorAreaNegocio p);
    void iniciar();
    void cerrar();
    public void listaReponsableComboBox(Vector lista);
    public void setSalida(Object[][] fila);
    public void limpiarCampos();
    public String getNombre();
    public int getBusqueda();
    public String getPrefijo();
    public String getResponsable();
    
}
