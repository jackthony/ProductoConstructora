/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Dominio.ItemRequerimiento;
import Persistencia.DaoFactory;
import Persistencia.DaoItemRequerimiento;
import Persistencia.DaoMySql;
import Persistencia.IListaPorId;
import java.util.List;

/**
 *
 * @author TAKESHI
 */
public class LogicaItemRequerimiento {
    private DaoFactory fabrica= new DaoMySql();
    
    public ItemRequerimiento crear(ItemRequerimiento obj){
        return (ItemRequerimiento)fabrica.getItemRequerimiento().insertar(obj);
    }
    public void actualizar(ItemRequerimiento obj){
        fabrica.getItemRequerimiento().actualizar(obj);
    }
    public ItemRequerimiento buscar(int id){
        return (ItemRequerimiento)fabrica.getItemRequerimiento().buscar(id);
    }
    public void eliminar(ItemRequerimiento obj){
        fabrica.getItemRequerimiento().eliminar(obj);
    }
    public List<ItemRequerimiento> listado(){
        return fabrica.getItemRequerimiento().listado();
    }

    public List<ItemRequerimiento> listadoId(int id) {
        IListaPorId lista= new DaoItemRequerimiento();
        return lista.ListaBuscarId(id);
    }
}
