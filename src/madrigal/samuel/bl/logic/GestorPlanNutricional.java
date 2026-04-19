package madrigal.samuel.bl.logic;

import madrigal.samuel.bl.dao.DAOPlanNutricional;
import madrigal.samuel.bl.entities.Cliente;
import madrigal.samuel.bl.entities.Nutricionista;
import madrigal.samuel.bl.entities.PlanNutricional;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

public class GestorPlanNutricional {

    public static String registrarPlanNutricional(Nutricionista nutricionista, LocalDate fechaInicio, LocalDate fechaCambio, String objetivo) throws SQLException, IOException, ClassNotFoundException {

       PlanNutricional insertarPlanNutricional = new PlanNutricional(fechaInicio, fechaCambio, objetivo);
       insertarPlanNutricional.setcorreoCreador(nutricionista.getCorreoElectronico());
       return DAOPlanNutricional.insertarPlanNutricional(insertarPlanNutricional);
    }

    public static PlanNutricional buscarPlanNutricional(int id) throws SQLException, IOException, ClassNotFoundException {
        return DAOPlanNutricional.seleccionarPlanNutricional(id);
    }

    public static void verPlanesNutricionales(Nutricionista nutricionista) throws SQLException, IOException, ClassNotFoundException {
        DAOPlanNutricional.verPlanesNutricionales(nutricionista);
    }

    public static void verPlanesNutricionalesCliente(Cliente cliente) throws SQLException, IOException, ClassNotFoundException {
        DAOPlanNutricional.verPlanesNutricionalesCliente(cliente);
    }

    public static String asignarPlanNutricional(Cliente cliente, PlanNutricional planNutricional) throws SQLException, IOException, ClassNotFoundException {
        planNutricional.setcorreoClienteAsignado(cliente.getCorreoElectronico());
        planNutricional.calcularIMC(cliente);
        return DAOPlanNutricional.asignarPlanNutricional(planNutricional);
    }
}