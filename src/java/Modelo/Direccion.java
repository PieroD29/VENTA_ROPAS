package Modelo;

public class Direccion {

    private int ID_DIRECCION;
    private String CALLE;
    private String DISTRITO;
    private String CIUDAD;

    public Direccion(int ID_DIRECCION, String CALLE, String DISTRITO, String CIUDAD) {
        this.ID_DIRECCION = ID_DIRECCION;
        this.CALLE = CALLE;
        this.DISTRITO = DISTRITO;
        this.CIUDAD = CIUDAD;
    }

    public Direccion() {
    }

    public int getID_DIRECCION() {
        return ID_DIRECCION;
    }

    public void setID_DIRECCION(int ID_DIRECCION) {
        this.ID_DIRECCION = ID_DIRECCION;
    }

    public String getCALLE() {
        return CALLE;
    }

    public void setCALLE(String CALLE) {
        this.CALLE = CALLE;
    }

    public String getDISTRITO() {
        return DISTRITO;
    }

    public void setDISTRITO(String DISTRITO) {
        this.DISTRITO = DISTRITO;
    }

    public String getCIUDAD() {
        return CIUDAD;
    }

    public void setCIUDAD(String CIUDAD) {
        this.CIUDAD = CIUDAD;
    }
    
}
