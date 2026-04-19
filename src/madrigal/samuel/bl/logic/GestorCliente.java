package madrigal.samuel.bl.logic;

import madrigal.samuel.bl.dao.DAOCliente;
import madrigal.samuel.bl.entities.Cliente;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

public class GestorCliente {
    public static String registrarCliente(String nombreCompleto, String correoElectronico, LocalDate fechaNacimiento, double peso, double altura, String contrasenna) throws SQLException, IOException, ClassNotFoundException {
        return DAOCliente.insertarCliente(new Cliente(nombreCompleto, correoElectronico, fechaNacimiento, peso, altura, contrasenna));
    }

    public static Cliente ingresarCliente(String correo, String contrasenia) throws SQLException, IOException, ClassNotFoundException {
        return DAOCliente.seleccionarCliente(correo, contrasenia);
    }

    public static Cliente ingresarCliente(String correo) throws SQLException, IOException, ClassNotFoundException {
        return DAOCliente.seleccionarCliente(correo);
    }

    public static void actualizarMembresia(Cliente cliente) throws SQLException, IOException, ClassNotFoundException {
        DAOCliente.actualizarMembresia(cliente);
    }

}
