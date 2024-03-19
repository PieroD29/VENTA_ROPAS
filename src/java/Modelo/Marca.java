package Modelo;

public class Marca {
    private int ID_MARCA;
    private String NOMBRE_MARCA;
    private boolean ESTADO_MARCA;

    public Marca(int ID_MARCA, String NOMBRE_MARCA, boolean ESTADO_MARCA) {
        this.ID_MARCA = ID_MARCA;
        this.NOMBRE_MARCA = NOMBRE_MARCA;
        this.ESTADO_MARCA = ESTADO_MARCA;
    }

    public Marca() {
    }

    public int getID_MARCA() {
        return ID_MARCA;
    }

    public void setID_MARCA(int ID_MARCA) {
        this.ID_MARCA = ID_MARCA;
    }

    public String getNOMBRE_MARCA() {
        return NOMBRE_MARCA;
    }

    public void setNOMBRE_MARCA(String NOMBRE_MARCA) {
        this.NOMBRE_MARCA = NOMBRE_MARCA;
    }

    public boolean isESTADO_MARCA() {
        return ESTADO_MARCA;
    }

    public void setESTADO_MARCA(boolean ESTADO_MARCA) {
        this.ESTADO_MARCA = ESTADO_MARCA;
    }
    
    
}
