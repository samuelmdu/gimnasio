package madrigal.samuel.ui;

import madrigal.samuel.bl.entities.Cliente;
import madrigal.samuel.bl.entities.Ticket;
import madrigal.samuel.bl.exceptions.NumeroInvalido;
import madrigal.samuel.dl.Controlador;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

public class MenuCliente{

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void desplegar(Cliente cliente) throws IOException, SQLException, ClassNotFoundException {

        int opcionMenu = 0;
        boolean solicitudEnviada = false;

        do {
            System.out.println("=== MENÚ ===");
            System.out.println("Bienvenid@! " + cliente.getNombreCompleto());
            System.out.println("1. Pagar membresia ");
            System.out.println("2. Revisar mi membresia ");
            System.out.println("3. Revisar rutinas ");
            System.out.println("4. Revisar planes de nutrición");
            System.out.println("5. Ingresar al gimnasio");
            System.out.println("6. Cerrar sesión ");
            System.out.print("Elija una opción: ");

            try {
                opcionMenu = Integer.parseInt(reader.readLine());
            } catch (NumberFormatException e) {
                throw new NumeroInvalido();
            }

            switch (opcionMenu) {

                case 1:
                    if (solicitudEnviada){
                        System.out.println("\nError: Lo sentimos, su ticket se encuentra en revisión.\n");
                        break;
                    }

                    if (cliente.getMembresia() != null){
                        System.out.println("\nError: Usted ya cuenta con una membresia activa.\n");
                        break;
                    }

                    Ticket nuevoTicket = new Ticket(cliente);
                    cliente.pagarMembresia(nuevoTicket);
                    MenuPrincipal.colaTickets.insertar(nuevoTicket);
                    System.out.println("Ticket creado correctamente.");
                    System.out.println("Contacte a su recepcionista para más información");

                    solicitudEnviada = true;
                    break;

                case 2:
                    if (cliente.getMembresia() == null){
                        System.out.println("\nError: Usted no cuenta con una membresia activa.\n");
                        break;
                    }

                    System.out.println(cliente.getMembresia());
                    break;

                case 3:
                    if (cliente.getMembresia() == null){
                        System.out.println("\nError: Usted no cuenta con una membresia activa.\n");
                        break;
                    }

                    Controlador.verRutinasCliente(cliente);
                    break;

                case 4:
                    if (cliente.getMembresia() == null){
                        System.out.println("\nError: Usted no cuenta con una membresia activa.\n");
                        break;
                    }

                    Controlador.verPlanesNutricionalesCliente(cliente);
                    break;

                case 5:
                    if (cliente.getMembresia() != null){
                        if (cliente.getMembresia().isActiva()){
                            System.out.println("Bienvenido al gimnasio " + cliente.getNombreCompleto());
                        }
                    } else {
                        System.out.println("\nError: hay un problema con su mensualidad.\n");
                    }
                    break;

                case 6:
                    System.out.println("Cerrando sesión...");
                    break;

                default:
                    System.out.println("Opción inválida");
            }

        } while (opcionMenu != 6);
    }
}