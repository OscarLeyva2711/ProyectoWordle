import javax.swing.*;
import java.awt.*;

public class Tablero extends JPanel {
    private JLabel[][] casillas;

    public Tablero(int filas, int columnas) {
        this.setLayout(new GridLayout(filas, columnas)); // Configuración del tablero
        casillas = new JLabel[filas][columnas];

        // Inicializar casillas
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                casillas[i][j] = new JLabel("", SwingConstants.CENTER); // Texto centrado
                casillas[i][j].setBorder(BorderFactory.createLineBorder(Color.GRAY)); // Borde gris
                casillas[i][j].setOpaque(true); // Permitir fondo de color
                casillas[i][j].setBackground(Color.WHITE); // Fondo blanco por defecto
                this.add(casillas[i][j]);
            }
        }
    }

    // Método para actualizar casillas con texto y color
    public void actualizarCasilla(int fila, int columna, String texto, Color color) {
        casillas[fila][columna].setText(texto);
        casillas[fila][columna].setBackground(color);
    }
}