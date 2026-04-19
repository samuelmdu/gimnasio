package madrigal.samuel.bl.dao;

import madrigal.samuel.bl.entities.Cliente;
import madrigal.samuel.bl.entities.Entrenador;
import madrigal.samuel.bl.entities.PlanRutina;
import madrigal.samuel.tl.Conector;

import java.io.IOException;

import java.sql.ResultSet;
import java.sql.SQLException;


public class DAORutina {

    private static String statement;
    private static String query;

    public static String insertarRutina(PlanRutina rutina) throws SQLException, IOException, ClassNotFoundException {

        statement = "INSERT INTO t_rutinas VALUES ('" + rutina.getId() + "', '" + rutina.getFechaInicio() + "', '" + rutina.getFechaCambio() + "', '" + rutina.getObjetivo() + "', '" + rutina.getGrupoMuscular() + "', '" + rutina.getcorreoCreador() + "', '" + rutina.getcorreoClienteAsignado() + "');";
        Conector.getConexion().ejecutarStatement(statement);
        return "Rutina registrada correctamente";
    }

    public static PlanRutina seleccionarRutina(int id) throws SQLException, IOException, ClassNotFoundException {

        query = "SELECT * FROM t_rutinas WHERE id = ?;";
        ResultSet resultado = Conector.getConexion().ejecutarQuery(query, id);
        if (!resultado.next()) return null;

        PlanRutina nuevaRutina = new PlanRutina(
                resultado.getDate("fecha_inicio").toLocalDate(),
                resultado.getDate("fecha_cambio").toLocalDate(),
                resultado.getString("objetivo"),
                resultado.getString("grupo_muscular")
        );


        nuevaRutina.setId(resultado.getInt("id"));
        nuevaRutina.setcorreoCreador(resultado.getString("correo_creador"));

        return nuevaRutina;
    }

    public static void verRutinas(Entrenador entrenador) throws SQLException, IOException, ClassNotFoundException {

        query = "SELECT * FROM t_rutinas WHERE correo_creador = ?";
        ResultSet resultado = Conector.getConexion().ejecutarQuery(query, entrenador.getCorreoElectronico());

        if (!resultado.next()){
            System.out.println("Error: debe crear una rutina primero.");
            return;
        }

        do {
            System.out.println(
                            "ID: " + resultado.getInt("id") +
                            " Fecha Inicio: " + resultado.getDate("fecha_inicio") +
                            " Fecha Cambio: " + resultado.getDate("fecha_cambio") +
                            " Objetivo: " + resultado.getString("objetivo") +
                            " Grupo Muscular: " + resultado.getString("grupo_muscular") +
                            " Correo Creador: " + resultado.getString("correo_creador") +
                            " Correo Cliente Asignado: " + resultado.getString("correo_cliente_asignado")
            );

        } while (resultado.next());
    }

    public static void verRutinasCliente(Cliente cliente) throws SQLException, IOException, ClassNotFoundException {
        query = "SELECT * FROM t_rutinas WHERE correo_cliente_asignado = ?;";
        ResultSet resultado = Conector.getConexion().ejecutarQuery(query, cliente.getCorreoElectronico());

        while (resultado.next()) {
            System.out.println(
                    "ID: " + resultado.getInt("id") +
                            " Fecha Inicio: " + resultado.getDate("fecha_inicio") +
                            " Fecha Cambio: " + resultado.getDate("fecha_cambio") +
                            " Objetivo: " + resultado.getString("objetivo") +
                            " Grupo Muscular: " + resultado.getString("grupo_muscular") +
                            " Correo Creador: " + resultado.getString("correo_creador")
            );
        }
    }

    public static String asignarRutina(PlanRutina rutina) throws SQLException, IOException, ClassNotFoundException {
        try {

            statement = "UPDATE t_rutinas SET correo_cliente_asignado = '" + rutina.getcorreoClienteAsignado() + "' WHERE id = " + rutina.getId() + ";";
            Conector.getConexion().ejecutarStatement(statement);
            return "Rutina asignada correctamente";
        } catch (Exception e) {
            return "Error al asignar la rutina: " + e.getMessage();
        }
    }

}
