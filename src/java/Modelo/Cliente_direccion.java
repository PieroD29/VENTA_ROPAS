package Modelo;

public class Cliente_direccion {

    private int ID_CLIENTE_DIRECCION;
    private int ID_CLIENTE;
    private int ID_DIRECCION;
    private String NOMBRE_CLIENTE;
    private String CALLE;

    public Cliente_direccion(int ID_CLIENTE_DIRECCION, int ID_CLIENTE, int ID_DIRECCION) {
        this.ID_CLIENTE_DIRECCION = ID_CLIENTE_DIRECCION;
        this.ID_CLIENTE = ID_CLIENTE;
        this.ID_DIRECCION = ID_DIRECCION;

    }

    public Cliente_direccion() {
    }

    public int getID_CLIENTE_DIRECCION() {
        return ID_CLIENTE_DIRECCION;
    }

    public void setID_CLIENTE_DIRECCION(int ID_CLIENTE_DIRECCION) {
        this.ID_CLIENTE_DIRECCION = ID_CLIENTE_DIRECCION;
    }

    public int getID_CLIENTE() {
        return ID_CLIENTE;
    }

    public void setID_CLIENTE(int ID_CLIENTE) {
        this.ID_CLIENTE = ID_CLIENTE;
    }

    public int getID_DIRECCION() {
        return ID_DIRECCION;
    }

    public void setID_DIRECCION(int ID_DIRECCION) {
        this.ID_DIRECCION = ID_DIRECCION;
    }

    public String getNOMBRE_CLIENTE() {
        return NOMBRE_CLIENTE;
    }

    public void setNOMBRE_CLIENTE(String NOMBRE_CLIENTE) {
        this.NOMBRE_CLIENTE = NOMBRE_CLIENTE;
    }

    public String getCALLE() {
        return CALLE;
    }

    public void setCALLE(String CALLE) {
        this.CALLE = CALLE;
    }

}
