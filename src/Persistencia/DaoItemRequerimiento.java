/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Dominio.CentroCostos;
import Dominio.Grupo;
import Dominio.ItemRequerimiento;
import Dominio.Material;
import Dominio.Proyecto;
import Dominio.Requerimiento;
import Dominio.Usuario;
import com.sun.org.apache.bcel.internal.generic.D2F;
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
public class DaoItemRequerimiento implements IDao<ItemRequerimiento>,IListaPorId<ItemRequerimiento>{
    
    private Connection connect = conexion.getInstance();    
    
    @Override
    public ItemRequerimiento insertar(ItemRequerimiento obj) {
         try {
            String sql = "INSERT INTO itemRequerimiento (idRequerimiento,idMaterial,cantidad,observaciones) VALUES(?,?,?,?)";
            PreparedStatement ps = this.connect.prepareStatement(sql);
            ps.setInt(1,obj.getRequerimiento().getIdRequerimiento());
            ps.setInt(2, obj.getMaterial().getIdMaterial());
            ps.setInt(3, obj.getCantidad());
            ps.setString(4,obj.getObervaciones());
            ps.execute();
        } catch (SQLException e) {
            return null;
        }
        return obj;
    }

    @Override
    public void actualizar(ItemRequerimiento obj) {
        try {
            String sql = "UPDATE itemRequerimiento SET idRequerimiento=" +obj.getRequerimiento().getIdRequerimiento()+ ", idMaterial=" +obj.getMaterial().getIdMaterial()+ ","
                    + "cantidad=" + obj.getCantidad() + ",observaciones='"+obj.getObervaciones()+"' WHERE idRequerimiento=" +obj.getRequerimiento().getIdRequerimiento()+ "and idMaterial="+obj.getMaterial().getIdMaterial();
            PreparedStatement statement = this.connect.prepareStatement(sql);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ItemRequerimiento buscar(int id) {
        try {
            Statement statement = this.connect.createStatement();
            ResultSet rs = statement.executeQuery("select * from itemRequerimiento where idRequerimiento=" + id + ";");
            if (rs.next()) {
                ItemRequerimiento ite= new ItemRequerimiento();
                DaoRequerimiento req= new DaoRequerimiento();
                DaoMaterial mat= new DaoMaterial();
                ite.setRequerimiento(req.buscar(rs.getInt(1)));
                ite.setMaterial(mat.buscar(rs.getInt(2)));
                ite.setCantidad(rs.getInt(3));
                ite.setObervaciones(rs.getString(4));
                return ite;
            } else {
                return null;
            }
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public void eliminar(ItemRequerimiento obj) {
        try {
            String sql = "delete from itemRequerimiento where idRequerimiento=" +obj.getRequerimiento().getIdRequerimiento()+ "and idMaterial="+obj.getMaterial().getIdMaterial();
            PreparedStatement statement = this.connect.prepareStatement(sql);
            statement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<ItemRequerimiento> listado() {
        List<ItemRequerimiento> lista = new ArrayList<>();
        try {
            String sql = "select*from itemRequerimiento";

            PreparedStatement statement = this.connect.prepareStatement(sql);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                ItemRequerimiento ite= new ItemRequerimiento();
                DaoRequerimiento req= new DaoRequerimiento();
                DaoMaterial mat= new DaoMaterial();
                ite.setRequerimiento(req.buscar(rs.getInt(1)));
                ite.setMaterial(mat.buscar(rs.getInt(2)));
                ite.setCantidad(rs.getInt(3));
                ite.setObervaciones(rs.getString(4));
                lista.add(ite);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public List<ItemRequerimiento> ListaBuscarId(int id) {
        List<ItemRequerimiento> lista = new ArrayList<>();
        try {
            String sql = "select m.idGrupo,i.idMaterial,m.idUnidad,i.cantidad,i.observaciones from itemRequerimiento as i\n"
                    + "inner join  material as m\n"
                    + "on i.idMaterial=m.idMaterial where i.idRequerimiento="+id+";";;

            PreparedStatement statement = this.connect.prepareStatement(sql);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                
                ItemRequerimiento ite= new ItemRequerimiento();
                DaoGrupo gru= new DaoGrupo();
                DaoUnidad uni= new DaoUnidad();
                DaoRequerimiento req= new DaoRequerimiento();
                DaoMaterial mat= new DaoMaterial();
                Material mate= new Material();
                mate.setGrupo(gru.buscar(rs.getInt(1)));
                mate.setUnidad(uni.buscar(rs.getInt(3)));
                ite.setMaterial(mat.buscar(rs.getInt(2)));
                ite.setCantidad(rs.getInt(4));
                ite.setObervaciones(rs.getString(5));
                lista.add(ite);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }


    
    }


