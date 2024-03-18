package Modelo;

public class Empleado {

    int ID_VENDEDOR;
    String DNI;
    String NOMBRE_VENDEDOR;
    String FECHA_CONTRATO;
    double SALARIO;
    String ESTADO_VENDEDOR;
    String USUARIO;
    
    public Empleado() {
    }

    public Empleado(int ID_VENDEDOR, String DNI, String NOMBRE_VENDEDOR, String FECHA_CONTRATO, double SALARIO, String ESTADO_VENDEDOR, String USUARIO) {
        this.ID_VENDEDOR = ID_VENDEDOR;
        this.DNI = DNI;
        this.NOMBRE_VENDEDOR = NOMBRE_VENDEDOR;
        this.FECHA_CONTRATO = FECHA_CONTRATO;
        this.SALARIO = SALARIO;
        this.ESTADO_VENDEDOR = ESTADO_VENDEDOR;
        this.USUARIO = USUARIO;
    }

    public int getID_VENDEDOR() {
        return ID_VENDEDOR;
    }

    public void setID_VENDEDOR(int ID_VENDEDOR) {
        this.ID_VENDEDOR = ID_VENDEDOR;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getNOMBRE_VENDEDOR() {
        return NOMBRE_VENDEDOR;
    }

    public void setNOMBRE_VENDEDOR(String NOMBRE_VENDEDOR) {
        this.NOMBRE_VENDEDOR = NOMBRE_VENDEDOR;
    }

    public String getFECHA_CONTRATO() {
        return FECHA_CONTRATO;
    }

    public void setFECHA_CONTRATO(String FECHA_CONTRATO) {
        this.FECHA_CONTRATO = FECHA_CONTRATO;
    }

    public double getSALARIO() {
        return SALARIO;
    }

    public void setSALARIO(double SALARIO) {
        this.SALARIO = SALARIO;
    }

    public String getESTADO_VENDEDOR() {
        return ESTADO_VENDEDOR;
    }

    public void setESTADO_VENDEDOR(String ESTADO_VENDEDOR) {
        this.ESTADO_VENDEDOR = ESTADO_VENDEDOR;
    }

    public String getUSUARIO() {
        return USUARIO;
    }

    public void setUSUARIO(String USUARIO) {
        this.USUARIO = USUARIO;
    }
//soy ichpas
}
