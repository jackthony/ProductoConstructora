/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import java.util.List;

/**
 *
 * @author TAKESHI
 */
public interface IBuscarPorRol<T> {
    public List<T> buscarResponsable();
    public List<T> buscarEncargado();
}
