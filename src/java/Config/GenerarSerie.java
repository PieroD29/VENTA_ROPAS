package Config;

public class GenerarSerie {

    int dato;

    public String NumeroSerie(int dato) {
        // Asegúrate de que el valor de dato sea el valor máximo actual + 1
        this.dato = dato + 1; // Incrementa el valor en 1

        // Formatea el número de serie
        String numero = String.format("%08d", this.dato);

        return numero;
    }
}
