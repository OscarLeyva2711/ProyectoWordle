import javax.swing.*;

public class InterfazGrafica implements InterfazUsuario {
    private JFrame frame;
    private JTextField inputField;
    private JButton submitButton;
    private String textoInput;

    public InterfazGrafica() {
        frame = new JFrame("Juego Wordle");
        inputField = new JTextField(20);
        submitButton = new JButton("Enviar");

        JPanel panel = new JPanel();
        panel.add(inputField);
        panel.add(submitButton);
        frame.add(panel);

        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Listener para capturar el input
        submitButton.addActionListener(e -> textoInput = inputField.getText());
    }

    @Override
    public void mostrar() {
        frame.setVisible(true);
    }

    @Override
    public String capturarInput() {
        // Devuelve el texto capturado
        if (textoInput != null && !textoInput.trim().isEmpty()) {
            String temp = textoInput.trim();
            textoInput = null; // Limpia el valor después de capturarlo
            return temp;
        }
        return null; // Si no hay input válido
    }

    @Override
    public void actualizar() {
        // Aquí puedes implementar la actualización gráfica (opcional)
        System.out.println("Interfaz gráfica actualizada.");
    }
}