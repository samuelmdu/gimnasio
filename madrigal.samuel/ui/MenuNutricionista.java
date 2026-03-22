package ui;

import bl.Cliente;
import bl.Nutricionista;
import bl.PlanNutricional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;

public class MenuNutricionista extends Menu{

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public void desplegar(Nutricionista nutricionista) throws IOException {

        // Filtrar solo los planes del nutricionista actual
        ArrayList<PlanNutricional> planesDelNutricionista = new ArrayList<>();
        for (int i = 0; i < MenuPrincipal.planesNutricionales.size(); i++) {
            if (MenuPrincipal.planesNutricionales.get(i).getCreador().equals(nutricionista.getNombreCompleto())) {
                planesDelNutricionista.add(MenuPrincipal.planesNutricionales.get(i));
            }
        }

        int opcionMenu = 0;

        do {
            System.out.println("=== MENÚ NUTRICIONISTA ===");
            System.out.println("Bienvenid@! " + nutricionista.getNombreCompleto());
            System.out.println("1. Crear plan de nutrición ");
            System.out.println("2. Ver planes creados ");
            System.out.println("3. Asignar plan a usuario");
            System.out.println("4. Marcar dia trabajado");
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

                    PlanNutricional nuevoPlanNutricional = new PlanNutricional(fechaInicio, fechaCambio, objetivo);
                    nuevoPlanNutricional.setCreador(nutricionista.getNombreCompleto());
                    MenuPrincipal.planesNutricionales.add(nuevoPlanNutricional);
                    planesDelNutricionista.add(nuevoPlanNutricional);
                    System.out.println("Plan de nutrición creado correctamente");
                    break;

                case 2:
                    if (planesDelNutricionista.isEmpty()){
                        System.out.println("\nError: no se encontraron planes nutricionales registrados en el sistema.\n");
                        break;
                    }
                    System.out.println(planesDelNutricionista);
                    System.out.println("");
                    break;

                case 3:
                    if (MenuPrincipal.clientes.isEmpty()){
                        System.out.println("\nError: no se encontraron clientes registrados en el sistema.\n");
                        break;
                    }

                    if (planesDelNutricionista.isEmpty()){
                        System.out.println("\nError: no se encontraron planes nutricionales registrados en el sistema.\n");
                        break;
                    }

                    PlanNutricional planNutricionAsignar = null;

                    System.out.println(planesDelNutricionista);
                    System.out.println("");

                    System.out.println("Ingrese el id del plan de nutrición a seleccionar: ");
                    int planSeleccion = Integer.parseInt(reader.readLine());

                    boolean planNutricionEncontrado = false;
                    boolean clienteEncontrado = false;

                    for (int j = 0; j < planesDelNutricionista.size(); j++) {
                        PlanNutricional tempPlanNutricional = planesDelNutricionista.get(j);
                        if (tempPlanNutricional.getIdPlanNutricional() == planSeleccion){
                            planNutricionEncontrado = true;
                            planNutricionAsignar = tempPlanNutricional;
                            break;
                        }
                    }

                    if (!planNutricionEncontrado){
                        System.out.println("Error: lo sentimos el plan de nutrición no fue encontrado, intente de nuevo.");
                        break;
                    }

                    System.out.println("Ingrese el nombre del cliente para asignar el plan: ");
                    String nombreBuscar = reader.readLine();

                    for (int i = 0; i < MenuPrincipal.clientes.size(); i++) {
                        Cliente tempCliente = MenuPrincipal.clientes.get(i);
                        if (nombreBuscar.equalsIgnoreCase(tempCliente.getNombreCompleto())){
                            planNutricionAsignar.calcularIMC(tempCliente);
                            tempCliente.annadirPlanes(planNutricionAsignar);
                            System.out.println("Plan nutricional asignado correctamente a " + tempCliente.getNombreCompleto());
                            clienteEncontrado = true;
                            break;
                        }
                    }

                    if (!clienteEncontrado){
                        System.out.println("Error: lo sentimos el cliente no fue encontrado, intente de nuevo.");
                    }

                    break;

                case 4:
                    nutricionista.marcar();
                    break;

                case 5:
                    System.out.println("Cerrando sesión...");
                    break;

                default:
                    System.out.println("Opción inválida");
            }

        } while (opcionMenu != 5);
    }
}