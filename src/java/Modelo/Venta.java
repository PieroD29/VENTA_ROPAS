package Modelo;

public class Venta {

    private int NRO_BOLETA;
    private int ID_CLIENTE;
    private int ID_VENDEDOR;
    private String NUMERO_SERIE;
    private String FECHA_EMISION;
    private double MONTO_TOTAL;
    private String ESTADO;

    public Venta(int NRO_BOLETA, int ID_CLIENTE, int ID_VENDEDOR, String NUMERO_SERIE, String FECHA_EMISION, double MONTO_TOTAL, String ESTADO) {
        this.NRO_BOLETA = NRO_BOLETA;
        this.ID_CLIENTE = ID_CLIENTE;
        this.ID_VENDEDOR = ID_VENDEDOR;
        this.NUMERO_SERIE = NUMERO_SERIE;
        this.FECHA_EMISION = FECHA_EMISION;
        this.MONTO_TOTAL = MONTO_TOTAL;
        this.ESTADO = ESTADO;
    }

    public Venta() {

    }

    public int getNRO_BOLETA() {
        return NRO_BOLETA;
    }

    public void setNRO_BOLETA(int NRO_BOLETA) {
        this.NRO_BOLETA = NRO_BOLETA;
    }

    public int getID_CLIENTE() {
        return ID_CLIENTE;
    }

    public void setID_CLIENTE(int ID_CLIENTE) {
        this.ID_CLIENTE = ID_CLIENTE;
    }

    public int getID_VENDEDOR() {
        return ID_VENDEDOR;
    }

    public void setID_VENDEDOR(int ID_VENDEDOR) {
        this.ID_VENDEDOR = ID_VENDEDOR;
    }

    public String getNUMERO_SERIE() {
        return NUMERO_SERIE;
    }

    public void setNUMERO_SERIE(String NUMERO_SERIE) {
        this.NUMERO_SERIE = NUMERO_SERIE;
    }

    public String getFECHA_EMISION() {
        return FECHA_EMISION;
    }

    public void setFECHA_EMISION(String FECHA_EMISION) {
        this.FECHA_EMISION = FECHA_EMISION;
    }

    public double getMONTO_TOTAL() {
        return MONTO_TOTAL;
    }

    public void setMONTO_TOTAL(double MONTO_TOTAL) {
        this.MONTO_TOTAL = MONTO_TOTAL;
    }

    public String getESTADO() {
        return ESTADO;
    }

    public void setESTADO(String ESTADO) {
        this.ESTADO = ESTADO;
    }

}
