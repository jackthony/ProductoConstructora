/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Dominio.EstadoRequerimiento;
import Dominio.Requerimiento;
import Dominio.Usuario;
import Logica.LogicaRequerimiento;
import java.util.List;

/**
 *
 * @author TAKESHI
 */
public class PresentadorRequerimientosResponsable {
    private IVistaRequerimientoResponsable vista;
    private Requerimiento req;
    private LogicaRequerimiento logic= new LogicaRequerimiento();
    private Usuario usu;

    public PresentadorRequerimientosResponsable(IVistaRequerimientoResponsable vista, Requerimiento req, Usuario usu) {
        this.vista = vista;
        this.req = req;
        this.usu = usu;
        listarRequerimientoResponsable();
    }
    
    
    public void aprobarRequerimiento(){
        req= logic.buscar(vista.getBusqueda());
        req.setEstado(EstadoRequerimiento.APROBADO);
        String estado= req.getEstado().name();
        logic.actualizarEstado(estado, req.getIdRequerimiento());
        listarRequerimientoResponsable();
    }
    
    
    
    
    private void listarRequerimientoResponsable(){
        int id= usu.getIdUsuario();
        List<Requerimiento> requerimiento = logic.listaRequerimientoResponsable(id);
            
        Object fila[][] = new Object[requerimiento.size()][7];
        int i=0;
        for (Requerimiento r : requerimiento) {
            fila[i][0]= r.getIdRequerimiento();
            fila[i][1]= r.getEncargado().getNombre();
            fila[i][2]= r.getCentrocostos().getIdCentroCostos();
            fila[i][3]= r.getProyecto().getIdProyecto();
            fila[i][4]= r.getResponsable().getNombre();
            fila[i][5]= r.getFecha();
            fila[i][6]= r.getEstado().name();
            i++;
        }    
        vista.setSalida(fila);
        
    }
    
    
}
