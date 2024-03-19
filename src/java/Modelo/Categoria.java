package Modelo;

public class Categoria {

    int id_cat;
    String descripcion;
    String img_dir;

    public Categoria(int id_cat, String descripcion, String img_dir) {
        this.id_cat = id_cat;
        this.descripcion = descripcion;
        this.img_dir = img_dir;
    }
    
    public Categoria(){
        
    }

    public int getId_cat() {
        return id_cat;
    }

    public void setId_cat(int id_cat) {
        this.id_cat = id_cat;
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

