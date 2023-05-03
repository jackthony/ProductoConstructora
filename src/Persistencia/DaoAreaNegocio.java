/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Dominio.AreaNegocio;
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
public class DaoAreaNegocio implements IDao<AreaNegocio> {

    private Connection connect = conexion.getInstance();

    @Override
    public AreaNegocio insertar(AreaNegocio obj) {
        try {
            String sql = "INSERT INTO AreaNegocio (prefijo,nombre,idResponsable) VALUES(?,?,?)";
            PreparedStatement ps = this.connect.prepareStatement(sql);
            ps.setString(1, obj.getPrefijo());
            ps.setString(2, obj.getNombre());
            ps.setInt(3, obj.getResponsable().getIdUsuario());
            ps.execute();
        } catch (Exception e) {
            return null;
        }
        return obj;
    }

    @Override
    public void actualizar(AreaNegocio obj) {
        try {
            String sql = "UPDATE AreaNegocio SET prefijo='" + obj.getPrefijo() + "', nombre='" + obj.getPrefijo() + "',idResponsable=" + obj.getResponsable().getIdUsuario() + " WHERE idArea=" + obj.getIdArea() + ";";
            PreparedStatement statement = this.connect.prepareStatement(sql);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public AreaNegocio buscar(int id) {
        try {
            Statement statement = this.connect.createStatement();
            ResultSet rs = statement.executeQuery("select * from AreaNegocio where idArea=" + id + ";");
            if (rs.next()) {
                AreaNegocio g = new AreaNegocio();
                g.setIdArea(rs.getInt(1));
                g.setPrefijo(rs.getString(2));
                g.setNombre(rs.getString(3));
                DaoUsuario usu = new DaoUsuario();
                g.setResponsable(usu.buscar(rs.getInt(4)));
                return g;
            } else {
                return null;
            }
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public void eliminar(AreaNegocio obj) {
        try {
            String sql = "delete from AreaNegocio where idArea=" + obj.getIdArea() + ";";
            PreparedStatement statement = this.connect.prepareStatement(sql);
            statement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<AreaNegocio> listado() {
        List<AreaNegocio> lista = new ArrayList<>();
        try {
            Statement statement = this.connect.createStatement();
            ResultSet rs = statement.executeQuery("select * from AreaNegocio");
            while (rs.next()) {
                AreaNegocio g = new AreaNegocio();
                g.setIdArea(rs.getInt(1));
                g.setPrefijo(rs.getString(2));
                g.setNombre(rs.getString(3));
                DaoUsuario usu = new DaoUsuario();
                g.setResponsable(usu.buscar(rs.getInt(4)));
                lista.add(g);
            }
        } catch (SQLException e) {
            return null;
        }
        return lista;
    }


}
