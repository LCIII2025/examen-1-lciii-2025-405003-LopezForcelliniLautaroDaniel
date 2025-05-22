package org.example.parking;

import static org.junit.Assert.assertNotNull;

import org.example.parking.Vehiculo.Tipo;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class EstacionamientoTest {

    @Test
    public void testRetirarVehiculo() throws Exception {
        Estacionamiento estacionamiento = new Estacionamiento();
        Ticket ticket = estacionamiento.retirarVehiculo("4278");
        assertNotNull(ticket);
    }

    @Test
    public void testCalcularPrecio() throws Exception {
        Cliente cliente = new Cliente("42484023", "Lautaro");
        Vehiculo vehiculo = new Vehiculo("4278", "2000", Tipo.AUTO);
        Ticket ticket = new Ticket(cliente, vehiculo);
        ticket.marcarSalida();

        Double precio = ticket.calcularPrecio();
        assertNotNull(precio);

    }

}