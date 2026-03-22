package bl;

import java.time.LocalDate;

public class Ticket {
    private static int cantidad = 0;
    private int idTicket;
    private Cliente clienteCreador;
    private String nombreCreador;
    private LocalDate fechaCreacion;
    private boolean pago;

    public Ticket(Cliente cliente) {
        this.idTicket = ++cantidad;
        this.nombreCreador = cliente.getNombreCompleto();
        clienteCreador = cliente;
        this.fechaCreacion = LocalDate.now();
        this.pago = false;
    }

    public int getId() {
        return idTicket;
    }

    public String getNombreCreador() {
        return nombreCreador;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public Cliente getClienteCreador() {
        return clienteCreador;
    }

    public boolean isPago() {
        return pago;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }

    @Override
    public String toString() {
        return "Ticket:" +
                "\nID               : " + getId() +
                "\nNombre Completo  : " + nombreCreador +
                "\nFecha Creación   : " + fechaCreacion +
                "\nbl.Membresia paga   : " + isPago() ;
    }
}
