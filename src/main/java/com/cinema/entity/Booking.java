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
public class Booking {

    private int id;
    private int seatId;
    private String userName;
    private int sessionId;



    @Override
    public String toString() {
        return "id: " + id +
                ", Номер места: " + seatId +
                ", Бронь на имя: '" + userName + '\'' +
                ", ID Сеанса: " + sessionId;
    }
}
