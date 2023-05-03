/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Dominio.Proyecto;
import Persistencia.DaoFactory;
import Persistencia.DaoMySql;
import Persistencia.DaoProyecto;
import Persistencia.IBuscarPorNombre;
import java.util.List;

/**
 *
 * @author TAKESHI
 */
public class LogicaProyecto {
    private DaoFactory fabrica= new DaoMySql();
    
    public Proyecto crear(Proyecto obj){
        return (Proyecto)fabrica.getProyecto().insertar(obj);
    }
    public void actualizar(Proyecto obj){
        fabrica.getProyecto().actualizar(obj);
    }
    public Proyecto buscar(int id){
        return (Proyecto)fabrica.getProyecto().buscar(id);
    }
    public void eliminar(Proyecto obj){
        fabrica.getProyecto().eliminar(obj);
    }
    public List<Proyecto> listado(){
        return fabrica.getProyecto().listado();
    }
    
    public List<Proyecto> listaProyectosPorEncargado(int id){
        DaoProyecto proy= new DaoProyecto();
        return proy.listaProyectosPorEncargado(id);
    }
    
    public Proyecto buscarPorNombre(String nombre){
        IBuscarPorNombre proy= new DaoProyecto();
        return (Proyecto) proy.buscarNombre(nombre);
    }
    
}
