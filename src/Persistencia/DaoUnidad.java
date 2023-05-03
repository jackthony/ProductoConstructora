/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Dominio.Unidad;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author TAKESHI
 */
public class DaoUnidad implements IDao<Unidad>,IBuscarPorNombre<Unidad>{
    private Connection connect = conexion.getInstance();
    @Override
    public Unidad insertar(Unidad obj) {
        try{
            String sql = "INSERT INTO unidad (nombre,prefijo) VALUES(?,?)";
            PreparedStatement ps = this.connect.prepareStatement(sql);
            ps.setString(1,obj.getNombre());
            ps.setString(2, obj.getPrefijo());
            ps.execute();                
        }catch (Exception e){
          return null;
        }
        return obj;
    }

    @Override
    public void actualizar(Unidad obj) {
        try{
            String sql = "UPDATE unidad SET nombre='"+obj.getNombre()+"', prefijo='"+obj.getPrefijo()+"' WHERE idUnidad="+obj.getIdUnidad()+";";
            PreparedStatement statement = this.connect.prepareStatement(sql);
            statement.executeUpdate();
        }catch (Exception e){
          e.printStackTrace();
        } 
    }

    @Override
    public Unidad buscar(int id) {
         try{
            Statement statement=this.connect.createStatement();
            ResultSet rs = statement.executeQuery("select * from unidad where idUnidad="+id+";");           
            if(rs.next()){
                Unidad g = new Unidad();
                g.setIdUnidad(rs.getInt(1));
                g.setNombre(rs.getString(2));
                g.setPrefijo(rs.getString(3));
                return g;
            }else{
                return null;
            }         
        }catch(SQLException e){
            return null;
        } 
    }

    @Override
    public void eliminar(Unidad obj) {
         try{
            String sql = "delete from unidad where idUnidad="+obj.getIdUnidad()+";";
            PreparedStatement statement = this.connect.prepareStatement(sql);
            statement.execute();
        }catch (Exception e){
          e.printStackTrace();
        } 
    }

    @Override
    public List<Unidad> listado() {
         List<Unidad> lista = new ArrayList<>();
        try {
            String sql = "select * from unidad";
            PreparedStatement statement = this.connect.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();           
            while(rs.next()){
                Unidad g = new Unidad();
                g.setIdUnidad(rs.getInt(1));
                g.setNombre(rs.getString(2));
                g.setPrefijo(rs.getString(3));
                lista.add(g);
            }  
        }catch (Exception e){
            e.printStackTrace();
        } 
        return lista;
    }

    @Override
    public Unidad buscarNombre(String nombre) {
        try {
            Statement statement = this.connect.createStatement();
            ResultSet rs = statement.executeQuery("select * from unidad where nombre='" + nombre + "'");
            if (rs.next()) {
                Unidad g = new Unidad();
                g.setIdUnidad(rs.getInt(1));
                g.setNombre(rs.getString(2));
                g.setPrefijo(rs.getString(3));
                return g;
            } else {
                return null;
            }
        } catch (SQLException e) {
            return null;
        } 
    }
    
}
