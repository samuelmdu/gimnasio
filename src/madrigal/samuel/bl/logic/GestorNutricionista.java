package madrigal.samuel.bl.logic;

import madrigal.samuel.bl.dao.DAONutricionista;
import madrigal.samuel.bl.entities.Nutricionista;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

public class GestorNutricionista {

    public static String registrarNutricionista(String nombreCompleto, String correoElectronico, LocalDate fechaNacimiento, LocalDate fechaContratacion, String contrasenna) throws SQLException, IOException, ClassNotFoundException {
        return DAONutricionista.insertarNutricionista(new Nutricionista(nombreCompleto, correoElectronico, fechaNacimiento, fechaContratacion, contrasenna));
    }

    public static Nutricionista ingresarNutricionista(String correo, String contrasenia) throws SQLException, IOException, ClassNotFoundException {
        return DAONutricionista.seleccionarNutricionista(correo, contrasenia);
    }
}
