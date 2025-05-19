package com.cinema.main;


import com.cinema.dao.BookingDAO;
import com.cinema.dao.SeatDAO;
import com.cinema.dao.SessionDAO;
import com.ui.ConsoleUI;

public class Main {
    public static void main(String[] args) {


        SeatDAO seatDAO = new SeatDAO();
        BookingDAO bookingDAO = new BookingDAO();
        SessionDAO sessionDAO = new SessionDAO();
        ConsoleUI ui = new ConsoleUI(seatDAO,sessionDAO,bookingDAO);
        ui.start();


    }
}