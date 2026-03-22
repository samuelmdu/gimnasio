package ui;

import bl.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;

public class MenuPrincipal extends Menu {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static ArrayList<Entrenador> entrenadores = new ArrayList<>();
    static ArrayList<Recepcionista> recepcionistas = new ArrayList<>();
    static ArrayList<Nutricionista> nutricionistas = new ArrayList<>();
    static ArrayList<Cliente> clientes = new ArrayList<>();

    static ArrayList<PlanRutina> rutinas = new ArrayList<>();
    static ArrayList<PlanNutricional> planesNutricionales = new ArrayList<>();
    static ColaTickets colaTickets = new ColaTickets();

    public void desplegar() throws IOException {

        int opcionMenu = 0;

        Entrenador jason = new Entrenador("Jason" , "jason",  LocalDate.of(2000,10,17), LocalDate.of(2020,10,17) ,"123");
        entrenadores.add(jason);

        Entrenador romario = new Entrenador("Romario" , "romario",  LocalDate.of(2000,10,17), LocalDate.of(2020,10,17)  ,"123");
        entrenadores.add(romario);

        Cliente samuel = new Cliente("Samuel M", "samuel", LocalDate.of(2000,10,17), 90, 1.77, "123");
        clientes.add(samuel);

        Nutricionista melissa = new Nutricionista("Melissa", "meli" , LocalDate.of(2020,10,17), LocalDate.of(2001,10,17), "123");
        nutricionistas.add(melissa);

        Nutricionista gabriela = new Nutricionista("Gabi", "gabi" , LocalDate.of(2020,10,17), LocalDate.of(2001,10,17), "123");
        nutricionistas.add(gabriela);

        Recepcionista fabi = new Recepcionista("fabiana", "fabi", LocalDate.of(2000,10,17), LocalDate.of(2020,10,17), "123");
        recepcionistas.add(fabi);

        do {
            System.out.println("=== MENÚ PRINCIPAL ===");
            System.out.println("1. Registrar usuario ");
            System.out.println("2. Iniciar sesión ");
            System.out.println("3. Salir ");
            System.out.print("Elija una opción: ");
            System.out.println();

            opcionMenu = Integer.parseInt(reader.readLine());

            switch (opcionMenu) {

                case 1:
                    System.out.println("=== CREADOR USUARIOS ===");
                    System.out.println("1. Crear entrenador ");
                    System.out.println("2. Crear nutricionista ");
                    System.out.println("3. Crear recepcionista ");
                    System.out.println("4. Crear cliente ");
                    System.out.println("5. Volver al menu ");
                    System.out.print("Elija una opción: ");

                    int opcionCreadorUsuarios = Integer.parseInt(reader.readLine());

                    if (opcionCreadorUsuarios == 1){
                        crearEntrenador();
                        break;
                    } else if (opcionCreadorUsuarios == 2) {
                        crearNutricionista();
                        break;
                    } else if (opcionCreadorUsuarios == 3) {
                        crearRecepcionista();
                        break;
                    } else if (opcionCreadorUsuarios == 4){
                        crearCliente();
                        break;
                    } else if (opcionCreadorUsuarios == 5){
                        break;
                    }

                case 2:
                    if (entrenadores.isEmpty() && recepcionistas.isEmpty() && nutricionistas.isEmpty() && clientes.isEmpty()){
                        System.out.println("\nError: Lo sentimos, no hay usuarios registrados en el sistema.\n");
                        System.out.println();
                        break;
                    }
                    
                    System.out.println("=== INICIAR SESIÓN ===");

                    System.out.println("Ingrese su correo electrónico:");
                    String correoLogin = reader.readLine();

                    System.out.println("Ingrese su contraseña:");
                    String contrasennaLogin = reader.readLine();

                    boolean encontrado = false;

                    if(!encontrado){
                        for (int i = 0; i < entrenadores.size(); i++) {
                            Entrenador temp = entrenadores.get(i);
                            if (temp.getCorreoElectronico().equals(correoLogin) && temp.getContrasenna().equals(contrasennaLogin)) {

                                MenuEntrenador menuEntrenador = new MenuEntrenador();
                                menuEntrenador.desplegar(temp);
                                encontrado = true;

                                break;
                            }
                        }

                    }

                    if (!encontrado) {
                        for (int i = 0; i < nutricionistas.size(); i++) {
                            Nutricionista temp = nutricionistas.get(i);
                            if (temp.getCorreoElectronico().equals(correoLogin) && temp.getContrasenna().equals(contrasennaLogin)) {

                                MenuNutricionista menuNutricionista = new MenuNutricionista();
                                menuNutricionista.desplegar(temp);
                                encontrado = true;

                                break;
                            }
                        }
                    }

                    if (!encontrado) {
                        for (int i = 0; i < recepcionistas.size(); i++) {
                            Recepcionista temp = recepcionistas.get(i);
                            if (temp.getCorreoElectronico().equals(correoLogin) && temp.getContrasenna().equals(contrasennaLogin)) {

                                MenuRecepcionista menuRecepcionista = new MenuRecepcionista();
                                menuRecepcionista.desplegar(temp);
                                encontrado = true;

                                break;
                            }
                        }
                    }

                    if (!encontrado) {
                        for (int i = 0; i < clientes.size(); i++) {
                            Cliente temp = clientes.get(i);
                            if (temp.getCorreoElectronico().equals(correoLogin) && temp.getContrasenna().equals(contrasennaLogin)) {

                                MenuCliente menuCliente = new MenuCliente();
                                menuCliente.desplegar(temp);
                                encontrado = true;

                                break;
                            }
                        }
                    }

                    if (!encontrado) {
                        System.out.println("\nError: Correo electrónico o contraseña incorrectos.\n");
                    }

                    break;

                case 3:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción inválida");
            }

        } while (opcionMenu != 3);
    }
    public static void crearEntrenador() throws IOException {

        int opcCrearEntrenador = 1;

        do {

            System.out.println("Ingrese el nombre del entrenador:");
            String nombreCompleto = reader.readLine();

            System.out.println("Ingrese el correo electrónico:");
            String correoElectronico = reader.readLine();

            System.out.println("Ingrese la fecha de nacimiento (YYYY-MM-DD):");
            LocalDate fechaNacimiento = LocalDate.parse(reader.readLine());

            System.out.println("Ingrese la fecha de contratación (YYYY-MM-DD):");
            LocalDate fechaContratacion = LocalDate.parse(reader.readLine());

            System.out.println("Ingrese la contraseña:");
            String contrasenna = reader.readLine();

            System.out.println("Desea crear otro entrenador? (1. Si 2. No)");

            opcCrearEntrenador = Integer.parseInt(reader.readLine());

            Entrenador nuevoEntrenador = new Entrenador(nombreCompleto, correoElectronico, fechaNacimiento, fechaContratacion, contrasenna);

            boolean usuarioDuplicado = false;

            for (int i = 0; i < entrenadores.size(); i++) {

                Entrenador temp = entrenadores.get(i);

                if (temp.getCorreoElectronico().equalsIgnoreCase(nuevoEntrenador.getCorreoElectronico())){
                    System.out.println("\nError: El correo electronico especificado pertenece a un usuario registrado.\n");
                    usuarioDuplicado = true;
                    break;
                }
            }

            if (!usuarioDuplicado){
                System.out.println("El usuario fue registrado correctamente.");
                entrenadores.add(nuevoEntrenador);
            }


        } while (opcCrearEntrenador != 2);

    }

    public static void crearRecepcionista() throws IOException {

        int opcCrearRecepcionista = 1;

        do {
            System.out.println("Ingrese el nombre de la recepcionista:");
            String nombreCompletoRecepcionista = reader.readLine();

            System.out.println("Ingrese el correo electrónico:");
            String correoElectronicoRecepcionista = reader.readLine();

            System.out.println("Ingrese la fecha de nacimiento (YYYY-MM-DD):");
            LocalDate fechaNacimientoRecepcionista = LocalDate.parse(reader.readLine());

            System.out.println("Ingrese la fecha de contratación (YYYY-MM-DD):");
            LocalDate fechaContratacionRecepcionista = LocalDate.parse(reader.readLine());

            System.out.println("Ingrese la contraseña:");
            String contrasennaRecepcionista = reader.readLine();

            System.out.println("Desea crear otro recepcionista? (1. Si 2. No)");
            opcCrearRecepcionista = Integer.parseInt(reader.readLine());

            Recepcionista nuevaRecepcionista = new Recepcionista(nombreCompletoRecepcionista, correoElectronicoRecepcionista, fechaNacimientoRecepcionista, fechaContratacionRecepcionista, contrasennaRecepcionista);

            boolean usuarioDuplicado = false;

            for (int i = 0; i < recepcionistas.size(); i++) {

                Recepcionista temp = recepcionistas.get(i);

                if (temp.getCorreoElectronico().equalsIgnoreCase(nuevaRecepcionista.getCorreoElectronico())){
                    System.out.println("\nError: El correo electronico especificado pertenece a un usuario registrado.\n");
                    usuarioDuplicado = true;
                    break;
                }
            }

            if (!usuarioDuplicado){
                System.out.println("El usuario fue registrado correctamente.");
                recepcionistas.add(nuevaRecepcionista);
            }


        } while (opcCrearRecepcionista != 2);
    }

    public static void crearNutricionista() throws IOException {

        int opcCrearNutricionista = 1;

        do {
            System.out.println("Ingrese el nombre del nutricionista:");
            String nombreCompletoNutricionista = reader.readLine();

            System.out.println("Ingrese el correo electrónico:");
            String correoElectronicoNutricionista = reader.readLine();

            System.out.println("Ingrese la fecha de nacimiento (YYYY-MM-DD):");
            LocalDate fechaNacimientoNutricionista = LocalDate.parse(reader.readLine());

            System.out.println("Ingrese la fecha de contratación (YYYY-MM-DD):");
            LocalDate fechaContratacionNutricionista = LocalDate.parse(reader.readLine());

            System.out.println("Ingrese la contraseña:");
            String contrasennaNutricionista = reader.readLine();

            System.out.println("Desea crear otro nutricionista? (1. Si 2. No)");
            opcCrearNutricionista = Integer.parseInt(reader.readLine());

            Nutricionista nuevoNutricionista = new Nutricionista(nombreCompletoNutricionista, correoElectronicoNutricionista, fechaNacimientoNutricionista, fechaContratacionNutricionista, contrasennaNutricionista);

            boolean usuarioDuplicado = false;

            for (int i = 0; i < nutricionistas.size(); i++) {

                Nutricionista temp = nutricionistas.get(i);

                if (temp.getCorreoElectronico().equalsIgnoreCase(nuevoNutricionista.getCorreoElectronico())){
                    System.out.println("\nError: El correo electronico especificado pertenece a un usuario registrado.\n");
                    usuarioDuplicado = true;
                    break;
                }
            }

            if (!usuarioDuplicado){
                System.out.println("El usuario fue registrado correctamente.");
                nutricionistas.add(nuevoNutricionista);
            }

        } while (opcCrearNutricionista != 2);
    }

    public static void crearCliente() throws IOException {

        int opcCrearCliente = 1;

        do {
            System.out.println("Ingrese el nombre del cliente:");
            String nombreCompleto = reader.readLine();

            System.out.println("Ingrese el correo electrónico:");
            String correoElectronico = reader.readLine();

            System.out.println("Ingrese la fecha de nacimiento (YYYY-MM-DD):");
            LocalDate fechaNacimiento = LocalDate.parse(reader.readLine());

            System.out.println("Ingrese su peso corporal en Kg:");
            double peso = Double.parseDouble(reader.readLine());

            System.out.println("Ingrese su altura en m:");
            double altura = Double.parseDouble(reader.readLine());

            System.out.println("Ingrese la contraseña:");
            String contrasenna = reader.readLine();

            System.out.println("Desea crear otro cliente? (1. Si 2. No)");
            opcCrearCliente = Integer.parseInt(reader.readLine());

            Cliente nuevoCliente = new Cliente(nombreCompleto, correoElectronico, fechaNacimiento, peso, altura, contrasenna);

            boolean usuarioDuplicado = false;

            for (int i = 0; i < clientes.size(); i++) {

                Cliente temp = clientes.get(i);

                if (temp.getCorreoElectronico().equalsIgnoreCase(nuevoCliente.getCorreoElectronico())){
                    System.out.println("\nError: El correo electronico especificado pertenece a un usuario registrado.\n");
                    usuarioDuplicado = true;
                    break;
                }
            }

            if (!usuarioDuplicado){
                System.out.println("El usuario fue registrado correctamente.");
                clientes.add(nuevoCliente);
            }

        } while (opcCrearCliente != 2);
    }
}
