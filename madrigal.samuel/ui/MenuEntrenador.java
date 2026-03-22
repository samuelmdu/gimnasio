package ui;

import bl.Cliente;
import bl.Entrenador;
import bl.PlanRutina;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;

public class MenuEntrenador extends Menu {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public void desplegar(Entrenador entrenador) throws IOException {


        // Filtro para obtener solo las rutinas del entrenador actual
        ArrayList<PlanRutina> rutinasDelEntrenador = new ArrayList<>();
        for (int i = 0; i < MenuPrincipal.rutinas.size(); i++) {
            if (MenuPrincipal.rutinas.get(i).getCreador().equals(entrenador.getNombreCompleto())) {
                rutinasDelEntrenador.add(MenuPrincipal.rutinas.get(i));
            }
        }

        int opcionMenu = 0;

        do {
            System.out.println("=== MENÚ ENTRENADOR ===");
            System.out.println("Bienvenid@! " + entrenador.getNombreCompleto());
            System.out.println("1. Crear rutina ");
            System.out.println("2. Ver rutinas creadas");
            System.out.println("3. Asignar rutina a usuario");
            System.out.println("4. Marcar  dia trabajado");
            System.out.println("5. Cerrar sesión ");
            System.out.print("Elija una opción: ");

            opcionMenu = Integer.parseInt(reader.readLine());

            switch (opcionMenu) {

                case 1:
                    System.out.println("Ingrese la fecha de inicio (YYYY-MM-DD):");
                    LocalDate fechaInicio = LocalDate.parse(reader.readLine());

                    System.out.println("Ingrese la fecha de cambio (YYYY-MM-DD):");
                    LocalDate fechaCambio = LocalDate.parse(reader.readLine());

                    System.out.println("Ingrese el objetivo:");
                    String objetivo = reader.readLine();

                    System.out.println("Ingrese el grupo muscular de la rutina:");
                    String grupoMuscular = reader.readLine();

                    int opcEjercicio = 0;

                    PlanRutina nuevaRutina = new PlanRutina(fechaInicio, fechaCambio, objetivo, grupoMuscular);
                    nuevaRutina.setCreador(entrenador.getNombreCompleto());
                    MenuPrincipal.rutinas.add(nuevaRutina);
                    rutinasDelEntrenador.add(nuevaRutina);

                    do {

                        System.out.println("Ingrese el ejercicio a insertar:");
                        String ejercicio = reader.readLine();
                        nuevaRutina.agregarEjercicio(ejercicio);

                        System.out.println("Desea ingresar otro ejercicio (1. Si 2. No):");
                        opcEjercicio = Integer.parseInt(reader.readLine());


                    } while (opcEjercicio != 2);
                    System.out.println("Rutina creada correctamente");

                    break;

                case 2:
                    if (rutinasDelEntrenador.isEmpty()){
                        System.out.println("\nError: no se encontraron rutinas registradas en el sistema.\n");
                        break;
                    }
                    System.out.println(rutinasDelEntrenador);
                    System.out.println("");
                    break;
                case 3:
                    if (MenuPrincipal.clientes.isEmpty() || rutinasDelEntrenador.isEmpty()){
                        System.out.println("\nError: no se encontraron clientes o rutinas registrados en el sistema.\n");
                        break;
                    }

                    PlanRutina rutinaAsignar = null;

                    System.out.println(rutinasDelEntrenador);
                    System.out.println("");

                    System.out.println("Ingrese el id de la rutina a seleccionar: ");
                    int rutinaSeleccion = Integer.parseInt(reader.readLine());

                    boolean rutinaEncontrada = false;
                    boolean clienteEncontrado = false;

                    for (int j = 0; j < rutinasDelEntrenador.size(); j++) {
                        PlanRutina tempRutina = rutinasDelEntrenador.get(j);
                        if (tempRutina.getIdRutina() == rutinaSeleccion){

                            rutinaEncontrada = true;
                            rutinaAsignar = tempRutina;
                            break;
                        }
                    }

                    if (!rutinaEncontrada){
                        System.out.println("Error: lo sentimos la rutina no fue encontrada, intente de nuevo.");
                        break;
                    }

                    System.out.println("Ingrese el nombre del cliente para asignar la rutina: ");
                    String nombreBuscar = reader.readLine();

                    for (int i = 0; i < MenuPrincipal.clientes.size(); i++) {
                        Cliente tempCliente = MenuPrincipal.clientes.get(i);
                        if (nombreBuscar.equalsIgnoreCase(tempCliente.getNombreCompleto())){

                            tempCliente.annadirPlanes(rutinaAsignar);
                            System.out.println("Rutina de " + rutinaAsignar.getGrupoMuscular() + " asignada correctamente a " + tempCliente.getNombreCompleto());
                            clienteEncontrado = true;
                            break;

                        }
                    }

                    if (!clienteEncontrado){
                        System.out.println("Error: lo sentimos el cliente no fue encontrado, intente de nuevo.");
                    }

                    break;

                case 4:
                    entrenador.marcar();

                    break;

                case 5:
                    MenuPrincipal menuPrincipal = new MenuPrincipal();
                    menuPrincipal.desplegar();

                    break;


                default:
                    System.out.println("Opción inválida");
            }

        } while (opcionMenu != 5);
    }
}
