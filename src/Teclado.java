import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Teclado extends JPanel {
    private JButton[] botones;
    private JButton enviar, borrar;

    public Teclado(ActionListener listener) {
        this.setLayout(new GridLayout(2, 13)); // 2 filas y 13 columnas (diseño QWERTY aproximado)
        botones = new JButton[26]; // Botones para las letras A-Z

        // Crear botones para las letras
        for (int i = 0; i < 26; i++) {
            char letra = (char) ('A' + i);
            botones[i] = new JButton(String.valueOf(letra));
            botones[i].addActionListener(listener); // Agregar escuchador para capturar eventos
            this.add(botones[i]);
        }
        // Botón BORRAR
        borrar = new JButton("BORRAR");
        borrar.addActionListener(listener);
        this.add(borrar);
        // Botón "ENVIAR"
        enviar = new JButton("ENVIAR");
        enviar.addActionListener(listener);
        this.add(enviar);
    }

    public JButton getBotonEnviar() {
        return enviar;
    }
}