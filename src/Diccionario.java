import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Diccionario {
    private List<String> palabras;

    public Diccionario(String archivo) {
        this.palabras = new ArrayList<>();
        cargarPalabrasDesdeArchivo(archivo);
    }

    private void cargarPalabrasDesdeArchivo(String archivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                palabras.add(linea.trim().toUpperCase()); // Convertir a mayúsculas y eliminar espacios
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    public String obtenerPalabraAleatoria() {
        Random random = new Random();
        return palabras.get(random.nextInt(palabras.size()));
    }

    public boolean esPalabraValida(String palabra) {
        return palabras.contains(palabra.toUpperCase());
    }
}
