package madrigal.samuel.bl.entities;

import java.time.LocalDate;
import java.util.ArrayList;

public class Cliente extends Usuario{

    private double peso;
    private double altura;
    private Membresia membresia;

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

    @Override
    public String toString() {
        return "\nNombre Completo   : " + getNombreCompleto() +
                "\nCorreo           : " + getCorreoElectronico() +
                "\nFecha Nacimiento : " + getFechaNacimiento() +
                "\nPeso             : " + peso + " kg" +
                "\nAltura           : " + altura + " m" +
                "\nMembresia        : " + (getMembresia() != null ? getMembresia().isActiva() : "Membresia inactiva");
    }
}
