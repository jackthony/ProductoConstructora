/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Dominio.AreaNegocio;
import Dominio.Usuario;
import Logica.LogicaAreaNegocio;
import Logica.LogicaUsuario;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author TAKESHI
 */
public class PresentadorAreaNegocio {

    private IVistaAreaNegocio vista;
    private AreaNegocio modelo;
    private LogicaAreaNegocio logica = new LogicaAreaNegocio();
    private LogicaUsuario logicausu = new LogicaUsuario();

    public PresentadorAreaNegocio(IVistaAreaNegocio vista, AreaNegocio modelo) {
        this.vista = vista;
        this.modelo = modelo;
        listarResponsables();
        mostrarArea();
    }

    public void insertar() {
        modelo.setPrefijo(vista.getPrefijo());
        modelo.setNombre(vista.getNombre());
        modelo.setResponsable(logicausu.buscarPorNombre(vista.getResponsable()));
        modelo = logica.crear(modelo);
        if (modelo != null) {
            mostrarArea();
            vista.limpiarCampos();
        }else{
            JOptionPane.showMessageDialog(null, "El responsable ya fue asignado, escoja otro");
            vista.limpiarCampos();
        }

    }

    public AreaNegocio buscar(int id) {
        modelo = logica.buscar(id);
        return modelo;
    }

    public void editar() {
        modelo = buscar(vista.getBusqueda());
        modelo.setPrefijo(vista.getPrefijo());
        modelo.setNombre(vista.getNombre());
        modelo.setResponsable(logicausu.buscarPorNombre(vista.getResponsable()));
        logica.actualizar(modelo);
        mostrarArea();
        vista.limpiarCampos();
    }

    public void eliminar() {
        modelo = buscar(vista.getBusqueda());
        logica.eliminar(modelo);
        mostrarArea();
        vista.limpiarCampos();
    }

    private void mostrarArea() {
        List<AreaNegocio> area = logica.listado();
        System.out.println(area);
        Object fila[][] = new Object[area.size()][4];
        int i = 0;
        for (AreaNegocio r : area) {
            fila[i][0] = r.getIdArea();
            fila[i][1] = r.getPrefijo();
            fila[i][2] = r.getNombre();
            fila[i][3] = r.getResponsable().getNombre();
            i++;
        }
        vista.setSalida(fila);
    }

    private void listarResponsables() {
        Vector lista = new Vector<>();
        for (Usuario r : logicausu.listadoRolResponsable()) {
            lista.add(r.getNombre());
        }
        vista.listaReponsableComboBox(lista);
    }
}
