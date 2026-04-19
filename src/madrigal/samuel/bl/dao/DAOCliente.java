package madrigal.samuel.bl.dao;

import madrigal.samuel.bl.entities.Cliente;
import madrigal.samuel.bl.entities.Membresia;
import madrigal.samuel.tl.Conector;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class DAOCliente {

    private static String statement;
    private static String query;

    public static String insertarCliente(Cliente cliente) throws SQLException, IOException, ClassNotFoundException {

        statement = "INSERT INTO t_clientes VALUES ('" + cliente.getNombreCompleto() + "', '" + cliente.getCorreoElectronico() + "', '" + cliente.getFechaNacimiento() + "', '" + cliente.getPeso() + "', '" + cliente.getAltura() + "', '" + cliente.getContrasenna() + "', " + (cliente.getMembresia() != null) + ");";
        Conector.getConexion().ejecutarStatement(statement);
        return "Cliente registrado correctamente";
    }

    public static Cliente seleccionarCliente(String correo, String contrasenia) throws SQLException, IOException, ClassNotFoundException {

        query = "SELECT * FROM t_clientes WHERE correo_electronico = ? AND contrasenia = ?;";
        ResultSet resultado = Conector.getConexion().ejecutarQuery(query, correo, contrasenia);
        if (!resultado.next()) return null;

        Cliente cliente = new Cliente(
                resultado.getString("nombre_completo"),
                resultado.getString("correo_electronico"),
                resultado.getDate("fecha_nacimiento").toLocalDate(),
                resultado.getDouble("peso_cliente"),
                resultado.getDouble("altura_cliente"),
                resultado.getString("contrasenia"));

        if (resultado.getBoolean("membresia_activa")) {
            cliente.setMembresia(new Membresia(LocalDate.now().plusMonths(1)));
        }

        return cliente;
    }

    public static Cliente seleccionarCliente(String correo) throws SQLException, IOException, ClassNotFoundException {

        query = "SELECT * FROM t_clientes WHERE correo_electronico = ?;";
        ResultSet resultado = Conector.getConexion().ejecutarQuery(query, correo);
        if (!resultado.next()) return null;

        Cliente cliente = new Cliente(
                resultado.getString("nombre_completo"),
                resultado.getString("correo_electronico"),
                resultado.getDate("fecha_nacimiento").toLocalDate(),
                resultado.getDouble("peso_cliente"),
                resultado.getDouble("altura_cliente"),
                resultado.getString("contrasenia"));

        if (resultado.getBoolean("membresia_activa")) {
            cliente.setMembresia(new Membresia(LocalDate.now().plusMonths(1)));
        }

        return cliente;
    }

    public static void actualizarMembresia(Cliente cliente) throws SQLException, IOException, ClassNotFoundException {

        statement = "UPDATE t_clientes SET membresia_activa = true WHERE correo_electronico = '" + cliente.getCorreoElectronico() + "';";

        Conector.getConexion().ejecutarStatement(statement);
    }
}
