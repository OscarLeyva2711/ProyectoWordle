import java.util.Random;

public class GeneradorDePalabras {
    private Diccionario diccionario;

    public GeneradorDePalabras(Diccionario diccionario) {
        this.diccionario = diccionario;
    }

    public Palabra obtenerPalabraAleatoria() {
        String palabra = diccionario.obtenerPalabraAleatoria();
        return new Palabra(palabra);
    }

    public boolean esPalabraValida(String palabra) {
        return diccionario.esPalabraValida(palabra);
    }
}