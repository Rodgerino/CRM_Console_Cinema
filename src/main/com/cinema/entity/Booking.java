package main.com.cinema.entity;

import java.sql.Timestamp;

public class Booking {

    private int id;
    private int seatId;
    private String userName;
    private int sessionId;

    public Booking(int id, int seatId, String userName, int sessionId) {
        this.id = id;
        this.seatId = seatId;
        this.userName = userName;
        this.sessionId = sessionId;
    }

    public int getId() {
        return id;
    }

    public int getSeatId() {
        return seatId;
    }

    public String getUserName() {
        return userName;
    }

    public int getSessionId() {
        return sessionId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id = " + id +
                ", seatId = " + seatId +
                ", userName = '" + userName + '\'' +
                ", sessionId = " + sessionId +
                '}';
    }
}
