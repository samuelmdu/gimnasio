package madrigal.samuel.bl.logic;

import madrigal.samuel.bl.dao.DAOEntrenador;
import madrigal.samuel.bl.entities.Entrenador;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

public class GestorEntrenador {

    public static String registrarEntrenador(String nombreCompleto, String correoElectronico, LocalDate fechaNacimiento, LocalDate fechaContratacion, String contrasenna) throws SQLException, IOException, ClassNotFoundException {
        return DAOEntrenador.insertarEntrenador(new Entrenador(nombreCompleto, correoElectronico, fechaNacimiento, fechaContratacion, contrasenna));
    }

    public static Entrenador ingresarEntrenador(String correo, String contrasenia) throws SQLException, IOException, ClassNotFoundException {
        return DAOEntrenador.seleccionarEntrenador(correo, contrasenia);
    }
}
