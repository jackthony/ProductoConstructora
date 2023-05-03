/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Dominio.CentroCostos;
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
public class DaoCentroCosto implements IDao<CentroCostos>,IBuscarPorNombre<CentroCostos>{
    private Connection connect = conexion.getInstance();
    @Override
    public CentroCostos insertar(CentroCostos obj) {
        
        try{
            String sql = "INSERT INTO CentroCostos (nombre) VALUES(?)";
            PreparedStatement ps = this.connect.prepareStatement(sql);
            ps.setString(1,obj.getTipo());
            ps.execute();  
        }catch (Exception e){
          return null;
        }
        return obj;
    }

    @Override
    public void actualizar(CentroCostos obj) {
         try{
            String sql = "UPDATE CentroCostos SET nombre='"+obj.getTipo()+"' WHERE idCentro="+obj.getIdCentroCostos()+";";
            PreparedStatement statement = this.connect.prepareStatement(sql);
            statement.executeUpdate();
        }catch (Exception e){
          e.printStackTrace();
        } 
    }

    @Override
    public CentroCostos buscar(int id) {
        try{
            Statement statement=this.connect.createStatement();
            ResultSet rs = statement.executeQuery("select * from CentroCostos where idCentro="+id+";");           
            if(rs.next()){
                CentroCostos g = new CentroCostos();
                g.setIdCentroCostos(rs.getInt(1));
                g.setTipo(rs.getString(2));
                return g;
            }else{
                return null;
            }         
        }catch(SQLException e){
            return null;
        } 
    }

    @Override
    public void eliminar(CentroCostos obj) {
         try{
            String sql = "delete from CentroCostos where idCentro="+obj.getIdCentroCostos()+";";
            PreparedStatement statement = this.connect.prepareStatement(sql);
            statement.execute();
        }catch (Exception e){
          e.printStackTrace();
        } 
    }

    @Override
    public List<CentroCostos> listado() {
        List<CentroCostos> lista= new ArrayList<>();
         try {
            String sql = "select * from CentroCostos";
            PreparedStatement statement = this.connect.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();           
            while(rs.next()){
                CentroCostos g = new CentroCostos();
                g.setIdCentroCostos(rs.getInt(1));
                g.setTipo(rs.getString(2));
                lista.add(g);
            }  
        }catch (Exception e){
            e.printStackTrace();
        } 
        return lista;
    }

    

    @Override
    public CentroCostos buscarNombre(String nombre) {
        try{
            Statement statement=this.connect.createStatement();
            ResultSet rs = statement.executeQuery("select * from CentroCostos where nombre='"+nombre+"'");           
            if(rs.next()){
                CentroCostos g = new CentroCostos();
                g.setIdCentroCostos(rs.getInt(1));
                g.setTipo(rs.getString(2));
                return g;
            }else{
                return null;
            }         
        }catch(SQLException e){
            return null;
        } 
    }
    
}
