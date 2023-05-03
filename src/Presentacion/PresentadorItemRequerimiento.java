/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Dominio.ItemRequerimiento;
import Dominio.Material;
import Dominio.Requerimiento;
import Logica.LogicaItemRequerimiento;
import Logica.LogicaMaterial;
import Logica.LogicaRequerimiento;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author TAKESHI
 */
public class PresentadorItemRequerimiento {
    private IVistaItemRequerimiento vista;
    private Requerimiento req;
    private ItemRequerimiento item;
    private LogicaItemRequerimiento logica= new LogicaItemRequerimiento();
    private LogicaRequerimiento logicareq= new LogicaRequerimiento();
    private LogicaMaterial logicamat= new LogicaMaterial();

    public PresentadorItemRequerimiento(IVistaItemRequerimiento vista, Requerimiento req, ItemRequerimiento item) {
        this.vista = vista;
        this.req = req;
        this.item = item;
        listarMateriales();
        mostrarDetalle();
    }
    
    public void insertar(){
        item.setRequerimiento(logicareq.buscar(vista.getIdRequerimiento()));
        item.setMaterial(logicamat.buscarPorNombre(vista.getMaterial()));
        item.setCantidad(vista.getCantidad());
        item.setObervaciones(vista.getObservaciones());
        logica.crear(item);
        mostrarDetalle();
    }
    
    private void mostrarDetalle() {
        int id= req.getIdRequerimiento();
        List<ItemRequerimiento> detalle = logica.listadoId(id);

        Object fila[][] = new Object[detalle.size()][5];
        int i = 0;
        for (ItemRequerimiento r : detalle) {
            fila[i][0] = r.getMaterial().getGrupo().getIdGrupo();
            fila[i][1] = r.getMaterial().getNombre();
            fila[i][2] = r.getMaterial().getUnidad().getPrefijo();
            fila[i][3] = r.getCantidad();
            fila[i][4] = r.getObervaciones();
            i++;

        }
        vista.setSalida(fila);
    }

    private void listarMateriales() {
        Vector lista = new Vector<>();
        for (Material r : logicamat.listado()) {
            lista.add(r.getNombre());
        }
        vista.listaMaterialesComboBox(lista);
    }
    
}
