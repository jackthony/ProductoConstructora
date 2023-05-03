/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Dominio.EstadoRequerimiento;
import Dominio.Requerimiento;
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
public class DaoRequerimiento implements IDao<Requerimiento>{
    
    private Connection connect = conexion.getInstance();

    @Override
    public Requerimiento insertar(Requerimiento obj) {
        try {
            String sql = "INSERT INTO requerimiento (idEncargado,idCentro,idProyecto,idResponsable,fecha,estado) VALUES(?,?,?,?,?,?)";
            PreparedStatement ps = this.connect.prepareStatement(sql);
            ps.setInt(1, obj.getEncargado().getIdUsuario());
            ps.setInt(2, obj.getCentrocostos().getIdCentroCostos());
            ps.setInt(3, obj.getProyecto().getIdProyecto());
            ps.setInt(4, obj.getResponsable().getIdUsuario());
            ps.setDate(5, obj.getFecha());
            ps.setString(6, obj.getEstado().name());
            ps.execute();
        } catch (Exception e) {
            return null;
        }
        return obj;
    }

    @Override
    public void actualizar(Requerimiento obj) {
         try {
            String sql = "UPDATE requerimiento SET idEncargado=" + obj.getEncargado().getIdUsuario() + ", idCentro=" + obj.getCentrocostos().getIdCentroCostos()+ ","
                    + "idProyecto="+obj.getProyecto().getIdProyecto()+",idResponsable="+obj.getResponsable().getIdUsuario()+", fecha="+obj.getFecha()+", estado="+obj.getEstado().name()+"WHERE idRequerimiento=" +obj.getIdRequerimiento()+ ";";
            PreparedStatement statement = this.connect.prepareStatement(sql);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Requerimiento buscar(int id) {
        try {
            Statement statement = this.connect.createStatement();
            ResultSet rs = statement.executeQuery("select * from requerimiento where idRequerimiento=" + id + ";");
            if (rs.next()) {
                Requerimiento g = new Requerimiento();
                DaoUsuario usu = new DaoUsuario();
                DaoCentroCosto cen= new DaoCentroCosto();
                DaoEtapa eta= new DaoEtapa();
                DaoProyecto proy= new DaoProyecto();
                g.setIdRequerimiento(rs.getInt(1));
                g.setEncargado(usu.buscar(rs.getInt(2)));
                g.setCentrocostos(cen.buscar(rs.getInt(3)));
                g.setProyecto(proy.buscar(rs.getInt(4)));
                g.setResponsable(usu.buscar(rs.getInt(5)));
                g.setFecha(rs.getDate(6));
                g.setEstado(EstadoRequerimiento.valueOf(rs.getString(7)));
                return g;
            } else {
                return null;
            }
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public void eliminar(Requerimiento obj) {
        try {
            String sql = "delete from requerimiento where idRequerimiento=" +obj.getIdRequerimiento()+ ";";
            PreparedStatement statement = this.connect.prepareStatement(sql);
            statement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Requerimiento> listado() {
        List<Requerimiento> lista = new ArrayList<>();
        try {
            String sql = "select * from requerimiento";
            PreparedStatement statement = this.connect.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();           
            while(rs.next()){
                Requerimiento g = new Requerimiento();
                DaoUsuario usu = new DaoUsuario();
                DaoCentroCosto cen= new DaoCentroCosto();
                DaoEtapa eta= new DaoEtapa();
                DaoProyecto proy= new DaoProyecto();
                g.setIdRequerimiento(rs.getInt(1));
                g.setEncargado(usu.buscar(rs.getInt(2)));
                g.setCentrocostos(cen.buscar(rs.getInt(3)));
                g.setProyecto(proy.buscar(rs.getInt(4)));
                g.setResponsable(usu.buscar(rs.getInt(5)));
                g.setFecha(rs.getDate(6));
                g.setEstado(EstadoRequerimiento.valueOf(rs.getString(7)));
                lista.add(g);
            }  
        }catch (Exception e){
            e.printStackTrace();
        } 
        return lista;
    }
    public List<Requerimiento> listaRequerimientoResponsable(int id){
        List<Requerimiento> lista = new ArrayList<>();
        try {
            String sql = "select * from requerimiento where idResponsable="+id;
            PreparedStatement statement = this.connect.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();           
            while(rs. next()){
                Requerimiento g = new Requerimiento();
                DaoUsuario usu = new DaoUsuario();
                DaoCentroCosto cen= new DaoCentroCosto();
                DaoEtapa eta= new DaoEtapa();
                DaoProyecto proy= new DaoProyecto();
                g.setIdRequerimiento(rs.getInt(1));
                g.setEncargado(usu.buscar(rs.getInt(2)));
                g.setCentrocostos(cen.buscar(rs.getInt(3)));
                g.setProyecto(proy.buscar(rs.getInt(4)));
                g.setResponsable(usu.buscar(rs.getInt(5)));
                g.setFecha(rs.getDate(6));
                g.setEstado(EstadoRequerimiento.valueOf(rs.getString(7)));
                lista.add(g);
            }  
        }catch (Exception e){
            e.printStackTrace();
        } 
        return lista;
    }
    
    public void actualizarRequerimiento(String estado, int id){
        try {
            String sql = "UPDATE requerimiento SET estado=? where idRequerimiento=?";
            PreparedStatement statement = this.connect.prepareStatement(sql);
            statement.setString(1, estado);
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
