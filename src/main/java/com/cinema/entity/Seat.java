package com.cinema.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "seats")
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int row;

    @Column(name = "seat_num")
    private int seatNum;


    @Override
    public String toString() {
        return "id: " + id +
                ", Ряд: " + row +
                ", Номер места: " + seatNum;
    }
}
