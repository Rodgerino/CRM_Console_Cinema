package com.cinema.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "session")
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "session_name")
    private String nameSession;

    @Column(name  = "session_time")
    private Timestamp sessionTime;

    @Column(name = "hall_id")
    private int hallId;

    @Override
    public String toString() {
        return  "id: " + id +
                ", Название сеанса: '" + nameSession + '\'' +
                ", Дата и время сеанса: " + sessionTime +
                ", IDЗала: " + hallId;
    }
}
