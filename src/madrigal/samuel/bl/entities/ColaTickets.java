package madrigal.samuel.bl.entities;

import java.util.ArrayList;

public class ColaTickets {

    private ArrayList<Ticket> colaTickets;

    public ColaTickets(){
        colaTickets = new ArrayList<>();
    }

    public void insertar(Ticket ticket){

        colaTickets.add(ticket);

    }

    public Ticket remover(){
        if (colaTickets.isEmpty()){
            System.out.println("Lo sentimos, ningún ticket se encuentra en la cola.");
            return null;
        }
        return colaTickets.removeFirst();
    }

    public Ticket verFrente(){
        if (colaTickets.isEmpty()){
            System.out.println("Lo sentimos, ningún ticket se encuentra en la cola.");
            return null;
        }
        return colaTickets.getFirst();
    }
}
