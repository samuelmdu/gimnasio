package madrigal.samuel.bl.exceptions;

public class FechaInvalida extends RuntimeException {
    public FechaInvalida() {
        super("Error: Formato de fecha inválido. Use el formato YYYY-MM-DD.");
    }
}