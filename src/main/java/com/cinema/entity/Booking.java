package com.cinema.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "user_name")
    private String userName;


    @ManyToOne
    private Seat seat;

    @ManyToOne
    private Session session;


    @Override
    public String toString() {
        return "id: " + id +
                ", Номер места: " + seat +
                ", Бронь на имя: '" + userName + '\'' +
                ", ID Сеанса: " + session;
    }
}
