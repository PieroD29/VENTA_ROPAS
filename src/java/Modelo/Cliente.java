package Modelo;

public class Cliente {

    private int ID_CLIENTE;
    private String NOMBRE_CLIENTE;
    private String DNI;
    private int RECORD_COMPRA;
    private String FECHA_NACIMIENTO;
    private String ESTADO_CLIENTE;

    public Cliente(int ID_CLIENTE, String NOMBRE_CLIENTE, String DNI, int RECORD_COMPRA, String FECHA_NACIMIENTO, String ESTADO_CLIENTE) {
        this.ID_CLIENTE = ID_CLIENTE;
        this.NOMBRE_CLIENTE = NOMBRE_CLIENTE;
        this.DNI = DNI;
        this.RECORD_COMPRA = RECORD_COMPRA;
        this.FECHA_NACIMIENTO = FECHA_NACIMIENTO;
        this.ESTADO_CLIENTE = ESTADO_CLIENTE;
    }

    public Cliente() {
    }


    public int getID_CLIENTE() {
        return ID_CLIENTE;
    }

    public void setID_CLIENTE(int ID_CLIENTE) {
        this.ID_CLIENTE = ID_CLIENTE;
    }

    public String getNOMBRE_CLIENTE() {
        return NOMBRE_CLIENTE;
    }

    public void setNOMBRE_CLIENTE(String NOMBRE_CLIENTE) {
        this.NOMBRE_CLIENTE = NOMBRE_CLIENTE;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public int getRECORD_COMPRA() {
        return RECORD_COMPRA;
    }

    public void setRECORD_COMPRA(int RECORD_COMPRA) {
        this.RECORD_COMPRA = RECORD_COMPRA;
    }

    public String getFECHA_NACIMIENTO() {
        return FECHA_NACIMIENTO;
    }

    public void setFECHA_NACIMIENTO(String FECHA_NACIMIENTO) {
        this.FECHA_NACIMIENTO = FECHA_NACIMIENTO;
    }

    public String getESTADO_CLIENTE() {
        return ESTADO_CLIENTE;
    }

    public void setESTADO_CLIENTE(String ESTADO_CLIENTE) {
        this.ESTADO_CLIENTE = ESTADO_CLIENTE;
    }

}
