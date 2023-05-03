/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Dominio.Grupo;
import Dominio.Material;
import Dominio.Unidad;
import Logica.LogicaGrupo;
import Logica.LogicaMaterial;
import Logica.LogicaUnidad;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author TAKESHI
 */
public class PresentadorMaterial {
    private IVistaMaterial vista;
    private Material material;
    private LogicaMaterial logicamat= new LogicaMaterial();
    private LogicaGrupo logicagrup= new LogicaGrupo();
    private LogicaUnidad logicaunid= new LogicaUnidad();
    
    public PresentadorMaterial(IVistaMaterial vista, Material m){
        this.vista=vista;
        this.material= m;
        listarUnidades();
        listarGrupos();
        mostrarMateriales();
    }
    
    public void insertar(){
        material.setNombre(vista.getNombre());
        material.setUnidad(logicaunid.buscarpornombre(vista.getUnidad()));
        material.setGrupo(logicagrup.buscarpornombre(vista.getGrupo()));
        logicamat.crear(material);
        mostrarMateriales();
        vista.limpiarCampos();
    }
    public Material buscar(int id){
        material=logicamat.buscar(id);
        return material;
    }
    public void editar(){
        material= buscar(vista.getBusqueda());
        material.setNombre(vista.getNombre());
        material.setUnidad(logicaunid.buscarpornombre(vista.getUnidad()));
        material.setGrupo(logicagrup.buscarpornombre(vista.getGrupo()));
        logicamat.actualizar(material);
        mostrarMateriales();
        vista.limpiarCampos();
    }
    
    public void eliminar(){
        material= buscar(vista.getBusqueda());
        logicamat.eliminar(material);
        mostrarMateriales();
        vista.limpiarCampos();
    }
    
    private void mostrarMateriales(){
        List<Material> usuario = logicamat.listado();
            
        Object fila[][] = new Object[usuario.size()][4];
        int i=0;
        for (Material r : usuario) {
            fila[i][0]= r.getIdMaterial();
            fila[i][1]= r.getNombre();
            fila[i][2]= r.getUnidad().getNombre();
            fila[i][3]= r.getGrupo().getNombre();

            i++;

        }    
        vista.setSalida(fila);
    }
    
    private void listarGrupos(){
        Vector lista= new Vector<>();
        for(Grupo r: logicagrup.listado()){
            lista.add(r.getNombre());
        }
        vista.listaGrupoComboBox(lista);
    }
    private void listarUnidades(){
         Vector lista= new Vector<>();
        for(Unidad r: logicaunid.listado()){
            lista.add(r.getNombre());
        }
        vista.listaUnidadComboBox(lista);
    }
}
