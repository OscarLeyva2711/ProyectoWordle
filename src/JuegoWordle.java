import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

public class JuegoWordle extends JFrame {
    private Tablero tablero;
    private Teclado teclado;
    private int intentoActual = 0; // Contador de intentos
    private Diccionario diccionario; // Instancia de Diccionario
    private String palabraSecreta;  // Palabra oculta seleccionada aleatoriamente

    public JuegoWordle() {
        this.setTitle("Juego Wordle");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        // Inicializar el diccionario y seleccionar la palabra secreta
        diccionario = new Diccionario("/Users/donlevantin/LabJava/ProyectoFinalLab/src/Diccionario.txt");
        palabraSecreta = diccionario.obtenerPalabraAleatoria();

        // Crear el tablero y el teclado
        tablero = new Tablero(6, 5); // 6 intentos, 5 letras por palabra
        teclado = new Teclado(new ManejadorDeEventos());

        // Agregar tablero y teclado al frame
        this.add(tablero, BorderLayout.CENTER);
        this.add(teclado, BorderLayout.SOUTH);

        this.setSize(400, 600); // Tamaño de la ventana
        this.setVisible(true);

        // Imprimir la palabra secreta en consola para pruebas
        // System.out.println("Palabra secreta: " + palabraSecreta);
    }

    // Escuchador de eventos para los botones
    private class ManejadorDeEventos implements ActionListener {
        private StringBuilder intentoActualTexto = new StringBuilder(); // Almacena el intento actual

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton boton = (JButton) e.getSource();
            String texto = boton.getText();

            if (texto.equals("ENVIAR")) {
                // Procesar el intento actual
                if (intentoActualTexto.length() == palabraSecreta.length()) {
                    verificarIntento(intentoActualTexto.toString().toUpperCase());
                    intentoActualTexto.setLength(0); // Reiniciar texto del intento
                } else {
                    JOptionPane.showMessageDialog(null, "Completa la palabra antes de enviar.");
                }
            } else if (texto.equals("BORRAR")) {
                // Eliminar el último carácter ingresado
                if (intentoActualTexto.length() > 0) {
                    int columna = intentoActualTexto.length() - 1;
                    tablero.actualizarCasilla(intentoActual, columna, "", Color.WHITE); // Limpia la casilla
                    intentoActualTexto.setLength(intentoActualTexto.length() - 1); // Elimina el último carácter
                }
            } else {
                // Agregar letra seleccionada al intento actual
                if (intentoActualTexto.length() < palabraSecreta.length()) {
                    intentoActualTexto.append(texto);
                    tablero.actualizarCasilla(intentoActual, intentoActualTexto.length() - 1, texto, Color.LIGHT_GRAY);

                    // Cambiar el color del botón en el teclado
                    actualizarColorTecla(boton, texto);
                }
            }
        }

        private void actualizarColorTecla(JButton boton, String letra) {
            if (palabraSecreta.contains(letra)) {
                boton.setBackground(Color.YELLOW); // Amarillo si la letra está en la palabra
            } else {
                boton.setBackground(Color.RED); // Rojo si la letra no está en la palabra
            }
        }
    }

    // Verificar el intento actual
    private void verificarIntento(String intento) {
        for (int i = 0; i < palabraSecreta.length(); i++) {
            char letraIntento = intento.charAt(i);
            char letraSecreta = palabraSecreta.charAt(i);

            if (letraIntento == letraSecreta) {
                // Letra correcta en la posición correcta
                tablero.actualizarCasilla(intentoActual, i, String.valueOf(letraIntento), Color.GREEN);
            } else if (palabraSecreta.contains(String.valueOf(letraIntento))) {
                // Letra correcta en posición incorrecta
                tablero.actualizarCasilla(intentoActual, i, String.valueOf(letraIntento), Color.YELLOW);
            } else {
                // Letra incorrecta
                tablero.actualizarCasilla(intentoActual, i, String.valueOf(letraIntento), Color.RED);
            }
        }

        // Incrementar el contador de intentos
        intentoActual++;

        if (intento.equals(palabraSecreta)) {
            JOptionPane.showMessageDialog(this, "¡Felicidades! Adivinaste la palabra.");
            System.exit(0);
        } else if (intentoActual >= 6) {
            JOptionPane.showMessageDialog(this, "Lo siento, has perdido. La palabra era: " + palabraSecreta);
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new JuegoWordle();
    }
}
