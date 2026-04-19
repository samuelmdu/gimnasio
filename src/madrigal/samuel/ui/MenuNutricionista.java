package madrigal.samuel.ui;

import madrigal.samuel.bl.entities.Cliente;
import madrigal.samuel.bl.entities.Nutricionista;
import madrigal.samuel.bl.entities.PlanNutricional;
import madrigal.samuel.bl.exceptions.NumeroInvalido;
import madrigal.samuel.dl.Controlador;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

public class MenuNutricionista {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void desplegar(Nutricionista nutricionista) throws IOException, SQLException, ClassNotFoundException {

        int opcionMenu = 0;

        do {
            System.out.println("=== MENÚ NUTRICIONISTA ===");
            System.out.println("Bienvenid@! " + nutricionista.getNombreCompleto());
            System.out.println("1. Crear plan nutricional");
            System.out.println("2. Ver planes nutricionales creados");
            System.out.println("3. Asignar plan nutricional a usuario");
            System.out.println("4. Cerrar sesión");
            System.out.print("Elija una opción: ");

            try {
                opcionMenu = Integer.parseInt(reader.readLine());
            } catch (NumberFormatException e) {
                throw new NumeroInvalido();
            }

            switch (opcionMenu) {

                case 1:
                    Controlador.registrarPlanNutricional(nutricionista);
                    break;

                case 2:
                    Controlador.verPlanesNutricionales(nutricionista);
                    break;

                case 3:
                    Cliente cliente = Controlador.buscarCliente();
                    if (cliente == null){
                        System.out.println("Error: No se encontró un cliente asociado al correo dado.");
                        break;
                    }

                    PlanNutricional planNutricional = Controlador.buscarPlanNutricional();
                    if (planNutricional == null){
                        System.out.println("Error: No se encontró un plan nutricional con ese id.");
                        break;
                    }

                    Controlador.asignarPlanNutricional(cliente, planNutricional);
                    break;

                case 4:
                    System.out.println("Cerrando sesión.");
                    break;

                default:
                    System.out.println("Opción inválida");
            }

        } while (opcionMenu != 4);
    }
}