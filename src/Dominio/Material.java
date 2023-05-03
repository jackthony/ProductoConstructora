
package Dominio;
public class Material {
    private int idMaterial;
    private String nombre;
    private Unidad unidad;
    private Grupo grupo;

    public Material() {
    }

    public Material(int idMaterial, String nombre, Unidad unidad, Grupo idgrupo) {
        this.idMaterial = idMaterial;
        this.nombre = nombre;
        this.unidad = unidad;
        this.grupo = idgrupo;
    }

    public int getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(int idMaterial) {
        this.idMaterial = idMaterial;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Unidad getUnidad() {
        return unidad;
    }

    public void setUnidad(Unidad unidad) {
        this.unidad = unidad;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }


    
    
    
}
