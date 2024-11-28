public class ControlDeIntentos {
    private String palabraSecreta;

    public ControlDeIntentos(String palabraSecreta) {
        this.palabraSecreta = palabraSecreta;
    }

    public boolean verificarIntento(String intento) {
        if (intento == null) {
            System.out.println("El intento no puede ser nulo.");
            return false;
        }

        if (intento.length() != palabraSecreta.length()) {
            System.out.println("El intento debe tener " + palabraSecreta.length() + " letras.");
            return false;
        }

        // Aquí va la lógica existente para comparar el intento con la palabra secreta
        return intento.equalsIgnoreCase(palabraSecreta);
    }
}