/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Dominio.CentroCostos;
import Dominio.EstadoRequerimiento;
import Dominio.ItemRequerimiento;
import Dominio.Proyecto;
import Dominio.Requerimiento;
import Dominio.Usuario;
import Logica.LogicaCentroCosto;
import Logica.LogicaProyecto;
import Logica.LogicaRequerimiento;
import Logica.LogicaUsuario;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author TAKESHI
 */
public class PresentadorRequerimiento {

    private IVistaRequerimiento vista;
    private Usuario encargado;
    private Requerimiento requerimiento;
    private LogicaRequerimiento logica = new LogicaRequerimiento();
    private LogicaUsuario logicusu = new LogicaUsuario();
    private LogicaCentroCosto logicacen = new LogicaCentroCosto();
    private LogicaProyecto logicaproy = new LogicaProyecto();

    public PresentadorRequerimiento(IVistaRequerimiento vista, Usuario encargado, Requerimiento requerimiento) {
        this.vista = vista;
        this.encargado = encargado;
        this.requerimiento = requerimiento;
        listarCentroCostos();
        listarResponsables();
        listarProyectos();
        mostrarRequerimientos();

    }

    public void insertar() {
        requerimiento.setEncargado(logicusu.buscar(encargado.getIdUsuario()));
        requerimiento.setCentrocostos(logicacen.buscarPorNombre(vista.getCentroCostos()));
        requerimiento.setProyecto(logicaproy.buscarPorNombre(vista.getProyecto()));
        requerimiento.setResponsable(logicusu.buscarPorNombre(vista.getResponsable()));
        requerimiento.setFecha(vista.getFecha());
        requerimiento.setEstado(EstadoRequerimiento.PENDIENTE);
        logica.crear(requerimiento);
        mostrarRequerimientos();

    }

    public Requerimiento buscar(int id) {
        requerimiento = logica.buscar(id);
        return requerimiento;
    }

    public void editar() {
        requerimiento = buscar(vista.getBusqueda());
        System.out.println(requerimiento.getEstado().name());
        if (requerimiento.getEstado().name().equals("APROBADO")) {
            vista.inhabilitarEdicion();
            JOptionPane.showMessageDialog(null, "No se puede editar el requerimiento APROBADO");
        } else {
            requerimiento.setEncargado(logicusu.buscar(encargado.getIdUsuario()));
            requerimiento.setCentrocostos(logicacen.buscarPorNombre(vista.getCentroCostos()));
            requerimiento.setProyecto(logicaproy.buscarPorNombre(vista.getProyecto()));
            requerimiento.setResponsable(logicusu.buscarPorNombre(vista.getResponsable()));
            requerimiento.setFecha(vista.getFecha());
            requerimiento.setEstado(EstadoRequerimiento.PENDIENTE);
            logica.actualizar(requerimiento);
            mostrarRequerimientos();
        }

    }

    public void eliminar() {
        requerimiento = buscar(vista.getBusqueda());
        logica.eliminar(requerimiento);
        mostrarRequerimientos();
    }

    public void vistaAsignarMateriales() {
        requerimiento = buscar(vista.getBusqueda());
        IVistaItemRequerimiento vista = new VistaItemRequerimiento();
        ItemRequerimiento item = new ItemRequerimiento();
        PresentadorItemRequerimiento presentador = new PresentadorItemRequerimiento(vista, requerimiento, item);
        vista.setPresetador(presentador);
        vista.iniciar();
        vista.mostrarDatosRequerimiento(requerimiento.getIdRequerimiento(), requerimiento.getEncargado().getNombre(), requerimiento.getCentrocostos().getIdCentroCostos(), requerimiento.getProyecto().getIdProyecto(), requerimiento.getResponsable().getNombre(), requerimiento.getFecha(), requerimiento.getEstado().name());
    }

    private void mostrarRequerimientos() {
        List<Requerimiento> requerimiento = logica.listado();

        Object fila[][] = new Object[requerimiento.size()][7];
        int i = 0;
        for (Requerimiento r : requerimiento) {
            fila[i][0] = r.getIdRequerimiento();
            fila[i][1] = r.getEncargado().getNombre();
            fila[i][2] = r.getCentrocostos().getIdCentroCostos();
            fila[i][3] = r.getProyecto().getIdProyecto();
            fila[i][4] = r.getResponsable().getNombre();
            fila[i][5] = r.getFecha();
            fila[i][6] = r.getEstado().name();

            i++;

        }
        vista.setSalida(fila);
    }

    private void listarCentroCostos() {
        Vector lista = new Vector<>();
        for (CentroCostos r : logicacen.listado()) {
            lista.add(r.getTipo());
        }
        vista.listaCentroComboBox(lista);
    }

    private void listarResponsables() {
        Vector lista = new Vector<>();
        for (Usuario r : logicusu.listadoRolResponsable()) {
            lista.add(r.getNombre());
        }
        vista.listaResponsableComboBox(lista);
    }

    private void listarProyectos() {
        Vector lista = new Vector<>();
        for (Proyecto r : logicaproy.listaProyectosPorEncargado(encargado.getIdUsuario())) {
            lista.add(r.getNombre());
        }
        vista.listaProyectosComboBox(lista);
    }
}
