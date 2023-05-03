/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Dominio.Grupo;
import Persistencia.DaoFactory;
import Persistencia.DaoGrupo;
import Persistencia.DaoMySql;
import Persistencia.IBuscarPorNombre;
import java.util.List;

/**
 *
 * @author TAKESHI
 */
public class LogicaGrupo {
     private DaoFactory fabrica= new DaoMySql() ;
    
    public Grupo crear(Grupo obj){
        return (Grupo)fabrica.getGrupo().insertar(obj);
    }
    public void actualizar(Grupo obj){
        fabrica.getGrupo().actualizar(obj);
    }
    public Grupo buscar(int id){
        return (Grupo)fabrica.getGrupo().buscar(id);
    }
    public void eliminar(Grupo obj){
        fabrica.getGrupo().eliminar(obj);
    }
    public List<Grupo> listado(){
        return fabrica.getGrupo().listado();
    }
    public Grupo buscarpornombre(String nombre){
        IBuscarPorNombre dao= new DaoGrupo();
        return (Grupo)dao.buscarNombre(nombre);
    }
}
