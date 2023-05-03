/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

public interface IVistaLogin {
    
    void setPresentador(PresentadorLogin p);
    String getUsername();
    String getPassword1();
    void iniciar();
    void cerrar();
}
