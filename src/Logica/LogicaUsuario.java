/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Dominio.Usuario;
import Persistencia.DaoFactory;
import Persistencia.DaoGrupo;
import Persistencia.DaoMySql;
import Persistencia.DaoUsuario;
import Persistencia.IBuscarPorNombre;
import Persistencia.IBuscarPorRol;
import Persistencia.IObtenerUsuario;
import java.util.List;

/**
 *
 * @author TAKESHI
 */
public class LogicaUsuario {
    private DaoFactory fabrica= new DaoMySql();
    
    public Usuario crear(Usuario u){
        return (Usuario)fabrica.getUsuario().insertar(u);
    }
    public void actualizar(Usuario obj){
        fabrica.getUsuario().actualizar(obj);
    }
    public Usuario buscar(int id){
        return (Usuario)fabrica.getUsuario().buscar(id);
    }
    public void eliminar(Usuario obj){
        fabrica.getUsuario().eliminar(obj);
    }
    public List<Usuario> listado(){
        return fabrica.getUsuario().listado();
    }
    public List<Usuario> listadoRolResponsable(){
        IBuscarPorRol rol= new DaoUsuario();
        return rol.buscarResponsable();
    }
    public List<Usuario> listadoRolEncargado(){
        IBuscarPorRol rol= new DaoUsuario();
        return rol.buscarEncargado();
    }
    public Usuario obtenerUsuario(String username, String password){
        IObtenerUsuario usu= new DaoUsuario();
        return (Usuario)usu.obtenerUsuario(username, password);
    }
    public Usuario buscarPorNombre(String nombre){
        IBuscarPorNombre usu= new DaoUsuario();
        return (Usuario)usu.buscarNombre(nombre);
    }
}
