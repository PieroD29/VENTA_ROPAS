package Modelo;

public class Proveedor {

    private int ID_PROVEEDOR;
    private String NOM_PROVEEDOR;
    private String RUC;
    private String ESTADO_PROVEEDOR;

    public Proveedor(int ID_PROVEEDOR, String NOM_PROVEEDOR, String RUC, String ESTADO_PROVEEDOR) {
        this.ID_PROVEEDOR = ID_PROVEEDOR;
        this.NOM_PROVEEDOR = NOM_PROVEEDOR;
        this.RUC = RUC;
        this.ESTADO_PROVEEDOR = ESTADO_PROVEEDOR;
    }

    public Proveedor() {
    }

    public int getID_PROVEEDOR() {
        return ID_PROVEEDOR;
    }

    public void setID_PROVEEDOR(int ID_PROVEEDOR) {
        this.ID_PROVEEDOR = ID_PROVEEDOR;
    }

    public String getNOM_PROVEEDOR() {
        return NOM_PROVEEDOR;
    }

    public void setNOM_PROVEEDOR(String NOM_PROVEEDOR) {
        this.NOM_PROVEEDOR = NOM_PROVEEDOR;
    }

    public String getRUC() {
        return RUC;
    }

    public void setRUC(String RUC) {
        this.RUC = RUC;
    }

    public String getESTADO_PROVEEDOR() {
        return ESTADO_PROVEEDOR;
    }

    public void setESTADO_PROVEEDOR(String ESTADO_PROVEEDOR) {
        this.ESTADO_PROVEEDOR = ESTADO_PROVEEDOR;
    }

    
}
