/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Dominio.Rol;
import Dominio.Usuario;
import Logica.LogicaUsuario;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author TAKESHI
 */
public class PresentadorUsuario {
    private IVistaUsuario vista;
    private Usuario usuario;
    private LogicaUsuario logica= new LogicaUsuario();
    
    public PresentadorUsuario(IVistaUsuario vista, Usuario u){
        this.vista=vista;
        this.usuario=u;
        listarRoles();
        mostrarUsuarios();
    }
    
    public void insertar(){
        usuario.setNombre(vista.getNombre());
        usuario.setApellido(vista.getApellido());
        usuario.setUsername(vista.getUsername());
        usuario.setPassword(vista.getPassword());
        usuario.setRol(Rol.valueOf(vista.getRol()));    
        logica.crear(usuario);
        mostrarUsuarios();
        vista.limpiarCampos();
    }
    public Usuario buscar(int id){
        usuario=logica.buscar(id);
        return usuario;
    }
    public void editar(){
        usuario= buscar(vista.getBusqueda());
        usuario.setNombre(vista.getNombre());
        usuario.setApellido(vista.getApellido());
        usuario.setUsername(vista.getUsername());
        usuario.setPassword(vista.getPassword());
        usuario.setRol(Rol.valueOf(vista.getRol())); 
        logica.actualizar(usuario);
        mostrarUsuarios();
        vista.limpiarCampos();
    }
    
    public void eliminar(){
        usuario= buscar(vista.getBusqueda());
        logica.eliminar(usuario);
        mostrarUsuarios();
        vista.limpiarCampos();
    }
    private void mostrarUsuarios(){
        List<Usuario> usuario = logica.listado();
            
        Object fila[][] = new Object[usuario.size()][6];
        int i=0;
        for (Usuario r : usuario) {
            fila[i][0]= r.getIdUsuario();
            fila[i][1]= r.getNombre();
            fila[i][2]= r.getApellido();
            fila[i][3]= r.getUsername();
            fila[i][4]= r.getPassword();
            fila[i][5]= r.getRol().name();

            i++;

        }    
        vista.setSalida(fila);
    }
    
    private void listarRoles(){
        Vector lista= new Vector<>();
        for(Rol r: Rol.values()){
            lista.add(r.name());
        }
        vista.listaRolComboBox(lista);
    }
}
