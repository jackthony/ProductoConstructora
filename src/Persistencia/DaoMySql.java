package Persistencia;
public class DaoMySql extends DaoFactory{
    @Override
    public IDao getMaterial() {
       return new DaoMaterial();
    }

    @Override
    public IDao getGrupo() {
        return new DaoGrupo();
    }


    @Override
    public IDao getEtapa() {
        return new DaoEtapa();
    }
   
    @Override
    public IDao getProyecto(){
        return new DaoProyecto();
    }
 
     @Override
    public IDao getCentroCostos() {
        return new DaoCentroCosto();
    }

    @Override
    public IDao getUnidad() {
        return new DaoUnidad();
    }

    @Override
    public IDao getUsuario() {
        return new DaoUsuario();
    }

    @Override
    public IDao getAreaNegocio() {
        return new DaoAreaNegocio();
    }

    @Override
    public IDao getRequerimiento() {
        return new DaoRequerimiento();
    }

    @Override
    public IDao getItemRequerimiento() {
        return new DaoItemRequerimiento();
    }
}
