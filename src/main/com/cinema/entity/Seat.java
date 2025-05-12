package main.com.cinema.entity;

public class Seat {

    private int id;
    private int row;
    private int seatNum;
    private boolean isBooked;

    public Seat(int id, int row, int seatNum, boolean isBooked) {
        this.id = id;
        this.row = row;
        this.seatNum = seatNum;
        this.isBooked = isBooked;
    }

    public int getId() {
        return id;
    }

    public int getRow() {
        return row;
    }

    public int getSeatNum() {
        return seatNum;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setSeatNum(int seatNum) {
        this.seatNum = seatNum;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }

    @Override
    public String toString() {
        return "Seat{" +
                "id = " + id +
                ", row = " + row +
                ", seatNum = " + seatNum +
                ", isBooked = " + isBooked +
                '}';
    }
}
