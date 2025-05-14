package main.com.cinema.entity;

public class Seat {

    private int id;
    private int row;
    private int seatNum;

    public Seat(int id, int row, int seatNum) {
        this.id = id;
        this.row = row;
        this.seatNum = seatNum;
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


    public void setId(int id) {
        this.id = id;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setSeatNum(int seatNum) {
        this.seatNum = seatNum;
    }


    @Override
    public String toString() {
        return "Seat{" +
                "id = " + id +
                ", row = " + row +
                ", seatNum = " + seatNum +
                '}';
    }
}
