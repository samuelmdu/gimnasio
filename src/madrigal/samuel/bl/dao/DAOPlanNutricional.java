package madrigal.samuel.bl.dao;

import madrigal.samuel.bl.entities.Cliente;
import madrigal.samuel.bl.entities.Nutricionista;
import madrigal.samuel.bl.entities.PlanNutricional;
import madrigal.samuel.tl.Conector;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class DAOPlanNutricional {

    private static String statement;
    private static String query;

    public static String insertarPlanNutricional(PlanNutricional planNutricional) throws SQLException, IOException, ClassNotFoundException {

        statement = "INSERT INTO t_planes_nutricionales(id, fecha_inicio, fecha_cambio, objetivo, paciente_imc, grado_obesidad, correo_creador) VALUES ('" + planNutricional.getId() + "', '" + planNutricional.getFechaInicio() + "', '" + planNutricional.getFechaCambio() + "', '" + planNutricional.getObjetivo() + "', '" + planNutricional.getPacienteIMC() + "', '" + planNutricional.getgradoObesidad() + "', '" + planNutricional.getcorreoCreador() + "');";
        Conector.getConexion().ejecutarStatement(statement);
        return "Plan nutricional registrado correctamente";
    }

    public static PlanNutricional seleccionarPlanNutricional(int id) throws SQLException, IOException, ClassNotFoundException {
        query = "SELECT * FROM t_planes_nutricionales WHERE id = ?;";
        ResultSet resultado = Conector.getConexion().ejecutarQuery(query, id);
        if (!resultado.next()) return null;

        PlanNutricional nuevoPlan = new PlanNutricional(
                resultado.getDate("fecha_inicio").toLocalDate(),
                resultado.getDate("fecha_cambio").toLocalDate(),
                resultado.getString("objetivo")
        );

        nuevoPlan.setId(resultado.getInt("id"));
        nuevoPlan.setcorreoCreador(resultado.getString("correo_creador"));
        nuevoPlan.setcorreoClienteAsignado(resultado.getString("correo_cliente_asignado"));

        return nuevoPlan;
    }

    public static void verPlanesNutricionales(Nutricionista nutricionista) throws SQLException, IOException, ClassNotFoundException {
        query = "SELECT * FROM t_planes_nutricionales WHERE correo_creador = ?;";
        ResultSet resultado = Conector.getConexion().ejecutarQuery(query, nutricionista.getCorreoElectronico());

        while (resultado.next()) {
            System.out.println(
                    "ID: " + resultado.getInt("id") +
                            " Fecha Inicio: " + resultado.getDate("fecha_inicio") +
                            " Fecha Cambio: " + resultado.getDate("fecha_cambio") +
                            " Objetivo: " + resultado.getString("objetivo") +
                            " IMC: " + resultado.getDouble("paciente_imc") +
                            " Grado Obesidad: " + resultado.getString("grado_obesidad") +
                            " Correo Creador: " + resultado.getString("correo_creador") +
                            " Correo Cliente Asignado: " + resultado.getString("correo_cliente_asignado")
            );
        }
    }

    public static void verPlanesNutricionalesCliente(Cliente cliente) throws SQLException, IOException, ClassNotFoundException {
        query = "SELECT * FROM t_planes_nutricionales WHERE correo_cliente_asignado = ?;";
        ResultSet resultado = Conector.getConexion().ejecutarQuery(query, cliente.getCorreoElectronico());

        while (resultado.next()) {
            System.out.println(
                    "ID: " + resultado.getInt("id") +
                            " Fecha Inicio: " + resultado.getDate("fecha_inicio") +
                            " Fecha Cambio: " + resultado.getDate("fecha_cambio") +
                            " Objetivo: " + resultado.getString("objetivo") +
                            " IMC: " + resultado.getDouble("paciente_imc") +
                            " Grado Obesidad: " + resultado.getString("grado_obesidad") +
                            " Correo Creador: " + resultado.getString("correo_creador")
            );
        }
    }

    public static String asignarPlanNutricional(PlanNutricional planNutricional) throws SQLException, IOException, ClassNotFoundException {
        try {
            statement = "UPDATE t_planes_nutricionales SET correo_cliente_asignado = '" + planNutricional.getcorreoClienteAsignado() + "', paciente_imc = '" + planNutricional.getPacienteIMC() + "', grado_obesidad = '" + planNutricional.getgradoObesidad() + "' WHERE id = " + planNutricional.getId() + ";";            Conector.getConexion().ejecutarStatement(statement);
            return "Plan nutricional asignado correctamente";
        } catch (Exception e) {
            return "Error al asignar el plan nutricional: " + e.getMessage();
        }
    }
}