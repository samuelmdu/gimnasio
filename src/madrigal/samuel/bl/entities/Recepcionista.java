package madrigal.samuel.bl.entities;

import java.time.LocalDate;

public class Recepcionista extends Usuario{

    private static int contadorIDRecepcionista = 0;

    private int idRecepcionista;
    private LocalDate fechaContratacion;

    public Recepcionista(String nombreCompleto, String correoElectronico, LocalDate fechaNacimiento,LocalDate fechaContratacion, String contrasenna) {
        super(nombreCompleto, correoElectronico, fechaNacimiento, contrasenna);

        this.idRecepcionista = ++contadorIDRecepcionista;
        this.fechaContratacion = fechaContratacion;
    }

    public int getIdRecepcionista() {
        return idRecepcionista;
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
                "\nidEntrenador: " + getIdRecepcionista()+
                        "\nnombreCompleto: " + getNombreCompleto() +
                        "\ncorreoElectronico: " + getCorreoElectronico() +
                        "\nfechaNacimiento: " + getFechaNacimiento() +
                        "\nedad: " + getEdad() +
                        "\nfecha contratacion: "+ getFechaContratacion() +
                        "\ndias asistidos: " + getDiasAsistidos() +
                        "\ntotal dias asistidos: " + getTotalDiasAsistidos() +
                        "\ncontrasenna: " + getContrasenna();
    }
}
