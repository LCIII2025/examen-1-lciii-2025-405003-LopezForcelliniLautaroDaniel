package org.example.parking;

import java.util.*;

public class Estacionamiento {
    private final int capacidadMaxima = 50;
    private final Map<String, Ticket> vehiculosEstacionados = new HashMap<>();
    private final Map<String, Cliente> clientesRegistrados = new HashMap<>();

    public boolean ingresarVehiculo(String dni, String nombre, Vehiculo vehiculo) {

        Cliente cliente;
        if (vehiculosEstacionados.size() >= capacidadMaxima) {
            return false;
        }
        if (vehiculosEstacionados.containsKey(vehiculo.getPatente())) {
            return false;
        }

        if(clientesRegistrados.containsKey(dni)){
            cliente = clientesRegistrados.get(dni);
            cliente.getVehiculos().add(vehiculo);
        } 
        else {
            cliente = new Cliente(dni, nombre);
            clientesRegistrados.put(dni, cliente);
        }
        Ticket ticket = new Ticket(cliente, vehiculo);
        vehiculosEstacionados.put(vehiculo.getPatente(), ticket);

        return true;
    } 

    public Ticket retirarVehiculo(String patente) throws Exception {

        if(!vehiculosEstacionados.containsKey(patente)){
            throw new Exception("Vehiculo no encontrado");
        }
        Ticket ticket = vehiculosEstacionados.get(patente);
        ticket.marcarSalida();

        vehiculosEstacionados.remove(patente);
        return ticket;
    }

    public List<Ticket> listarVehiculosEstacionados() {
        return new ArrayList<>(vehiculosEstacionados.values());
    }
}
