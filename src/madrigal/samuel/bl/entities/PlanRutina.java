package madrigal.samuel.bl.entities;

import java.time.LocalDate;


public class PlanRutina extends Plan {

    private String grupoMuscular;

    public PlanRutina(LocalDate fechaInicio, LocalDate fechaCambio, String objetivo, String grupoMuscular) {
        super(fechaInicio, fechaCambio, objetivo);
        this.grupoMuscular = grupoMuscular;

    }

    public PlanRutina() {
    }

    public String getGrupoMuscular() {
        return grupoMuscular;
    }

    public void setGrupoMuscular(String grupoMuscular) {
        this.grupoMuscular = grupoMuscular;
    }

    @Override
    public String toString() {
        return "Rutina de " + grupoMuscular + ":" +
                "\nid: " + getId() +
                "\nfechaInicio: " + getFechaInicio() +
                "\nduración: " + getDuracion() +
                "\nobjetivo: " + getObjetivo() +
                "\ngrupo muscular: " + grupoMuscular +
                "\ncreador: " + getcorreoCreador() ;
    }
}
