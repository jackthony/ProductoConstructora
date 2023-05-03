package Persistencia;
public abstract class DaoFactory {
    public abstract IDao getMaterial();
    public abstract IDao getGrupo();
    public abstract IDao getUnidad();
    public abstract IDao getEtapa();
    public abstract IDao getProyecto();
    public abstract IDao getCentroCostos();
    public abstract IDao getUsuario();
    public abstract IDao getAreaNegocio();
    public abstract IDao getRequerimiento();
    public abstract IDao getItemRequerimiento();
}

