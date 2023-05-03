/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Dominio.Proyecto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class DaoProyecto implements IDao<Proyecto>,IBuscarPorNombre<Proyecto>{

    private Connection connect = conexion.getInstance();

    @Override
    public Proyecto insertar(Proyecto obj) {
        try {
            String sql = "INSERT INTO Proyecto (idEncargado,idEtapa,nombre) VALUES(?,?,?)";
            PreparedStatement ps = this.connect.prepareStatement(sql);
            ps.setInt(1, obj.getEncargado().getIdUsuario());
            ps.setInt(2, obj.getEtapa().getIdEtapa());
            ps.setString(3, obj.getNombre());
            ps.execute();
        } catch (Exception e) {
            return null;
        }
        return obj;
    }

    @Override
    public void actualizar(Proyecto obj) {
        try {
            String sql = "UPDATE proyecto SET idReponsable=" + obj.getEncargado().getIdUsuario() + ", idEtapa=" + obj.getEtapa().getIdEtapa()+ ","
                    + "WHERE idProyecto=" +obj.getIdProyecto()+ ";";
            PreparedStatement statement = this.connect.prepareStatement(sql);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Proyecto buscar(int id) {
       try {
            Statement statement = this.connect.createStatement();
            ResultSet rs = statement.executeQuery("select * from proyecto where idProyecto=" + id + ";");
            if (rs.next()) {
                Proyecto g = new Proyecto();
                DaoUsuario usu = new DaoUsuario();
                DaoEtapa eta= new DaoEtapa();
                g.setIdProyecto(rs.getInt(1));
                g.setEncargado(usu.buscar(rs.getInt(2)));
                g.setEtapa(eta.buscar(rs.getInt(3)));
                g.setNombre(rs.getString(4));
                return g;
            } else {
                return null;
            }
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public void eliminar(Proyecto obj) {
       try {
            String sql = "delete from proyecto where idProyecto=" +obj.getIdProyecto()+ ";";
            PreparedStatement statement = this.connect.prepareStatement(sql);
            statement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Proyecto> listado() {
        List<Proyecto> lista = new ArrayList<>();
        try {
            String sql = "select * from proyecto";
            PreparedStatement statement = this.connect.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();           
            while(rs.next()){
                Proyecto g = new Proyecto();
                DaoUsuario usu = new DaoUsuario();
                DaoEtapa eta= new DaoEtapa();
                g.setIdProyecto(rs.getInt(1));
                g.setEncargado(usu.buscar(rs.getInt(2)));
                g.setEtapa(eta.buscar(rs.getInt(3)));
                g.setNombre(rs.getString(4));
                lista.add(g);
            }  
        }catch (Exception e){
            e.printStackTrace();
        } 
        return lista;
    }
    
    public List<Proyecto> listaProyectosPorEncargado(int id){
        List<Proyecto> listaproyectos = new ArrayList<>();
        try {
            String sql = "select * from proyecto where idEncargado="+id+"";
            PreparedStatement statement = this.connect.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            
            while(rs.next()){
                Proyecto g = new Proyecto();
                DaoUsuario usu = new DaoUsuario();
                DaoEtapa eta= new DaoEtapa();
                g.setIdProyecto(rs.getInt(1));
                g.setEncargado(usu.buscar(rs.getInt(2)));
                g.setEtapa(eta.buscar(rs.getInt(3)));
                g.setNombre(rs.getString(4));
                listaproyectos.add(g);
            }
   
        }catch (SQLException e){
            e.printStackTrace();
        } 
        return listaproyectos;
    }

    @Override
    public Proyecto buscarNombre(String nombre) {
         try {
            Statement statement = this.connect.createStatement();
            ResultSet rs = statement.executeQuery("select * from proyecto where nombre='"+nombre+"'");
            if (rs.next()) {
                Proyecto g = new Proyecto();
                DaoUsuario usu = new DaoUsuario();
                DaoEtapa eta= new DaoEtapa();
                g.setIdProyecto(rs.getInt(1));
                g.setEncargado(usu.buscar(rs.getInt(2)));
                g.setEtapa(eta.buscar(rs.getInt(3)));
                g.setNombre(rs.getString(4));
                return g;
            } else {
                return null;
            }
        } catch (SQLException e) {
            return null;
        }
    }

}
