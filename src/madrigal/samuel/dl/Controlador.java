package madrigal.samuel.dl;

import madrigal.samuel.bl.entities.*;
import madrigal.samuel.bl.exceptions.FechaInvalida;
import madrigal.samuel.bl.exceptions.NumeroInvalido;
import madrigal.samuel.bl.logic.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Controlador {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    /*
    === REGISTRAR (SIGN UP) ===
    */

    public static void registrarEntrenador() throws IOException, SQLException, ClassNotFoundException {

        int opcCrearEntrenador = 1;

        do {
            System.out.println("Ingrese el nombre del entrenador:");
            String nombreCompleto = reader.readLine();

            System.out.println("Ingrese el correo electrónico del entrenador:");
            String correoElectronico = reader.readLine();

            System.out.println("Ingrese la fecha de nacimiento (YYYY-MM-DD):");
            LocalDate fechaNacimiento;
            try {
                fechaNacimiento = LocalDate.parse(reader.readLine());
            } catch (DateTimeParseException e) {
                throw new FechaInvalida();
            }

            System.out.println("Ingrese la fecha de contratación (YYYY-MM-DD):");
            LocalDate fechaContratacion;
            try {
                fechaContratacion = LocalDate.parse(reader.readLine());
            } catch (DateTimeParseException e) {
                throw new FechaInvalida();
            }

            System.out.println("Ingrese la contraseña:");
            String contrasenna = reader.readLine();

            System.out.println(GestorEntrenador.registrarEntrenador(nombreCompleto, correoElectronico, fechaNacimiento, fechaContratacion, contrasenna));

            System.out.println("Desea crear otro entrenador? (1. Si 2. No)");
            try {
                opcCrearEntrenador = Integer.parseInt(reader.readLine());
            } catch (NumberFormatException e) {
                throw new NumeroInvalido();
            }

        } while (opcCrearEntrenador != 2);
    }

    public static void registrarNutricionista() throws IOException, SQLException, ClassNotFoundException {

        int opcCrearNutricionista = 1;

        do {
            System.out.println("Ingrese el nombre del nutricionista:");
            String nombreCompleto = reader.readLine();

            System.out.println("Ingrese el correo electrónico:");
            String correoElectronico = reader.readLine();

            System.out.println("Ingrese la fecha de nacimiento (YYYY-MM-DD):");
            LocalDate fechaNacimiento;
            try {
                fechaNacimiento = LocalDate.parse(reader.readLine());
            } catch (DateTimeParseException e) {
                throw new FechaInvalida();
            }

            System.out.println("Ingrese la fecha de contratación (YYYY-MM-DD):");
            LocalDate fechaContratacion;
            try {
                fechaContratacion = LocalDate.parse(reader.readLine());
            } catch (DateTimeParseException e) {
                throw new FechaInvalida();
            }

            System.out.println("Ingrese la contraseña:");
            String contrasenna = reader.readLine();

            System.out.println(GestorNutricionista.registrarNutricionista(nombreCompleto, correoElectronico, fechaNacimiento, fechaContratacion, contrasenna));

            System.out.println("Desea crear otro nutricionista? (1. Si 2. No)");
            try {
                opcCrearNutricionista = Integer.parseInt(reader.readLine());
            } catch (NumberFormatException e) {
                throw new NumeroInvalido();
            }

        } while (opcCrearNutricionista != 2);
    }

    public static void registrarRecepcionista() throws IOException, SQLException, ClassNotFoundException {

        int opcCrearRecepcionista = 1;

        do {
            System.out.println("Ingrese el nombre de la recepcionista:");
            String nombreCompleto = reader.readLine();

            System.out.println("Ingrese el correo electrónico:");
            String correoElectronico = reader.readLine();

            System.out.println("Ingrese la fecha de nacimiento (YYYY-MM-DD):");
            LocalDate fechaNacimiento;
            try {
                fechaNacimiento = LocalDate.parse(reader.readLine());
            } catch (DateTimeParseException e) {
                throw new FechaInvalida();
            }

            System.out.println("Ingrese la fecha de contratación (YYYY-MM-DD):");
            LocalDate fechaContratacion;
            try {
                fechaContratacion = LocalDate.parse(reader.readLine());
            } catch (DateTimeParseException e) {
                throw new FechaInvalida();
            }

            System.out.println("Ingrese la contraseña:");
            String contrasenna = reader.readLine();

            System.out.println(GestorRecepcionista.registrarRecepcionista(nombreCompleto, correoElectronico, fechaNacimiento, fechaContratacion, contrasenna));

            System.out.println("Desea crear otro recepcionista? (1. Si 2. No)");
            try {
                opcCrearRecepcionista = Integer.parseInt(reader.readLine());
            } catch (NumberFormatException e) {
                throw new NumeroInvalido();
            }

        } while (opcCrearRecepcionista != 2);
    }

    public static void registrarCliente() throws IOException, SQLException, ClassNotFoundException {

        int opcCrearCliente = 1;

        do {
            System.out.println("Ingrese el nombre del cliente:");
            String nombreCompleto = reader.readLine();

            System.out.println("Ingrese el correo electrónico:");
            String correoElectronico = reader.readLine();

            System.out.println("Ingrese la fecha de nacimiento (YYYY-MM-DD):");
            LocalDate fechaNacimiento;
            try {
                fechaNacimiento = LocalDate.parse(reader.readLine());
            } catch (DateTimeParseException e) {
                throw new FechaInvalida();
            }

            System.out.println("Ingrese su peso corporal en Kg:");
            double peso;
            try {
                peso = Double.parseDouble(reader.readLine());
            } catch (NumberFormatException e) {
                throw new NumeroInvalido();
            }

            System.out.println("Ingrese su altura en m:");
            double altura;
            try {
                altura = Double.parseDouble(reader.readLine());
            } catch (NumberFormatException e) {
                throw new NumeroInvalido();
            }

            System.out.println("Ingrese la contraseña:");
            String contrasenna = reader.readLine();

            System.out.println(GestorCliente.registrarCliente(nombreCompleto, correoElectronico, fechaNacimiento, peso, altura, contrasenna));

            System.out.println("Desea crear otro cliente? (1. Si 2. No)");
            try {
                opcCrearCliente = Integer.parseInt(reader.readLine());
            } catch (NumberFormatException e) {
                throw new NumeroInvalido();
            }

        } while (opcCrearCliente != 2);
    }

    public static void registrarRutina(Entrenador entrenador) throws IOException, SQLException, ClassNotFoundException {

        int opcCrearRutina = 1;

        do {
            System.out.println("Ingrese la fecha de inicio (YYYY-MM-DD):");
            LocalDate fechaInicio;
            try {
                fechaInicio = LocalDate.parse(reader.readLine());
            } catch (DateTimeParseException e) {
                throw new FechaInvalida();
            }

            System.out.println("Ingrese la fecha de cambio (YYYY-MM-DD):");
            LocalDate fechaCambio;
            try {
                fechaCambio = LocalDate.parse(reader.readLine());
            } catch (DateTimeParseException e) {
                throw new FechaInvalida();
            }

            System.out.println("Ingrese el objetivo:");
            String objetivo = reader.readLine();

            System.out.println("Ingrese el grupo muscular de la rutina:");
            String grupoMuscular = reader.readLine();

            System.out.println(GestorRutina.registrarRutina(entrenador, fechaInicio, fechaCambio, objetivo, grupoMuscular));

            System.out.println("Desea crear otra rutina? (1. Si 2. No)");
            try {
                opcCrearRutina = Integer.parseInt(reader.readLine());
            } catch (NumberFormatException e) {
                throw new NumeroInvalido();
            }

        } while (opcCrearRutina != 2);
    }

    public static void registrarPlanNutricional(Nutricionista nutricionista) throws IOException, SQLException, ClassNotFoundException {

        int opcCrearPlan = 1;

        do {
            System.out.println("Ingrese la fecha de inicio (YYYY-MM-DD):");
            LocalDate fechaInicio;
            try {
                fechaInicio = LocalDate.parse(reader.readLine());
            } catch (DateTimeParseException e) {
                throw new FechaInvalida();
            }

            System.out.println("Ingrese la fecha de cambio (YYYY-MM-DD):");
            LocalDate fechaCambio;
            try {
                fechaCambio = LocalDate.parse(reader.readLine());
            } catch (DateTimeParseException e) {
                throw new FechaInvalida();
            }

            System.out.println("Ingrese el objetivo:");
            String objetivo = reader.readLine();

            System.out.println(GestorPlanNutricional.registrarPlanNutricional(nutricionista, fechaInicio, fechaCambio, objetivo));

            System.out.println("Desea crear otro plan nutricional? (1. Si 2. No)");
            try {
                opcCrearPlan = Integer.parseInt(reader.readLine());
            } catch (NumberFormatException e) {
                throw new NumeroInvalido();
            }

        } while (opcCrearPlan != 2);
    }

    /*
    === INGRESAR (LOG IN) ===
    */

    public static Entrenador ingresarEntrenador() throws IOException, SQLException, ClassNotFoundException {
        System.out.println("=== INICIAR SESIÓN ===");

        System.out.println("Ingrese su correo electrónico:");
        String correoLogin = reader.readLine();

        System.out.println("Ingrese su contraseña:");
        String contrasennaLogin = reader.readLine();

        return GestorEntrenador.ingresarEntrenador(correoLogin, contrasennaLogin);
    }

    public static Nutricionista ingresarNutricionista() throws IOException, SQLException, ClassNotFoundException {
        System.out.println("=== INICIAR SESIÓN ===");

        System.out.println("Ingrese su correo electrónico:");
        String correoLogin = reader.readLine();

        System.out.println("Ingrese su contraseña:");
        String contrasennaLogin = reader.readLine();

        return GestorNutricionista.ingresarNutricionista(correoLogin, contrasennaLogin);
    }

    public static Recepcionista ingresarRecepcionista() throws IOException, SQLException, ClassNotFoundException {
        System.out.println("=== INICIAR SESIÓN ===");

        System.out.println("Ingrese su correo electrónico:");
        String correoLogin = reader.readLine();

        System.out.println("Ingrese su contraseña:");
        String contrasennaLogin = reader.readLine();

        return GestorRecepcionista.ingresarRecepcionista(correoLogin, contrasennaLogin);
    }

    public static Cliente ingresarCliente() throws IOException, SQLException, ClassNotFoundException {
        System.out.println("=== INICIAR SESIÓN ===");

        System.out.println("Ingrese su correo electrónico:");
        String correoLogin = reader.readLine();

        System.out.println("Ingrese su contraseña:");
        String contrasennaLogin = reader.readLine();

        return GestorCliente.ingresarCliente(correoLogin, contrasennaLogin);
    }

    /*
    === BUSCAR ===
    */

    public static Cliente buscarCliente() throws IOException, SQLException, ClassNotFoundException {
        System.out.println("=== BUSCAR CLIENTE ===");
        System.out.println("Ingrese el correo electrónico del cliente:");
        String correoBuscar = reader.readLine();

        return GestorCliente.ingresarCliente(correoBuscar);
    }

    public static PlanRutina buscarRutina() throws IOException, SQLException, ClassNotFoundException {
        System.out.println("=== BUSCAR RUTINA ===");
        System.out.println("Ingrese el id de la rutina a asignar:");
        try {
            int idRutina = Integer.parseInt(reader.readLine());
            return GestorRutina.buscarRutina(idRutina);
        } catch (NumberFormatException e) {
            throw new NumeroInvalido();
        }
    }

    public static PlanNutricional buscarPlanNutricional() throws IOException, SQLException, ClassNotFoundException {
        System.out.println("=== BUSCAR PLAN NUTRICIONAL ===");
        System.out.println("Ingrese el id del plan nutricional a asignar:");
        try {
            int idPlanNutricional = Integer.parseInt(reader.readLine());
            return GestorPlanNutricional.buscarPlanNutricional(idPlanNutricional);
        } catch (NumberFormatException e) {
            throw new NumeroInvalido();
        }
    }

    /*
    === IMPRIMIR ===
    */

    public static void verRutinas(Entrenador entrenador) throws SQLException, IOException, ClassNotFoundException {
        GestorRutina.verRutinas(entrenador);
    }

    public static void verPlanesNutricionales(Nutricionista nutricionista) throws SQLException, IOException, ClassNotFoundException {
        GestorPlanNutricional.verPlanesNutricionales(nutricionista);
    }

    public static void verRutinasCliente(Cliente cliente) throws SQLException, IOException, ClassNotFoundException {
        GestorRutina.verRutinasCliente(cliente);
    }

    public static void verPlanesNutricionalesCliente(Cliente cliente) throws SQLException, IOException, ClassNotFoundException {
        GestorPlanNutricional.verPlanesNutricionalesCliente(cliente);
    }

    /*
    === ASIGNAR ===
    */

    public static void asignarRutina(Cliente cliente, PlanRutina rutina) throws SQLException, IOException, ClassNotFoundException {
        System.out.println(GestorRutina.asignarRutina(cliente, rutina));
    }

    public static void asignarPlanNutricional(Cliente cliente, PlanNutricional planNutricional) throws SQLException, IOException, ClassNotFoundException {
        System.out.println(GestorPlanNutricional.asignarPlanNutricional(cliente, planNutricional));
    }

    /*
    === ACTUALIZAR ===
    */

    public static void actualizarMembresia(Cliente cliente) throws SQLException, IOException, ClassNotFoundException {
        GestorCliente.actualizarMembresia(cliente);
    }
}