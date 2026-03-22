package bl;

import java.time.LocalDate;

public class Entrenador extends Usuario{

    private static int contadorIDEntrenador = 0;

    private int idEntrenador;
    private LocalDate fechaContratacion;


    public Entrenador(String nombreCompleto, String correoElectronico, LocalDate fechaNacimiento, LocalDate fechaContratacion, String contrasenna) {
        super(nombreCompleto, correoElectronico, fechaNacimiento, contrasenna);
        this.idEntrenador = ++contadorIDEntrenador;
        this.fechaContratacion = fechaContratacion;
    }

    public int getIdEntrenador() {
        return idEntrenador;
    }

    public void setIdEntrenador(int idEntrenador) {
        this.idEntrenador = idEntrenador;
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
                         "\nidEntrenador: " + getIdEntrenador()+
                        "\nnombreCompleto: " + getNombreCompleto() +
                        "\ncorreoElectronico: " + getCorreoElectronico() +
                        "\nfechaNacimiento: " + getFechaNacimiento() +
                        "\nedad: " + getEdad() +
                        "\nfecha contratacion: "+ getFechaContratacion() +
                        "\ntotal dias asistidos: " + getTotalDiasAsistidos() +
                        "\ncontrasenna: " + getContrasenna();
    }
}
