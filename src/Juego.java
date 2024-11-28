public abstract class Juego {
    protected int intentos;
    protected boolean juegoTerminado;

    public Juego() {
        this.intentos = 0;
        this.juegoTerminado = false;
    }

    public abstract void iniciarJuego();

    public boolean juegoGanado() {
        return juegoTerminado;
    }
}