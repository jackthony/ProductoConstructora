package Persistencia;


import Dominio.Grupo;
import Dominio.Material;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DaoMaterial implements IDao<Material>, IBuscarPorNombre<Material> {

    private Connection connect = conexion.getInstance();

    @Override
    public Material insertar(Material m) {
        try {
            String sql = "INSERT INTO material (nombre,idUnidad,idgrupo) VALUES(?,?,?)";
            PreparedStatement ps = this.connect.prepareStatement(sql);
            ps.setString(1, m.getNombre());
            ps.setInt(2, m.getUnidad().getIdUnidad());
            ps.setInt(3, m.getGrupo().getIdGrupo());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return m;
    }

    @Override
    public void actualizar(Material m) {
        try {
            String sql = "UPDATE material SET nombre=" + m.getNombre() + ", idUnidad=" + m.getUnidad().getIdUnidad() + ","
                    + "idgrupo=" + m.getGrupo().getIdGrupo() + " WHERE idmaterial=" + m.getIdMaterial() + ";";
            PreparedStatement statement = this.connect.prepareStatement(sql);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Material buscar(int id) {
        try {
            Statement statement = this.connect.createStatement();
            ResultSet rs = statement.executeQuery("select * from material where idmaterial=" + id + ";");
            if (rs.next()) {
                Material m = new Material();
                m.setIdMaterial(rs.getInt(1));
                m.setNombre(rs.getString(2));
                DaoUnidad daou= new DaoUnidad();
                m.setUnidad(daou.buscar(rs.getInt(3)));
                DaoGrupo daog= new DaoGrupo();
                m.setGrupo(daog.buscar(rs.getInt(4)));  
                return m;
            } else {
                return null;
            }
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public void eliminar(Material m) {
        try {
            String sql = "delete from material where idmaterial=" + m.getIdMaterial() + ";";
            PreparedStatement statement = this.connect.prepareStatement(sql);
            statement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Material> listado() {
        List<Material> listaMaterial = new ArrayList<>();
        try {
            String sql = "select*from material";

            PreparedStatement statement = this.connect.prepareStatement(sql);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Material m = new Material();
                m.setIdMaterial(rs.getInt(1));
                m.setNombre(rs.getString(2));
                DaoUnidad daou= new DaoUnidad();
                m.setUnidad(daou.buscar(rs.getInt(3)));
                DaoGrupo daog= new DaoGrupo();
                m.setGrupo(daog.buscar(rs.getInt(4)));  
                listaMaterial.add(m);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaMaterial;
    }

    @Override
    public Material buscarNombre(String nombre) {
         try {
            Statement statement = this.connect.createStatement();
            ResultSet rs = statement.executeQuery("select * from material where nombre='"+nombre+"'");
            if (rs.next()) {
                Material m = new Material();
                m.setIdMaterial(rs.getInt(1));
                m.setNombre(rs.getString(2));
                DaoUnidad daou= new DaoUnidad();
                m.setUnidad(daou.buscar(rs.getInt(3)));
                DaoGrupo daog= new DaoGrupo();
                m.setGrupo(daog.buscar(rs.getInt(4)));  
                return m;
            } else {
                return null;
            }
        } catch (SQLException e) {
            return null;
        }
    }

}
