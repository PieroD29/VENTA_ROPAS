package Modelo;

public class SubCategoria {
    
    int id_sbcat;
    String descripcion;
    String img_dir;

    public SubCategoria(int id_sbcat, String descripcion, String img_dir) {
        this.id_sbcat = id_sbcat;
        this.descripcion = descripcion;
        this.img_dir = img_dir;
    }
    
    public SubCategoria(){
    
    }

    public int getId_sbcat() {
        return id_sbcat;
    }

    public void setId_sbcat(int id_sbcat) {
        this.id_sbcat = id_sbcat;
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
