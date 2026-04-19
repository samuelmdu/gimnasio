package madrigal.samuel.ui;

import madrigal.samuel.bl.entities.Cliente;
import madrigal.samuel.bl.entities.Membresia;
import madrigal.samuel.bl.entities.Recepcionista;
import madrigal.samuel.bl.exceptions.NumeroInvalido;
import madrigal.samuel.dl.Controlador;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.time.LocalDate;

public class MenuRecepcionista {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void desplegar(Recepcionista recepcionista) throws IOException, SQLException, ClassNotFoundException {

        int opcionMenu = 0;

        do {
            System.out.println("=== MENÚ RECEPCIONISTA ===");
            System.out.println("Bienvenid@! " + recepcionista.getNombreCompleto());
            System.out.println("1. Revisar la solicitud de membresia más reciente");
            System.out.println("2. Cerrar sesión ");
            System.out.print("Elija una opción: ");

            try {
                opcionMenu = Integer.parseInt(reader.readLine());
            } catch (NumberFormatException e) {
                throw new NumeroInvalido();
            }

            switch (opcionMenu) {

                case 1:
                    revisarSolicitud();
                    break;

                case 2:
                    System.out.println("Cerrando sesión...");
                    break;

                default:
                    System.out.println("Opción inválida");
            }

        } while (opcionMenu != 2);
    }

    public static void revisarSolicitud() throws IOException, SQLException, ClassNotFoundException {
        int opcionSolicitud = 0;

        if(MenuPrincipal.colaTickets.verFrente() == null) {
            System.out.println("\nError: no se encontraron tickets abiertos\n");
            return;
        }

        System.out.println(MenuPrincipal.colaTickets.verFrente());

        System.out.println("");
        System.out.println("Ingrese una de las siguientes opciones: (1. Aceptar 2. Rechazar)");

        try {
            opcionSolicitud = Integer.parseInt(reader.readLine());
        } catch (NumberFormatException e) {
            throw new NumeroInvalido();
        }

        Cliente cliente = MenuPrincipal.colaTickets.verFrente().getClienteCreador();

        if (opcionSolicitud == 1){
            cliente.setMembresia(new Membresia(LocalDate.now().plusMonths(1)));
            Controlador.actualizarMembresia(cliente);
            System.out.println("La membresia de " + cliente.getNombreCompleto() + " ahora se encuentra activa.");
            MenuPrincipal.colaTickets.remover();
            System.out.println(cliente);

        } else {
            cliente.setMembresia(null);
            Controlador.actualizarMembresia(cliente);
            System.out.println("La membresia de " + cliente.getNombreCompleto() + " ha sido rechazada.");
            MenuPrincipal.colaTickets.remover();
        }
    }
}