/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Dominio.Etapa;
import Persistencia.DaoEtapa;
import Persistencia.DaoFactory;
import Persistencia.DaoMySql;
import Persistencia.IBuscarPorNombre;
import java.util.List;

/**
 *
 * @author TAKESHI
 */
public class LogicaEtapa {
    private DaoFactory fabrica= new DaoMySql();
    
    public Etapa crear(Etapa obj){
        return (Etapa)fabrica.getEtapa().insertar(obj);
    }
    public void actualizar(Etapa obj){
        fabrica.getEtapa().actualizar(obj);
    }
    public Etapa buscar(int id){
        return (Etapa)fabrica.getEtapa().buscar(id);
    }
    public void eliminar(Etapa obj){
        fabrica.getEtapa().eliminar(obj);
    }
    public List<Etapa> listado(){
        return fabrica.getEtapa().listado();
    }
    
    public Etapa buscarPorNombre(String nombre){
        IBuscarPorNombre rol= new DaoEtapa();
        return (Etapa) rol.buscarNombre(nombre);
    }
}
