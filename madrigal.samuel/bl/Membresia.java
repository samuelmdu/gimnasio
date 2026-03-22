package bl;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Membresia {

    private LocalDate fechaVencimiento;
    private boolean activa;

    public Membresia(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
        this.activa = true;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public boolean isActiva() {
        verificarVencimiento();
        return activa;
    }

    private void verificarVencimiento() {
        if (LocalDate.now().isEqual(fechaVencimiento) || LocalDate.now().isAfter(fechaVencimiento)) {
            activa = false;
        }
    }

    public String getDiasRestantes() {
        verificarVencimiento();
        if (!activa) {
            return "Membresía vencida";
        }
        long diasRestantes = ChronoUnit.DAYS.between(LocalDate.now(), fechaVencimiento);
        return diasRestantes + " dias restantes";
    }

    @Override
    public String toString() {
        return "\nMembresia: " +
                "\nFecha de vencimiento :" + fechaVencimiento +
                "\nEstado               : " + activa +
                "\nDia de pago          : " + getFechaVencimiento() +
                "\nDías restantes       : " + getDiasRestantes();
    }
}