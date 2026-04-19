package madrigal.samuel.bl.entities;

import java.time.LocalDate;

public class Recepcionista extends Usuario{


    private LocalDate fechaContratacion;

    public Recepcionista(String nombreCompleto, String correoElectronico, LocalDate fechaNacimiento,LocalDate fechaContratacion, String contrasenna) {
        super(nombreCompleto, correoElectronico, fechaNacimiento, contrasenna);
        this.fechaContratacion = fechaContratacion;
    }

    public LocalDate getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(LocalDate fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }


    @Override
    public String toString() {
        return
                        "\nnombreCompleto: " + getNombreCompleto() +
                        "\ncorreoElectronico: " + getCorreoElectronico() +
                        "\nfechaNacimiento: " + getFechaNacimiento() +
                        "\nedad: " + getEdad() +
                        "\nfecha contratacion: "+ getFechaContratacion() +
                        "\ncontrasenna: " + getContrasenna();
    }
}
