package com.epicode.U5D1.entities;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
public class Ordine {
    private Tavolo tavolo;
    private long id;
    private StatoOrdine stato;
    private int numeroCoperti;
    private LocalTime oraDiAcquisizione;
    private double costoTotale;

    public Ordine(Tavolo tavolo, long id, StatoOrdine stato, int numeroCoperti){
        this.tavolo = tavolo;
        this.id = id;
        this.stato = stato;
        this.numeroCoperti = numeroCoperti;
        this.oraDiAcquisizione = LocalTime.now();
        this.costoTotale = tavolo.getPrezzo() * numeroCoperti;
    }

}
