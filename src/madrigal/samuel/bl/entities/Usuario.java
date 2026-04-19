package madrigal.samuel.bl.entities;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public abstract class Usuario  {

    private String nombreCompleto;
    private String correoElectronico;
    private LocalDate fechaNacimiento;
    private int edad;
    private ArrayList<LocalDate> diasAsistidos = new ArrayList<>();
    private int totalDiasAsistidos;
    private String contrasenna;

    public Usuario(String nombreCompleto, String correoElectronico, LocalDate fechaNacimiento, String contrasenna) {
        this.nombreCompleto = nombreCompleto;
        this.correoElectronico = correoElectronico;
        this.fechaNacimiento = fechaNacimiento;
        this.contrasenna = contrasenna;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public int getEdad() {
        LocalDate today = LocalDate.now();
        return Period.between(fechaNacimiento, today).getYears();
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public ArrayList<LocalDate> getDiasAsistidos() {
        return diasAsistidos;
    }

    public int getTotalDiasAsistidos() {
        return totalDiasAsistidos;
    }

    public void setTotalDiasAsistidos(int totalDiasAsistidos) {
        this.totalDiasAsistidos = totalDiasAsistidos;
    }

    public String getContrasenna() {
        return contrasenna;
    }

    public void setContrasenna(String contrasenna) {
        this.contrasenna = contrasenna;
    }

    public void marcar(){

    };

    public void diasAsistidos(){
       totalDiasAsistidos =+ totalDiasAsistidos;
    };

    @Override
    public String toString() {
        return
                "\nnombreCompleto: " + nombreCompleto +
                "\ncorreoElectronico: " + correoElectronico +
                "\nfechaNacimiento: " + fechaNacimiento +
                "\nedad: " + getEdad();
    }
}
