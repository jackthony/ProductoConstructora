/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Dominio.Unidad;
import Persistencia.DaoFactory;
import Persistencia.DaoMySql;
import Persistencia.DaoUnidad;
import Persistencia.IBuscarPorNombre;
import java.util.List;


/**
 *
 * @author TAKESHI
 */
public class LogicaUnidad {
    private DaoFactory fabrica= new DaoMySql() ;
    
    public Unidad crear(Unidad obj){
        return (Unidad)fabrica.getUnidad().insertar(obj);
    }
    public void actualizar(Unidad obj){
        fabrica.getUnidad().actualizar(obj);
    }
    public Unidad buscar(int id){
        return (Unidad)fabrica.getUnidad().buscar(id);
    }
    public void eliminar(Unidad obj){
        fabrica.getUnidad().eliminar(obj);
    }
    public List<Unidad> listado(){
        return fabrica.getUnidad().listado();
    }
    public Unidad buscarpornombre(String nombre){
        IBuscarPorNombre dao= new DaoUnidad();
        return (Unidad)dao.buscarNombre(nombre);
    }
    
}
