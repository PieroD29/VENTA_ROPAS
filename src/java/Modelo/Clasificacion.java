package Modelo;

public class Clasificacion {
    
    int id_clas;
    String descripcion;
    String img_dir;

    public Clasificacion(int id_clas, String descripcion, String img_dir) {
        this.id_clas = id_clas;
        this.descripcion = descripcion;
        this.img_dir = img_dir;
    }
    
    public Clasificacion(){
        
    }

    public int getId_clas() {
        return id_clas;
    }

    public void setId_clas(int id_clas) {
        this.id_clas = id_clas;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImg_dir() {
        return img_dir;
    }

    public void setImg_dir(String img_dir) {
        this.img_dir = img_dir;
    }
        
    
}
