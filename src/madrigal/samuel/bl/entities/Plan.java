package madrigal.samuel.bl.entities;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

abstract class Plan {

    private int id;
    private String correoCreador;
    private String correoClienteAsignado;
    private LocalDate fechaInicio;
    private LocalDate fechaCambio;
    private String objetivo;

    public Plan(LocalDate fechaInicio, LocalDate fechaCambio, String objetivo) {
        this.id = (int) (Math.random() * 9000) + 1000;
        this.correoCreador = null;
        this.correoClienteAsignado = null;
        this.fechaInicio = fechaInicio;
        this.fechaCambio = fechaCambio;
        this.objetivo = objetivo;
    }

    public Plan() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getcorreoCreador() {
        return correoCreador;
    }

    public void setcorreoCreador(String correoCreador) {
        this.correoCreador = correoCreador;
    }

    public String getcorreoClienteAsignado() {
        return correoClienteAsignado;
    }

    public void setcorreoClienteAsignado(String correoClienteAsignado) {
        this.correoClienteAsignado = correoClienteAsignado;
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
                "creador: " + correoCreador +
                "cliente asignado: " + correoClienteAsignado +
                "fechaInicio: " + fechaInicio +
                "fechaCambio: " + fechaCambio +
                "objetivo: " + objetivo;
    }
}
