package madrigal.samuel.bl.entities;

import java.time.LocalDate;

public class Nutricionista extends Usuario{

    private static int contadorIDNutricionista = 0;

    private int idNutricionista;
    private LocalDate fechaContratacion;


    public Nutricionista(String nombreCompleto, String correoElectronico, LocalDate fechaNacimiento, LocalDate fechaContratacion, String contrasenna) {
        super(nombreCompleto, correoElectronico, fechaNacimiento, contrasenna);
        this.idNutricionista = ++contadorIDNutricionista;
        this.fechaContratacion = fechaContratacion;

    }

    public int getIdNutricionista() {
        return idNutricionista;
    }

    public LocalDate getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(LocalDate fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }


    public void marcar(){
        LocalDate hoy = LocalDate.now();

        if (getDiasAsistidos().contains(hoy)){
            System.out.println("\nError: ya registraste asistencia el dia de hoy " + hoy + "\n");
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
        return
                        "\nidNutricionista: " + getIdNutricionista()+
                        "\nnombreCompleto: " + getNombreCompleto() +
                        "\ncorreoElectronico: " + getCorreoElectronico() +
                        "\nfechaNacimiento: " + getFechaNacimiento() +
                        "\nedad: " + getEdad() +
                        "\nfecha contratacion: "+ getFechaContratacion() +
                        "\ndias asistidos: " + getDiasAsistidos() +
                        "\ntotal dias asistidos: " + getTotalDiasAsistidos() +
                        "\ncontrasenna: " + getContrasenna() + "\n";
    }

}
