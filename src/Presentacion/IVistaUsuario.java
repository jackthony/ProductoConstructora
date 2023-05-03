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
public interface IVistaUsuario {
    void setPresentador(PresentadorUsuario p);
    void iniciar();
    String getNombre();
    String getApellido();
    String getUsername();
    String getPassword();
    String getRol();
    int getBusqueda();
    public void listaRolComboBox(Vector lista);
    public void limpiarCampos();
    public void setSalida(Object[][] fila);
    
}
