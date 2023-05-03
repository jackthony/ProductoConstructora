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
public interface IVistaMaterial {
    void setPresentador(PresentadorMaterial p);
    String getNombre();
    String getUnidad();
    String getGrupo();
    int getBusqueda();
    void iniciar();
    void cerrar();
    public void listaGrupoComboBox(Vector lista);
    public void listaUnidadComboBox(Vector lista);
    public void setSalida(Object[][] fila);
    public void limpiarCampos();
}
