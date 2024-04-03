package com.epicode.U5D1.entities;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Tavolo {
    private int number;
    private int maxCovers;
    private StatoTavolo isOccupied;
    private double price;
}

