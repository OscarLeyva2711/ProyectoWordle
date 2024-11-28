import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenido a Wordle");
        System.out.println("Seleccione el modo de juego:");
        System.out.println("1. Modo Gráfico");
        System.out.println("2. Modo Consola");
        System.out.print("Ingrese su elección (1 o 2): ");

        int opcion = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        switch (opcion) {
            case 1:
                System.out.println("Iniciando el modo gráfico...");
                new JuegoWordle(); // Inicializa el modo gráfico
                break;

            case 2:
                System.out.println("Iniciando el modo consola...");
                iniciarModoConsola(); // Metodo modo consola
                break;

            default:
                System.out.println("Opción inválida. Saliendo del juego.");
                break;
        }
        scanner.close();
    }

    private static void iniciarModoConsola() {
        Diccionario diccionario = new Diccionario("/Users/donlevantin/LabJava/ProyectoFinalLab/src/Diccionario.txt");
        String palabraSecreta = diccionario.obtenerPalabraAleatoria();
        Scanner scanner = new Scanner(System.in);

        System.out.println("¡Bienvenido al modo consola de Wordle!");
        System.out.println("Adivina la palabra de 5 letras. Tienes 6 intentos.");
        System.out.println("Introduce tus palabras en mayúsculas.");

        int intentos = 6;
        while (intentos > 0) {
            System.out.print("Intento (" + intentos + " restantes): ");
            String intento = scanner.nextLine().toUpperCase();

            if (intento.length() != palabraSecreta.length()) {
                System.out.println("La palabra debe tener " + palabraSecreta.length() + " letras.");
                continue;
            }

            if (!diccionario.esPalabraValida(intento)) {
                System.out.println("Esa palabra no está en el diccionario.");
                continue;
            }

            // Comprobar el intento
            String resultado = verificarIntentoConsola(intento, palabraSecreta);
            System.out.println(resultado);

            if (intento.equals(palabraSecreta)) {
                System.out.println("¡Felicidades! Adivinaste la palabra.");
                return;
            }

            intentos--;
        }

        System.out.println("Lo siento, no adivinaste la palabra. Era: " + palabraSecreta);
    }

    private static String verificarIntentoConsola(String intento, String palabraSecreta) {
        StringBuilder resultado = new StringBuilder();

        for (int i = 0; i < palabraSecreta.length(); i++) {
            char letraIntento = intento.charAt(i);
            char letraSecreta = palabraSecreta.charAt(i);

            if (letraIntento == letraSecreta) {
                // Letra correcta en posición correcta
                resultado.append(letraIntento).append(" (✔) ");
            } else if (palabraSecreta.contains(String.valueOf(letraIntento))) {
                // Letra correcta en posición incorrecta
                resultado.append(letraIntento).append(" (~) ");
            } else {
                // Letra incorrecta
                resultado.append(letraIntento).append(" (✘) ");
            }
        }

        return resultado.toString();
    }
}
