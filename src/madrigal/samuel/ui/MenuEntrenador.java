package madrigal.samuel.ui;

import madrigal.samuel.bl.entities.Cliente;
import madrigal.samuel.bl.entities.Entrenador;
import madrigal.samuel.bl.entities.PlanRutina;
import madrigal.samuel.bl.exceptions.NumeroInvalido;
import madrigal.samuel.dl.Controlador;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

public class MenuEntrenador {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void desplegar(Entrenador entrenador) throws IOException, SQLException, ClassNotFoundException {

        int opcionMenu = 0;

        do {
            System.out.println("=== MENÚ ENTRENADOR ===");
            System.out.println("Bienvenid@! " + entrenador.getNombreCompleto());
            System.out.println("1. Crear rutina ");
            System.out.println("2. Ver rutinas creadas");
            System.out.println("3. Asignar rutina a usuario");
            System.out.println("4. Cerrar sesión ");
            System.out.print("Elija una opción: ");

            try {
                opcionMenu = Integer.parseInt(reader.readLine());
            } catch (NumberFormatException e) {
                throw new NumeroInvalido();
            }

            switch (opcionMenu) {

                case 1:
                    Controlador.registrarRutina(entrenador);
                    break;

                case 2:
                    Controlador.verRutinas(entrenador);
                    break;

                case 3:
                    Cliente cliente = Controlador.buscarCliente();
                    if (cliente == null){
                        System.out.println("Error: No se encontró un cliente asociado al correo dado.");
                        break;
                    }

                    PlanRutina rutina = Controlador.buscarRutina();
                    if (rutina == null){
                        System.out.println("Error: No se encontró una rutina con ese id.");
                        break;
                    }

                    Controlador.asignarRutina(cliente, rutina);
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