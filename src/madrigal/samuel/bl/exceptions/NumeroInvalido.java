package madrigal.samuel.bl.exceptions;

public class NumeroInvalido extends RuntimeException {
    public NumeroInvalido() {
        super("Error: Debe ingresar un número entero válido.");
    }
}