package com.epicode.U5D1.entities;
import lombok.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class Ordine {
    private int id;
    private StatoOrdine status;
    private int covers;
    private LocalDateTime acquisitionTime;
    private double totalAmount;
    private Tavolo table;
    private List<Item> items = new ArrayList<>();

    public Ordine(Tavolo table, int id, StatoOrdine status, int covers, LocalDateTime acquisitionTime){
        this.table = table;
        this.id = id;
        this.status = status;
        this.covers = covers;
        this.acquisitionTime = acquisitionTime;
        this.totalAmount = getTotalAmount();
    }

    public double getTotalAmount() {
        double total = 0;
        for (Item item : items) {
            total += item.getPrice();
        }
        total += (table.getPrice()*this.covers);
        return total;
    }

}
