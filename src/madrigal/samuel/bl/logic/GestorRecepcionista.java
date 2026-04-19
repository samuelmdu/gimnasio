package madrigal.samuel.bl.logic;


import madrigal.samuel.bl.dao.DAORecepcionista;
import madrigal.samuel.bl.entities.Recepcionista;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

public class GestorRecepcionista {

    public static String registrarRecepcionista(String nombreCompleto, String correoElectronico, LocalDate fechaNacimiento, LocalDate fechaContratacion, String contrasenna) throws SQLException, IOException, ClassNotFoundException {
        return DAORecepcionista.insertarRecepcionista(new Recepcionista(nombreCompleto, correoElectronico, fechaNacimiento, fechaContratacion, contrasenna));
    }

    public static Recepcionista ingresarRecepcionista(String correo, String contrasenia) throws SQLException, IOException, ClassNotFoundException {
        return DAORecepcionista.seleccionarRecepcionista(correo, contrasenia);
    }
}
