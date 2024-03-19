package Modelo;

public class Productos {
    private int ID_PROD;
    private String NOMBRE_PROD;
    private String DESC_PROD;
    private double PREC_PROD;
    private String MODE_PROD;
    private int STOCK_PROD;
    private boolean ESTADO_PROD;
    private int ID_CLASIFICACION;
    private int ID_CATEGORIA;
    private int ID_SUBCAT;
    private int ID_MARCA;

    public Productos(int ID_PROD, String NOMBRE_PROD, String DESC_PROD, double PREC_PROD, String MODE_PROD, int STOCK_PROD, boolean ESTADO_PROD, int ID_CLASIFICACION, int ID_CATEGORIA, int ID_SUBCAT, int ID_MARCA) {
        this.ID_PROD = ID_PROD;
        this.NOMBRE_PROD = NOMBRE_PROD;
        this.DESC_PROD = DESC_PROD;
        this.PREC_PROD = PREC_PROD;
        this.MODE_PROD = MODE_PROD;
        this.STOCK_PROD = STOCK_PROD;
        this.ESTADO_PROD = ESTADO_PROD;
        this.ID_CLASIFICACION = ID_CLASIFICACION;
        this.ID_CATEGORIA = ID_CATEGORIA;
        this.ID_SUBCAT = ID_SUBCAT;
        this.ID_MARCA = ID_MARCA;
    }

    public Productos() {
    }

    public int getID_PROD() {
        return ID_PROD;
    }

    public void setID_PROD(int ID_PROD) {
        this.ID_PROD = ID_PROD;
    }

    public String getNOMBRE_PROD() {
        return NOMBRE_PROD;
    }

    public void setNOMBRE_PROD(String NOMBRE_PROD) {
        this.NOMBRE_PROD = NOMBRE_PROD;
    }

    public String getDESC_PROD() {
        return DESC_PROD;
    }

    public void setDESC_PROD(String DESC_PROD) {
        this.DESC_PROD = DESC_PROD;
    }

    public double getPREC_PROD() {
        return PREC_PROD;
    }

    public void setPREC_PROD(double PREC_PROD) {
        this.PREC_PROD = PREC_PROD;
    }

    public String getMODE_PROD() {
        return MODE_PROD;
    }

    public void setMODE_PROD(String MODE_PROD) {
        this.MODE_PROD = MODE_PROD;
    }

    public int getSTOCK_PROD() {
        return STOCK_PROD;
    }

    public void setSTOCK_PROD(int STOCK_PROD) {
        this.STOCK_PROD = STOCK_PROD;
    }

    public boolean isESTADO_PROD() {
        return ESTADO_PROD;
    }

    public void setESTADO_PROD(boolean ESTADO_PROD) {
        this.ESTADO_PROD = ESTADO_PROD;
    }

    public int getID_CLASIFICACION() {
        return ID_CLASIFICACION;
    }

    public void setID_CLASIFICACION(int ID_CLASIFICACION) {
        this.ID_CLASIFICACION = ID_CLASIFICACION;
    }

    public int getID_CATEGORIA() {
        return ID_CATEGORIA;
    }

    public void setID_CATEGORIA(int ID_CATEGORIA) {
        this.ID_CATEGORIA = ID_CATEGORIA;
    }

    public int getID_SUBCAT() {
        return ID_SUBCAT;
    }

    public void setID_SUBCAT(int ID_SUBCAT) {
        this.ID_SUBCAT = ID_SUBCAT;
    }

    public int getID_MARCA() {
        return ID_MARCA;
    }

    public void setID_MARCA(int ID_MARCA) {
        this.ID_MARCA = ID_MARCA;
    }
}
//
