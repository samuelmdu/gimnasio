package bl;

import java.time.LocalDate;
import java.util.ArrayList;

public class PlanRutina extends Plan {

    private static int contadorIDRutina = 0;

    private int idRutina;
    private String grupoMuscular;
    private ArrayList<String> ejercicios = new ArrayList<>();

    public PlanRutina(LocalDate fechaInicio, LocalDate fechaCambio, String objetivo, String grupoMuscular) {
        super(fechaInicio, fechaCambio, objetivo);
        this.idRutina = ++contadorIDRutina;
        this.grupoMuscular = grupoMuscular;
    }

    public PlanRutina() {
    }

    public int getIdRutina() {
        return idRutina;
    }

    public String getGrupoMuscular() {
        return grupoMuscular;
    }

    public void setGrupoMuscular(String grupoMuscular) {
        this.grupoMuscular = grupoMuscular;
    }

    public ArrayList<String> getEjercicios() {
        return ejercicios;
    }

    public void agregarEjercicio(String ejercicio){
        ejercicios.add(ejercicio);
    }

    @Override
    public String toString() {
        return "Rutina de " + grupoMuscular + ":" +
                "\nid: " + idRutina +
                "\nfechaInicio: " + getFechaInicio() +
                "\nduración: " + getDuracion() +
                "\nobjetivo: " + getObjetivo() +
                "\ngrupo muscular: " + grupoMuscular +
                "\ncreador: " + getCreador() ;
    }
}
