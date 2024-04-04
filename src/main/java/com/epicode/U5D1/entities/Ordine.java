package com.epicode.U5D1.entities;
import lombok.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Ordine {
    private int idOrdine;
    private StatoOrdine status;
    private int covers;
    private LocalTime acquisitionTime;
    private double totalAmount;
    private Tavolo table;
    private List<Item> items;

    public Ordine(int idOrdine, StatoOrdine status, int covers,Tavolo table){
        if (table.getMaxCovers() <= covers)
            throw new RuntimeException("Numero coperti maggiore di numero massimo posti sul tavolo!");
        this.idOrdine = idOrdine;
        this.covers = covers;
        this.status = status;
        this.acquisitionTime = LocalTime.now();
        this.items = new ArrayList<>();
        this.table = table;
    }

    public void addItem(Item item) {
        this.items.add(item);
    }

    public double getTotal() {
        return this.items.stream().mapToDouble(Item::getPrice).sum() + (this.table.getPrice() * this.covers);
    }

    public void print() {
        System.out.println("id ordine--> " + this.idOrdine);
        System.out.println("stato--> " + this.status);
        System.out.println("numero coperti--> " + this.covers);
        System.out.println("ora acquisizione--> " + this.acquisitionTime);
        System.out.println("numero tavolo--> " + this.table.getNumber());
        System.out.println("Lista: ");
        this.items.forEach(System.out::println);
        System.out.println("totale--> " + this.getTotal());

    }

}
