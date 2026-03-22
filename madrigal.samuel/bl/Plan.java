package bl;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

abstract class Plan {

    private LocalDate fechaInicio;
    private LocalDate fechaCambio;
    private String creador;
    private String objetivo;

    public Plan(LocalDate fechaInicio, LocalDate fechaCambio, String objetivo) {
        this.fechaInicio = fechaInicio;
        this.fechaCambio = fechaCambio;
        this.objetivo = objetivo;
    }

    public Plan() {
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaCambio() {
        return fechaCambio;
    }

    public void setFechaCambio(LocalDate fechaCambio) {
        this.fechaCambio = fechaCambio;
    }

    public String getCreador() {
        return creador;
    }

    public void setCreador(String creador) {
        this.creador = creador;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }


    public String getDuracion() {

        long semanas = ChronoUnit.WEEKS.between(fechaInicio, fechaCambio);
        long dias = ChronoUnit.DAYS.between(fechaInicio, fechaCambio);

        return "Semanas " + semanas + " Dias " + dias;

    }

    @Override
    public String toString() {
        return "Rutina: " +
                "fechaInicio: " + fechaInicio +
                "fechaCambio: " + fechaCambio +
                "creador: " + creador +
                "objetivo: " + objetivo;
    }
}
