
package Persistencia;

import java.util.List;

public interface IDao<G> {
    G insertar(G obj);
    void actualizar(G obj);
    G buscar(int id);
    void eliminar(G obj);       
    List<G> listado();
}
