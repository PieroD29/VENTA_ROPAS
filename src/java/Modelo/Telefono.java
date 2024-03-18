package Modelo;

public class Telefono {

    private String NOMBRE_CLIENTE;
    private int ID_TELEFONO;
    private String TELEFONO_1;
    private String TELEFONO_2;
    private int ID_CLIENTE;

    public Telefono(int ID_TELEFONO, String TELEFONO_1, String TELEFONO_2, int ID_CLIENTE, String NOMBRE_CLIENTE) {
        this.ID_TELEFONO = ID_TELEFONO;
        this.TELEFONO_1 = TELEFONO_1;
        this.TELEFONO_2 = TELEFONO_2;
        this.ID_CLIENTE = ID_CLIENTE;
        this.NOMBRE_CLIENTE = NOMBRE_CLIENTE;
    }

    public Telefono() {
    }

    public int getID_TELEFONO() {
        return ID_TELEFONO;
    }

    public void setID_TELEFONO(int ID_TELEFONO) {
        this.ID_TELEFONO = ID_TELEFONO;
    }

    public String getTELEFONO_1() {
        return TELEFONO_1;
    }

    public void setTELEFONO_1(String TELEFONO_1) {
        this.TELEFONO_1 = TELEFONO_1;
    }

    public String getTELEFONO_2() {
        return TELEFONO_2;
    }

    public void setTELEFONO_2(String TELEFONO_2) {
        this.TELEFONO_2 = TELEFONO_2;
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

}
//Pierito el mas capito