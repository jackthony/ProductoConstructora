/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;


import Dominio.Usuario;
import Logica.LogicaUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author TAKESHI
 */
public class PresentadorLogin  {

    private IVistaLogin vista;
    private LogicaUsuario logica= new LogicaUsuario();

    public PresentadorLogin(IVistaLogin vista) {
        this.vista = vista;
    }

    public void acceder() {
        String username = vista.getUsername();
        String password = vista.getPassword1();
        if (username.equals("") || password.equals("")) {
            JOptionPane.showMessageDialog(null, "Ingrese todos los campos");
        } else {
            System.out.println(logica.obtenerUsuario(username, password));
            Usuario usuario = logica.obtenerUsuario(username, password);
            if (!username.equals(usuario.getUsername()) && !password.equals(usuario.getPassword())) {
                JOptionPane.showMessageDialog(null, "No estas registrado como usuario del sistema");
            } else {
                String tipo = usuario.getRol().name();
                if (tipo.equals("ADMINISTRADOR")) {
                    IVistaPrincipalAdministrador vista = new VistaPrincipalAdministrador();
                    PresentadorPrincipalAdministrador presentador= new PresentadorPrincipalAdministrador(vista);
                    vista.setPresentador(presentador);
                    vista.iniciar();
                    vista.mostrarUsuario(username);
                    this.vista.cerrar();
                }else if(tipo.equals("ENCARGADO")){
                    IVistaPrincipalEncargado vista= new VistaPrincipalEncargado();
                    PresentadorPrincipalEncargado presentador= new PresentadorPrincipalEncargado(vista,usuario);
                    vista.setPresentador(presentador);
                    vista.iniciar();
                    vista.mostrarUsuario(username);
                    this.vista.cerrar();
                    
                }else if(tipo.equals("RESPONSABLE")){
                    IVistaPrincipalResponsable vista= new VistaPrincipalResponsable();
                    PresentadorPrincipalResponsable presentador= new PresentadorPrincipalResponsable(vista,usuario);
                    vista.setPresentador(presentador);
                    vista.iniciar();
                    vista.mostrarUsuario(username);
                    this.vista.cerrar();
                }
            }

        }
    }
}
