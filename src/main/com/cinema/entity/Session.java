package main.com.cinema.entity;

import java.sql.Timestamp;

public class Session {
    private int id;
    private String nameSession;
    private Timestamp sessionTime;
    private int hallId;

    public Session(int id, String nameSession, Timestamp sessionTime, int hallId) {
        this.id = id;
        this.nameSession = nameSession;
        this.sessionTime = sessionTime;
        this.hallId = hallId;
    }

    public int getId() {
        return id;
    }

    public String getNameSession() {
        return nameSession;
    }

    public Timestamp getSessionTime() {
        return sessionTime;
    }

    public int getHallId() {
        return hallId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNameSession(String nameSession) {
        this.nameSession = nameSession;
    }

    public void setSessionTime(Timestamp sessionTime) {
        this.sessionTime = sessionTime;
    }

    public void setHallId(int hallId) {
        this.hallId = hallId;
    }

    @Override
    public String toString() {
        return "Session{" +
                "id = " + id +
                ", nameSession = '" + nameSession + '\'' +
                ", sessionTime = " + sessionTime +
                ", hallId = " + hallId +
                '}';
    }
}
