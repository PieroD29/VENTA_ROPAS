package Modelo;

public class Usuarios {

    int id_user;
    String usuario;
    String contra;
    String perfil;
    String nivel;
    String otros;
    
    
    public Usuarios() {
    }

    public Usuarios(int id_user, String usuario, String contra, String perfil, String nivel, String otros) {
        this.id_user = id_user;
        this.usuario = usuario;
        this.contra = contra;
        this.perfil = perfil;
        this.nivel = nivel;
        this.otros = otros;
    }

    public int getid_user() {
        return id_user;
    }

    public void setid_user(int id_user) {
        this.id_user = id_user;
    }

    public String getusuario() {
        return usuario;
    }

    public void setusuario(String usuario) {
        this.usuario = usuario;
    }

    public String getcontra() {
        return contra;
    }

    public void setcontra(String contra) {
        this.contra = contra;
    }

    public String getperfil() {
        return perfil;
    }

    public void setperfil(String perfil) {
        this.perfil = perfil;
    }

    public String getnivel() {
        return nivel;
    }

    public void setnivel(String nivel) {
        this.nivel = nivel;
    }

    public String getotros() {
        return otros;
    }

    public void setotros(String otros) {
        this.otros = otros;
    }
 
}
