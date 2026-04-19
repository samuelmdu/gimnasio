package madrigal.samuel.ui;

import madrigal.samuel.bl.entities.*;
import madrigal.samuel.bl.exceptions.NumeroInvalido;
import madrigal.samuel.dl.Controlador;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

public class MenuPrincipal {

    public static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static Entrenador entrenadorActual = null;
    private static Nutricionista nutricionistaActual = null;
    private static Recepcionista recepcionistaActual = null;
    private static Cliente clienteActual = null;

    static ColaTickets colaTickets = new ColaTickets();

    public static void desplegar() throws IOException, SQLException, ClassNotFoundException {

        int opcionMenu = 0;

        do {
            System.out.println("=== MENÚ PRINCIPAL ===");
            System.out.println("1. Registrar usuario ");
            System.out.println("2. Iniciar sesión ");
            System.out.println("3. Salir ");
            System.out.print("Elija una opción: ");
            System.out.println();

            try {
                opcionMenu = Integer.parseInt(reader.readLine());
            } catch (NumberFormatException e) {
                throw new NumeroInvalido();
            }

            switch (opcionMenu) {

                case 1:
                    registrarUsuarios();
                    break;
                case 2:
                    iniciarSesion();
                    break;
                case 3:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        } while (opcionMenu != 3);
    }

    public static void registrarUsuarios() throws SQLException, IOException, ClassNotFoundException {

        int opcionCreadorUsuarios = 0;

        System.out.println("=== CREADOR USUARIOS ===");
        System.out.println("1. Crear entrenador ");
        System.out.println("2. Crear nutricionista ");
        System.out.println("3. Crear recepcionista ");
        System.out.println("4. Crear cliente ");
        System.out.println("5. Volver al menu principal ");
        System.out.print("Elija una opción: ");

        try {
            opcionCreadorUsuarios = Integer.parseInt(reader.readLine());
        } catch (NumberFormatException e) {
            throw new NumeroInvalido();
        }

        switch (opcionCreadorUsuarios) {
            case 1:
                Controlador.registrarEntrenador();
                break;
            case 2:
                Controlador.registrarNutricionista();
                break;
            case 3:
                Controlador.registrarRecepcionista();
                break;
            case 4:
                Controlador.registrarCliente();
                break;
            case 5:
                System.out.println("Volviendo al menu...");
                break;
            default:
                System.out.println("Opción no válida.");
                break;
        }
    }

    public static void iniciarSesion() throws SQLException, IOException, ClassNotFoundException {

        int opcionCuenta = 0;

        System.out.println("=== INICIAR SESIÓN ===");
        System.out.println("1. Iniciar sesión entrenador ");
        System.out.println("2. Iniciar sesión nutricionista ");
        System.out.println("3. Iniciar sesión recepcionista ");
        System.out.println("4. Iniciar sesión cliente ");
        System.out.println("5. Volver al menu principal ");
        System.out.println("Ingrese el tipo de cuenta con la que ingresar: ");

        try {
            opcionCuenta = Integer.parseInt(reader.readLine());
        } catch (NumberFormatException e) {
            throw new NumeroInvalido();
        }

        switch (opcionCuenta) {
            case 1:
                Entrenador entrenador = Controlador.ingresarEntrenador();
                if (entrenador == null){
                    System.out.println("Autenticación Invalida");
                    break;
                }
                entrenadorActual = entrenador;
                MenuEntrenador.desplegar(entrenadorActual);
                break;

            case 2:
                Nutricionista nutricionista = Controlador.ingresarNutricionista();
                if (nutricionista == null){
                    System.out.println("Autenticación Invalida");
                    break;
                }
                nutricionistaActual = nutricionista;
                MenuNutricionista.desplegar(nutricionistaActual);
                break;

            case 3:
                Recepcionista recepcionista = Controlador.ingresarRecepcionista();
                if (recepcionista == null){
                    System.out.println("Autenticación Invalida");
                    break;
                }
                recepcionistaActual = recepcionista;
                MenuRecepcionista.desplegar(recepcionistaActual);
                break;

            case 4:
                Cliente cliente = Controlador.ingresarCliente();
                if (cliente == null){
                    System.out.println("Autenticación Invalida");
                    break;
                }
                clienteActual = cliente;
                MenuCliente.desplegar(clienteActual);
                break;

            case 5:
                System.out.println("Volviendo al menu...");
                break;

            default:
                System.out.println("Opción no válida.");
                break;
        }
    }
}