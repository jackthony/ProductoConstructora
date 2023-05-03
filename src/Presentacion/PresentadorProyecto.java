/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Dominio.Etapa;
import Dominio.Proyecto;
import Dominio.Usuario;
import Logica.LogicaEtapa;
import Logica.LogicaProyecto;
import Logica.LogicaUsuario;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author TAKESHI
 */
public class PresentadorProyecto {

    private IVistaProyecto vista;
    private Proyecto proyecto;
    private LogicaProyecto logica = new LogicaProyecto();
    private LogicaUsuario logicausu = new LogicaUsuario();
    private LogicaEtapa logicaeta = new LogicaEtapa();

    public PresentadorProyecto(IVistaProyecto vista, Proyecto proyecto) {
        this.vista = vista;
        this.proyecto = proyecto;
        listarEncargado();
        listarEtapa();
        mostrarProyectos();
    }

    public void insertar() {

        proyecto.setEncargado(logicausu.buscarPorNombre(vista.getEncargado()));
        proyecto.setEtapa(logicaeta.buscarPorNombre(vista.getEtapa()));
        proyecto.setNombre(vista.getNombre());
        logica.crear(proyecto);
        mostrarProyectos();
        vista.limpiarCampos();
    }

    public Proyecto buscar(int id) {
        proyecto = logica.buscar(id);
        return proyecto;
    }

    public void editar() {
        proyecto = buscar(vista.getBusqueda());
        proyecto.setEncargado(logicausu.buscarPorNombre(vista.getEncargado()));
        proyecto.setEtapa(logicaeta.buscarPorNombre(vista.getEtapa()));
        proyecto.setNombre(vista.getNombre());
        logica.actualizar(proyecto);
        mostrarProyectos();
        vista.limpiarCampos();
    }

    public void eliminar() {
        proyecto = buscar(vista.getBusqueda());
        logica.eliminar(proyecto);
        mostrarProyectos();
        vista.limpiarCampos();
    }

    public void nuevaEtapa() {
        IVistaEtapa vista = new VistaEtapa();
        Etapa etapa = new Etapa();
        PresentadorEtapa presentador = new PresentadorEtapa(vista, etapa);
        vista.setPresentador(presentador);
        vista.iniciar();
        listarEtapa();
    }

    private void mostrarProyectos() {
        List<Proyecto> proy = logica.listado();

        Object fila[][] = new Object[proy.size()][4];
        int i = 0;
        for (Proyecto r : proy) {
            fila[i][0] = r.getIdProyecto();
            fila[i][1] = r.getEncargado().getNombre();
            fila[i][2] = r.getEtapa().getNombre();
            fila[i][3] = r.getNombre();
            i++;
        }
        vista.setSalida(fila);
    }

    private void listarEncargado() {
        Vector lista = new Vector<>();
        for (Usuario r : logicausu.listadoRolEncargado()) {
            lista.add(r.getNombre());
        }
        vista.listaEncargadoComboBox(lista);
    }

    private void listarEtapa() {
        Vector lista = new Vector<>();
        for (Etapa r : logicaeta.listado()) {
            lista.add(r.getNombre());
        }
        vista.listaEtapaComboBox(lista);
    }
}
