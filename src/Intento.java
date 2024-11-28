public class Intento {
    private String palabraIntento;
    private String respuesta;

    public Intento(String palabraIntento, Palabra palabraSecreta) {
        this.palabraIntento = palabraIntento;
        this.respuesta = generarRespuesta(palabraSecreta);
    }

    private String generarRespuesta(Palabra palabraSecreta) {
        StringBuilder resultado = new StringBuilder();
        for (int i = 0; i < palabraIntento.length(); i++) {
            char letra = palabraIntento.charAt(i);
            if (palabraSecreta.esIgual(palabraIntento)) {
                resultado.append("✓");
            } else if (palabraSecreta.contieneLetra(letra)) {
                resultado.append("~");
            } else {
                resultado.append("✗");
            }
        }
        return resultado.toString();
    }

    @Override
    public String toString() {
        return palabraIntento + " -> " + respuesta;
    }
}