package ui;

import bl.Cliente;
import bl.Membresia;
import bl.Recepcionista;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;

public class MenuRecepcionista extends Menu{

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public void desplegar(Recepcionista recepcionista)throws IOException {

        int opcionMenu = 0;

        do {
            System.out.println("=== MENÚ RECEPCIONISTA ===");
            System.out.println("Bienvenid@! " + recepcionista.getNombreCompleto());
            System.out.println("1. Revisar la solicitud de membresia más reciente");
            System.out.println("2. Marcar dia trabajado");
            System.out.println("3. Cerrar sesión ");
            System.out.print("Elija una opción: ");

            opcionMenu = Integer.parseInt(reader.readLine());

            switch (opcionMenu) {

                case 1:

                    int opcionSolicitud = 0;

                    if(MenuPrincipal.colaTickets.verFrente() == null) {
                        System.out.println("\nError: no se encontraron tickets abiertos\n");
                        break;
                    }

                    System.out.println(MenuPrincipal.colaTickets.verFrente());;

                    System.out.println("");
                    System.out.println("Ingrese una de las siguientes opciones: (1. Aceptar 2. Rechazar)");
                    opcionSolicitud = Integer.parseInt(reader.readLine());

                    Cliente cliente = MenuPrincipal.colaTickets.verFrente().getClienteCreador();

                    if (opcionSolicitud == 1){

                        Membresia nuevaMembresia = new Membresia(LocalDate.now().plusMonths(1));
                        cliente.setMembresia(nuevaMembresia);
                        System.out.println("La membresia de " + cliente.getNombreCompleto() + " ahora se encuentra activa.");
                        MenuPrincipal.colaTickets.remover();

                    } else {
                        System.out.println("La membresia de " + cliente.getNombreCompleto() + " ha sido rechazada.");

                        MenuPrincipal.colaTickets.remover();
                    }
                    break;

                case 2:
                    recepcionista.marcar();
                    break;

                case 3:
                    System.out.println("Cerrando sesión...");
                    break;

                default:
                    System.out.println("Opción inválida");
            }

        } while (opcionMenu != 3);
    }
}
