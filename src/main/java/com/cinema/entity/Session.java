package com.cinema.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.sql.Timestamp;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Session {
    private int id;
    private String nameSession;
    private Timestamp sessionTime;
    private int hallId;

    @Override
    public String toString() {
        return  "id: " + id +
                ", Название сеанса: '" + nameSession + '\'' +
                ", Дата и время сеанса: " + sessionTime +
                ", IDЗала: " + hallId;
    }
}
