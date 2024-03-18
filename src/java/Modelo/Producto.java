package Modelo;

public class Producto {

    private int COD_PRODUCTO;
    private String NOMBRE_PRODUCTO;
    private String DESCRIPCION;
    private double PRECIO_UNITARIO;
    private int STOCK;
    private boolean ESTADO;
    private int ID_PROVEEDOR;
    private int ID_CATEGORIA;
    private String NOMBRE_CATEGORIA;
    private String NOM_PROVEEDOR;

    public Producto(int COD_PRODUCTO, String NOMBRE_PRODUCTO, String DESCRIPCION, double PRECIO_UNITARIO, int STOCK, boolean ESTADO, int ID_PROVEEDOR, int ID_CATEGORIA) {
        this.COD_PRODUCTO = COD_PRODUCTO;
        this.NOMBRE_PRODUCTO = NOMBRE_PRODUCTO;
        this.DESCRIPCION = DESCRIPCION;
        this.PRECIO_UNITARIO = PRECIO_UNITARIO;
        this.STOCK = STOCK;
        this.ESTADO = ESTADO;

    }

    public Producto() {

    }

    public int getCOD_PRODUCTO() {
        return COD_PRODUCTO;
    }

    public void setCOD_PRODUCTO(int COD_PRODUCTO) {
        this.COD_PRODUCTO = COD_PRODUCTO;
    }

    public String getNOMBRE_PRODUCTO() {
        return NOMBRE_PRODUCTO;
    }

    public void setNOMBRE_PRODUCTO(String NOMBRE_PRODUCTO) {
        this.NOMBRE_PRODUCTO = NOMBRE_PRODUCTO;
    }

    public String getDESCRIPCION() {
        return DESCRIPCION;
    }

    public void setDESCRIPCION(String DESCRIPCION) {
        this.DESCRIPCION = DESCRIPCION;
    }

    public double getPRECIO_UNITARIO() {
        return PRECIO_UNITARIO;
    }

    public void setPRECIO_UNITARIO(double PRECIO_UNITARIO) {
        this.PRECIO_UNITARIO = PRECIO_UNITARIO;
    }

    public int getSTOCK() {
        return STOCK;
    }

    public void setSTOCK(int STOCK) {
        this.STOCK = STOCK;
    }

    public boolean isESTADO() {
        return ESTADO;
    }

    public void setESTADO(boolean ESTADO) {
        this.ESTADO = ESTADO;
    }

    public int getID_PROVEEDOR() {
        return ID_PROVEEDOR;
    }

    public void setID_PROVEEDOR(int ID_PROVEEDOR) {
        this.ID_PROVEEDOR = ID_PROVEEDOR;
    }

    public int getID_CATEGORIA() {
        return ID_CATEGORIA;
    }

    public void setID_CATEGORIA(int ID_CATEGORIA) {
        this.ID_CATEGORIA = ID_CATEGORIA;
    }

    public String getNOMBRE_CATEGORIA() {
        return NOMBRE_CATEGORIA;
    }

    public void setNOMBRE_CATEGORIA(String NOMBRE_CATEGORIA) {
        this.NOMBRE_CATEGORIA = NOMBRE_CATEGORIA;
    }

    public String getNOM_PROVEEDOR() {
        return NOM_PROVEEDOR;
    }

    public void setNOM_PROVEEDOR(String NOM_PROVEEDOR) {
        this.NOM_PROVEEDOR = NOM_PROVEEDOR;
    }

}
