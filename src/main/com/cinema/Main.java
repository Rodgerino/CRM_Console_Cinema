package main.com.cinema;


import main.com.cinema.dao.BookingDAO;
import main.com.cinema.dao.SeatDAO;
import main.com.cinema.dao.SessionDAO;
import main.com.cinema.entity.Booking;
import main.com.cinema.entity.Seat;
import main.com.ui.ConsoleUI;
import main.com.util.ConnectionManager;

public class Main {
    public static void main(String[] args) {


        SeatDAO seatDAO = new SeatDAO();
        BookingDAO bookingDAO = new BookingDAO();
        SessionDAO sessionDAO = new SessionDAO();
        ConsoleUI ui = new ConsoleUI(seatDAO,sessionDAO,bookingDAO);
        ui.start();


    }
}