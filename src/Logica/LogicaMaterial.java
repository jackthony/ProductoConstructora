/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Dominio.Material;
import Persistencia.DaoFactory;
import Persistencia.DaoMaterial;
import Persistencia.DaoMySql;
import Persistencia.IBuscarPorNombre;
import java.util.List;

/**
 *
 * @author TAKESHI
 */
public class LogicaMaterial {
    private DaoFactory fabrica= new DaoMySql() ;
    
    public Material crear(Material obj){
        return (Material)fabrica.getMaterial().insertar(obj);
    }
    public void actualizar(Material obj){
        fabrica.getMaterial().actualizar(obj);
    }
    public Material buscar(int id){
        return (Material)fabrica.getMaterial().buscar(id);
    }
    public void eliminar(Material obj){
        fabrica.getMaterial().eliminar(obj);
    }
    public List<Material> listado(){
        return fabrica.getMaterial().listado();
    }
    public Material buscarPorNombre(String nombre){
        IBuscarPorNombre mat= new DaoMaterial();
        return (Material) mat.buscarNombre(nombre);
    }
}
