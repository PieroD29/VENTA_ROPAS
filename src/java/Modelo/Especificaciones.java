package Modelo;

public class Especificaciones {

    private int id_esp;
    private String titulo;
    private String descripcion;
    private int id_prod;
 
   
    public Especificaciones() {
    }

    public Especificaciones(int id_esp, String titulo, String descripcion, int id_prod) {
        this.id_esp = id_esp;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.id_prod = id_prod;
    }

    public int getid_esp() {
        return id_esp;
    }

    public void setid_esp(int id_esp) {
        this.id_esp = id_esp;
    }

    public String gettitulo() {
        return titulo;
    }

    public void settitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getdescripcion() {
        return descripcion;
    }

    public void setdescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getid_prod() {
        return id_prod;
    }

    public void setid_prod(int id_prod) {
        this.id_prod = id_prod;
    }
 
}
