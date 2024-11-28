public class Palabra {
    private String texto;

    public Palabra(String texto) {
        this.texto = texto;
    }

    public boolean esIgual(String otraPalabra) {
        return texto.equalsIgnoreCase(otraPalabra);
    }

    public boolean contieneLetra(char letra) {
        return texto.indexOf(letra) != -1;
    }
    // Getter para obtener la palabra
    public String getPalabra() {
        return texto;
    }

    // Metodo String para representarun la palabra como texto
    @Override
    public String toString() {
        return texto;
    }
}