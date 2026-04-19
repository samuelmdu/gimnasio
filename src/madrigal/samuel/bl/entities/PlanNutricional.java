package madrigal.samuel.bl.entities;

import java.time.LocalDate;

public class PlanNutricional extends Plan{

    private double pacienteIMC;
    private String gradoObesidad;

    public PlanNutricional(LocalDate fechaInicio, LocalDate fechaCambio, String objetivo) {
        super(fechaInicio, fechaCambio, objetivo);
        this.pacienteIMC = 0;
        this.gradoObesidad = null;
    }

    public PlanNutricional() {
    }


    public double getPacienteIMC() {
        return pacienteIMC;
    }

    public String getgradoObesidad() {
        return gradoObesidad;
    }

    public double calcularIMC(Cliente cliente){
        this.pacienteIMC = cliente.getPeso() / (cliente.getAltura() * cliente.getAltura());
        this.gradoObesidad = interpretarIMC(pacienteIMC);
        return pacienteIMC;
    }

    public String interpretarIMC(double imc) {
        if (imc < 18.5) return "Bajo peso";
        else if (imc < 24.9) return "Normal";
        else if (imc < 29.9) return "Sobrepeso";
        else return "Obesidad";
    }

    @Override
    public String toString() {
        return "Plan Nutricional:" +
                "\nid:" + getId() +
                "\nFechaInicio              : " + getFechaInicio() +
                "\nFecha Cambio             : " + getFechaCambio() +
                "\nObjetivo                 : " + getObjetivo() +
                "\nIMC                      : " + pacienteIMC +
                "\nGrado obesidad           : " + gradoObesidad +
                "\nCreador                  : " + getcorreoCreador();
    }
}
