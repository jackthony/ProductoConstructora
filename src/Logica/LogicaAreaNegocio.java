/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Dominio.AreaNegocio;
import Persistencia.DaoFactory;
import Persistencia.DaoMySql;
import java.util.List;

/**
 *
 * @author TAKESHI
 */
public class LogicaAreaNegocio {
    private DaoFactory fabrica= new DaoMySql();
    
    public AreaNegocio crear(AreaNegocio obj){
        return (AreaNegocio)fabrica.getAreaNegocio().insertar(obj);
    }
    public void actualizar(AreaNegocio obj){
        fabrica.getAreaNegocio().actualizar(obj);
    }
    public AreaNegocio buscar(int id){
        return (AreaNegocio)fabrica.getAreaNegocio().buscar(id);
    }
    public void eliminar(AreaNegocio obj){
        fabrica.getAreaNegocio().eliminar(obj);
    }
    public List<AreaNegocio> listado(){
        return fabrica.getAreaNegocio().listado();
    }
}
