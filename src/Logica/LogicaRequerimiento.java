/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Dominio.Requerimiento;
import Persistencia.DaoFactory;
import Persistencia.DaoMySql;
import Persistencia.DaoRequerimiento;
import java.util.List;

/**
 *
 * @author TAKESHI
 */
public class LogicaRequerimiento {
    private DaoFactory fabrica= new DaoMySql();
    
    public Requerimiento crear(Requerimiento obj){
        return (Requerimiento)fabrica.getRequerimiento().insertar(obj);
    }
    public void actualizar(Requerimiento obj){
        fabrica.getRequerimiento().actualizar(obj);
    }
    public Requerimiento buscar(int id){
        return (Requerimiento)fabrica.getRequerimiento().buscar(id);
    }
    public void eliminar(Requerimiento obj){
        fabrica.getRequerimiento().eliminar(obj);
    }
    public List<Requerimiento> listado(){
        return fabrica.getRequerimiento().listado();
    }
    
    public List<Requerimiento> listaRequerimientoResponsable(int idResponsable){
        DaoRequerimiento req= new DaoRequerimiento();
        return req.listaRequerimientoResponsable(idResponsable);
    }
    
    public void actualizarEstado(String estado, int id){
        DaoRequerimiento req= new DaoRequerimiento();
         req.actualizarRequerimiento(estado, id);
    }
}
