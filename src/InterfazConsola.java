import java.util.Scanner;

public class InterfazConsola implements InterfazUsuario {
    private Scanner scanner;

    public InterfazConsola() {
        scanner = new Scanner(System.in);
    }

    @Override
    public void mostrar() {
        System.out.println("Bienvenido al Juego Wordle (Versión Consola)");
    }

    @Override
    public String capturarInput() {
        System.out.print("Ingresa tu intento: ");
        String input = scanner.nextLine();
        return input != null && !input.trim().isEmpty() ? input.trim() : null;
    }

    @Override
    public void actualizar() {
        System.out.println("Estado actualizado en consola.");
    }
}