package madrigal.samuel.bl.dao;

import madrigal.samuel.bl.entities.Recepcionista;
import madrigal.samuel.tl.Conector;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAORecepcionista {
    private static String statement;
    private static String query;

    public static String insertarRecepcionista(Recepcionista recepcionista) throws SQLException, IOException, ClassNotFoundException {

        statement = "INSERT INTO t_recepcionistas VALUES ('" + recepcionista.getNombreCompleto() + "', '" + recepcionista.getCorreoElectronico() + "', '" + recepcionista.getFechaNacimiento() + "', '" + recepcionista.getFechaContratacion() + "', '" + recepcionista.getContrasenna() + "');";
        Conector.getConexion().ejecutarStatement(statement);
        return "Nutricionista registrado correctamente";
    }

    public static Recepcionista seleccionarRecepcionista(String correo, String contrasenia) throws SQLException, IOException, ClassNotFoundException {

        query = "SELECT * FROM t_recepcionistas WHERE correo_electronico = ? AND contrasenia = ?;";
        ResultSet resultado = Conector.getConexion().ejecutarQuery(query, correo, contrasenia);
        if (!resultado.next()) return null;
        return new Recepcionista(
                resultado.getString("nombre_completo"),
                resultado.getString("correo_electronico"),
                resultado.getDate("fecha_nacimiento").toLocalDate(),
                resultado.getDate("fecha_contratacion").toLocalDate(),
                resultado.getString("contrasenia"));
    }
}
