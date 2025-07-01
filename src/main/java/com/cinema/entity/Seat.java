package com.cinema.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Seat {

    private int id;
    private int row;
    private int seatNum;


    @Override
    public String toString() {
        return "id: " + id +
                ", Ряд: " + row +
                ", Номер места: " + seatNum;
    }
}
