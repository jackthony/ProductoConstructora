
package Persistencia;

import Dominio.Rol;
import Dominio.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DaoUsuario implements IDao<Usuario>, IObtenerUsuario<Usuario>, IBuscarPorRol<Usuario>, IBuscarPorNombre<Usuario> {

    private Connection connect = conexion.getInstance();

    @Override
    public Usuario insertar(Usuario obj) {
        try {
            String sql = "INSERT INTO usuario (nombre,apellido,username,pass,rol) VALUES(?,?,?,?,?)";
            PreparedStatement ps = this.connect.prepareStatement(sql);
            ps.setString(1, obj.getNombre());
            ps.setString(2, obj.getApellido());
            ps.setString(3, obj.getUsername());
            ps.setString(4, obj.getPassword());
            ps.setString(5, obj.getRol().name());
            ps.execute();
        } catch (Exception e) {
            return null;
        }
        return obj;
    }

    @Override
    public void actualizar(Usuario obj) {
        try {
            String sql = "UPDATE Usuario SET nombre='" + obj.getNombre() + "',apellido='" + obj.getApellido() + "'username='" + obj.getUsername() + "',pass='" 
                    + obj.getPassword() + "',rol='" + obj.getRol().name() + "' WHERE idUsuario=" + obj.getIdUsuario() + ";";
            PreparedStatement statement = this.connect.prepareStatement(sql);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Usuario buscar(int id) {
        try {
            Statement statement = this.connect.createStatement();
            ResultSet rs = statement.executeQuery("select * from Usuario where idUsuario=" + id + ";");
            if (rs.next()) {
                Usuario g = new Usuario();
                g.setIdUsuario(rs.getInt(1));
                g.setNombre(rs.getString(2));
                g.setApellido(rs.getString(3));
                g.setUsername(rs.getString(4));
                g.setPassword(rs.getString(5));
                g.setRol(Rol.valueOf(rs.getString(6)));
                return g;
            } else {
                return null;
            }
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public void eliminar(Usuario obj) {
        try {
            String sql = "delete from Usuario where idUsuario=" + obj.getIdUsuario() + ";";
            PreparedStatement statement = this.connect.prepareStatement(sql);
            statement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Usuario> listado() {
        List<Usuario> lista = new ArrayList<>();
        try {
            String sql = "select * from Usuario";
            PreparedStatement statement = this.connect.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Usuario g = new Usuario();
                g.setIdUsuario(rs.getInt(1));
                g.setNombre(rs.getString(2));
                g.setApellido(rs.getString(3));
                g.setUsername(rs.getString(4));
                g.setPassword(rs.getString(5));
                g.setRol(Rol.valueOf(rs.getString(6)));
                lista.add(g);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public Usuario obtenerUsuario(String username, String password) {
        Usuario g = new Usuario();
        try {
            String sql = "select * from Usuario where username='" + username + "' and pass='" + password + "'";
            PreparedStatement statement = this.connect.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                g.setIdUsuario(rs.getInt(1));
                g.setNombre(rs.getString(2));
                g.setApellido(rs.getString(3));
                g.setUsername(rs.getString(4));
                g.setPassword(rs.getString(5));
                g.setRol(Rol.valueOf(rs.getString(6)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return g;
    }

    @Override
    public List<Usuario> buscarResponsable() {
        List<Usuario> lista = new ArrayList<>();
        try {
            String sql = "select * from Usuario where rol='RESPONSABLE'";
            PreparedStatement statement = this.connect.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Usuario g = new Usuario();
                g.setIdUsuario(rs.getInt(1));
                g.setNombre(rs.getString(2));
                g.setApellido(rs.getString(3));
                g.setUsername(rs.getString(4));
                g.setPassword(rs.getString(5));
                g.setRol(Rol.valueOf(rs.getString(6)));
                lista.add(g);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public List<Usuario> buscarEncargado() {
        List<Usuario> lista = new ArrayList<>();
        try {
            String sql = "select * from Usuario where rol='ENCARGADO'";
            PreparedStatement statement = this.connect.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Usuario g = new Usuario();
                g.setIdUsuario(rs.getInt(1));
                g.setNombre(rs.getString(2));
                g.setApellido(rs.getString(3));
                g.setUsername(rs.getString(4));
                g.setPassword(rs.getString(5));
                g.setRol(Rol.valueOf(rs.getString(6)));
                lista.add(g);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public Usuario buscarNombre(String nombre) {
        try {
            Statement statement = this.connect.createStatement();
            ResultSet rs = statement.executeQuery("select * from Usuario where nombre='" + nombre + "'");
            if (rs.next()) {
                Usuario g = new Usuario();
                g.setIdUsuario(rs.getInt(1));
                g.setNombre(rs.getString(2));
                g.setApellido(rs.getString(3));
                g.setUsername(rs.getString(4));
                g.setPassword(rs.getString(5));
                g.setRol(Rol.valueOf(rs.getString(6)));
                return g;
            } else {
                return null;
            }
        } catch (SQLException e) {
            return null;
        }
    }

}
