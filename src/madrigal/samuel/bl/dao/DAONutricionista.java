package madrigal.samuel.bl.dao;
import madrigal.samuel.bl.entities.Nutricionista;
import madrigal.samuel.tl.Conector;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAONutricionista {
    private static String statement;
    private static String query;

    public static String insertarNutricionista(Nutricionista nutricionista) throws SQLException, IOException, ClassNotFoundException {

        statement = "INSERT INTO t_nutricionistas VALUES ('" + nutricionista.getNombreCompleto() + "', '" + nutricionista.getCorreoElectronico() + "', '" + nutricionista.getFechaNacimiento() + "', '" + nutricionista.getFechaContratacion() + "', '" + nutricionista.getContrasenna() + "');";
        Conector.getConexion().ejecutarStatement(statement);
        return "Nutricionista registrado correctamente";
    }

    public static Nutricionista seleccionarNutricionista(String correo, String contrasenia) throws SQLException, IOException, ClassNotFoundException {

        query = "SELECT * FROM t_nutricionistas WHERE correo_electronico = ? AND contrasenia = ?;";
        ResultSet resultado = Conector.getConexion().ejecutarQuery(query, correo, contrasenia);
        if (!resultado.next()) return null;
        return new Nutricionista(
                resultado.getString("nombre_completo"),
                resultado.getString("correo_electronico"),
                resultado.getDate("fecha_nacimiento").toLocalDate(),
                resultado.getDate("fecha_contratacion").toLocalDate(),
                resultado.getString("contrasenia"));
    }
}
