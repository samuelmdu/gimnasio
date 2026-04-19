package madrigal.samuel.bl.logic;

import madrigal.samuel.bl.dao.DAOCliente;
import madrigal.samuel.bl.dao.DAORutina;

import madrigal.samuel.bl.entities.Cliente;
import madrigal.samuel.bl.entities.Entrenador;
import madrigal.samuel.bl.entities.PlanRutina;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

public class GestorRutina {
    public static String registrarRutina(Entrenador entrenador, LocalDate fechaInicio, LocalDate fechaCambio, String objetivo, String grupoMuscular) throws SQLException, IOException, ClassNotFoundException {

        PlanRutina insertarRutina = new PlanRutina(fechaInicio, fechaCambio, objetivo, grupoMuscular);
        insertarRutina.setcorreoCreador(entrenador.getNombreCompleto());

        return DAORutina.insertarRutina(insertarRutina);
    }

    public static PlanRutina buscarRutina(int id) throws SQLException, IOException, ClassNotFoundException {
        return DAORutina.seleccionarRutina(id);
    }

    public static void verRutinas(Entrenador entrenador) throws SQLException, IOException, ClassNotFoundException {
        DAORutina.verRutinas(entrenador);
    }

    public static void verRutinasCliente(Cliente cliente) throws SQLException, IOException, ClassNotFoundException {
        DAORutina.verRutinasCliente(cliente);
    }

    public static String asignarRutina(Cliente cliente, PlanRutina rutina) throws SQLException, IOException, ClassNotFoundException {
        rutina.setcorreoClienteAsignado(cliente.getCorreoElectronico());

        return DAORutina.asignarRutina(rutina);
    }

}
