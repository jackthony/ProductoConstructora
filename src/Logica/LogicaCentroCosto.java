/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Dominio.CentroCostos;
import Persistencia.DaoCentroCosto;
import Persistencia.DaoFactory;
import Persistencia.DaoMySql;
import Persistencia.IBuscarPorNombre;
import java.util.List;

/**
 *
 * @author TAKESHI
 */
public class LogicaCentroCosto {
    private DaoFactory fabrica= new DaoMySql();
    
    public CentroCostos crear(CentroCostos c){
        return (CentroCostos) fabrica.getCentroCostos().insertar(c);
    }
    public void actualizar(CentroCostos c){
        fabrica.getCentroCostos().actualizar(c);
    }
    public CentroCostos buscar(int id){
        return (CentroCostos)fabrica.getCentroCostos().buscar(id);
    }
    public void eliminar(CentroCostos obj){
        fabrica.getCentroCostos().eliminar(obj);
    }
    public List<CentroCostos> listado(){
        return fabrica.getCentroCostos().listado();
    }
    public CentroCostos buscarPorNombre(String nombre){
        IBuscarPorNombre cen= new DaoCentroCosto();
        return (CentroCostos)cen.buscarNombre(nombre);
    }
}
