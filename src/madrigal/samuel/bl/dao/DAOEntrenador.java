package madrigal.samuel.bl.dao;

import madrigal.samuel.bl.entities.Entrenador;
import madrigal.samuel.tl.Conector;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOEntrenador {

    private static String statement;
    private static String query;

    public static String insertarEntrenador(Entrenador entrenador) throws SQLException, IOException, ClassNotFoundException {
        statement = "INSERT INTO t_entrenadores VALUES ('" + entrenador.getNombreCompleto() + "', '" + entrenador.getCorreoElectronico() + "', '" + entrenador.getFechaNacimiento() + "', '" + entrenador.getFechaContratacion() + "', '" + entrenador.getContrasenna() + "');";
        Conector.getConexion().ejecutarStatement(statement);
        return "El entrenador se registro correctamente";
    }

    public static Entrenador seleccionarEntrenador(String correo, String contrasenia) throws SQLException, IOException, ClassNotFoundException {

        query = "SELECT * FROM t_entrenadores WHERE correo_electronico = ? AND contrasenia = ?;";
        ResultSet resultado = Conector.getConexion().ejecutarQuery(query, correo, contrasenia);
        if (!resultado.next()) return null;
        return new Entrenador(
                resultado.getString("nombre_completo"),
                resultado.getString("correo_electronico"),
                resultado.getDate("fecha_nacimiento").toLocalDate(),
                resultado.getDate("fecha_contratacion").toLocalDate(),
                resultado.getString("contrasenia"));
    }
}
