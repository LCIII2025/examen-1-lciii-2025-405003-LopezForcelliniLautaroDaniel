package org.example.parking;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Random;

@Data
@AllArgsConstructor
public class Ticket {
    private final Cliente cliente;
    private final Vehiculo vehiculo;
    private final LocalDateTime horaEntrada;
    private LocalDateTime horaSalida;

    public Ticket(Cliente cliente, Vehiculo vehiculo) {
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.horaEntrada = LocalDateTime.now();
    }

    public void marcarSalida() {
        Random random = new Random();
        this.horaSalida = LocalDateTime.now().plusMinutes(random.nextInt(200)+1);
    }

    public long calcularMinutos() {
        return Duration.between(horaEntrada, horaSalida).toMinutes();
    }

    public double calcularPrecio() {
        long minutos = calcularMinutos();

        long horas = (minutos + 59) / 60; 

        double tarifaPorHora;
        switch (vehiculo.getTipo()) {
            case AUTO:
                tarifaPorHora = 100;
                break;
            case SUV:
                tarifaPorHora = 130;
                break;
           default:
                tarifaPorHora = 180;
                break;
        }

        return horas * tarifaPorHora;
    }

}