/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Dominio.Etapa;
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
public class DaoEtapa implements IDao<Etapa>,IBuscarPorNombre<Etapa> {

    private Connection connect = conexion.getInstance();

    @Override
    public Etapa insertar(Etapa obj) {
        try {
            String sql = "INSERT INTO etapa (nombre) VALUES(?)";
            PreparedStatement ps = this.connect.prepareStatement(sql);
            ps.setString(1, obj.getNombre());
            ps.execute();
        } catch (Exception e) {
            return null;
        }
        return obj;
    }

    @Override
    public void actualizar(Etapa obj) {
        try{
            String sql = "UPDATE grupo SET nombre='"+obj.getNombre()+"' WHERE idEtapa="+obj.getIdEtapa()+"";
            PreparedStatement statement = this.connect.prepareStatement(sql);
            statement.executeUpdate();
        }catch (Exception e){
          e.printStackTrace();
        } 
    }

    @Override
    public Etapa buscar(int id) {
        try{
            Statement statement=this.connect.createStatement();
            ResultSet rs = statement.executeQuery("select * from etapa where idEtapa="+id+";");           
            if(rs.next()){
                Etapa g = new Etapa();
                g.setIdEtapa(rs.getInt(1));
                g.setNombre(rs.getString(2));
                return g;
            }else{
                return null;
            }         
        }catch(SQLException e){
            return null;
        } 
    }

    @Override
    public void eliminar(Etapa obj) {
       try{
            String sql = "delete from etapa where idEtapa="+obj.getIdEtapa()+";";
            PreparedStatement statement = this.connect.prepareStatement(sql);
            statement.execute();
        }catch (Exception e){
          e.printStackTrace();
        } 
    }

    @Override
    public List<Etapa> listado() {
        List<Etapa> listaGrupo = new ArrayList<>();
        try {
            String sql = "select * from etapa";
            PreparedStatement statement = this.connect.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();           
            while(rs.next()){
                Etapa g = new Etapa();
                g.setIdEtapa(rs.getInt(1));
                g.setNombre(rs.getString(2));
                listaGrupo.add(g);
            }  
        }catch (Exception e){
            e.printStackTrace();
        } 
        return listaGrupo;
    }


    @Override
    public Etapa buscarNombre(String nombre) {
        try {
            Statement statement = this.connect.createStatement();
            ResultSet rs = statement.executeQuery("select * from etapa where nombre='" + nombre + "'");
            if (rs.next()) {
                Etapa g = new Etapa();
                g.setIdEtapa(rs.getInt(1));
                g.setNombre(rs.getString(2));
                return g;
            } else {
                return null;
            }
        } catch (SQLException e) {
            return null;
        } 
    }

}
