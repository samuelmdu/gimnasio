package madrigal.samuel.dl;

import java.sql.*;

public class AccesoBD {

    private Connection conexion;
    private Statement statement;
    private PreparedStatement preparedStatement;

    public AccesoBD(String direccion, String usuario, String contrasenia) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conexion = DriverManager.getConnection(direccion, usuario, contrasenia);
    }

    public void ejecutarStatement(String statement) throws SQLException {
        this.statement = conexion.createStatement();
        this.statement.executeUpdate(statement);
    }

    public ResultSet ejecutarQuery(String query, String cedula, String contrasenia) throws SQLException {
        preparedStatement = conexion.prepareStatement(query);
        preparedStatement.setString(1, cedula);
        preparedStatement.setString(2, contrasenia);
        return preparedStatement.executeQuery();
    }

    public ResultSet ejecutarQuery(String query, String correo) throws SQLException {
        preparedStatement = conexion.prepareStatement(query);
        preparedStatement.setString(1, correo);
        return preparedStatement.executeQuery();
    }

    public ResultSet ejecutarQuery(String query, int id) throws SQLException {
        preparedStatement = conexion.prepareStatement(query);
        preparedStatement.setInt(1, id);
        return preparedStatement.executeQuery();
    }


}
