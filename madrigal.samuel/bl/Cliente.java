package bl;

import java.time.LocalDate;
import java.util.ArrayList;

public class Cliente extends Usuario{

    private double peso;
    private double altura;
    private Membresia membresia;
    private ArrayList<Plan> planes = new ArrayList<>();

    public Cliente(String nombreCompleto, String correoElectronico, LocalDate fechaNacimiento, double peso, double altura, String contrasenna) {
        super(nombreCompleto, correoElectronico, fechaNacimiento, contrasenna);
        this.membresia = null;
        this.peso = peso;
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public void setMembresia(Membresia membresia) {
        this.membresia = membresia;
    }

    public Membresia getMembresia() {
        return membresia;
    }

    public void pagarMembresia(Ticket ticket){
        ticket.setPago(true);
    }

    public void revisarPlanRutina(){

        boolean contadorPlanes = false;

        for (int i = 0; i < planes.size(); i++) {

            Plan plan = planes.get(i);

            if(plan instanceof PlanRutina){
                System.out.println(plan);
                contadorPlanes = true;
            }

        }

        if (!contadorPlanes){
            System.out.println("\nError: Usted no cuenta con rutinas asignadas, contacte a un instructor.\n");
        }
    }

    public void revisarPlanNutricional(){
        boolean contadorPlanes = false;

        for (int i = 0; i < planes.size(); i++) {

            Plan plan = planes.get(i);

            if(plan instanceof PlanNutricional){
                System.out.println(plan);
                contadorPlanes = true;
            }

        }

        if (!contadorPlanes){
            System.out.println("\nError: Usted no cuenta con planes nutricionales asignadas, contacte a un instructor.\n");
        }
    }

    public void annadirPlanes(Plan plan) {
        planes.add(plan);
    }

    public void marcar(){
        LocalDate hoy = LocalDate.now();

        if (getDiasAsistidos().contains(hoy)){
            System.out.println("\nError: ya se registro su asistencia el dia de hoy " + hoy + "\n");
            return;
        }

        getDiasAsistidos().add(hoy);
        System.out.println("El día " + hoy + " fue registrado correctamente.");
        diasAsistidos();
    };

    public void diasAsistidos(){
        setTotalDiasAsistidos(getTotalDiasAsistidos() + 1);
    };

    @Override
    public String toString() {
        return "\nNombre Completo   : " + getNombreCompleto() +
                "\nCorreo           : " + getCorreoElectronico() +
                "\nFecha Nacimiento : " + getFechaNacimiento() +
                "\nPeso             : " + peso + " kg" +
                "\nAltura           : " + altura + " m" +
                "\nbl.Membresia     : " + getMembresia().isActiva() +
                "\nPlanes           : " + planes;
    }
}
