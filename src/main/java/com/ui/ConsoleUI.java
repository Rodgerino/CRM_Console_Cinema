package com.ui;

import com.cinema.dao.BookingDAO;
import com.cinema.dao.SeatDAO;
import com.cinema.dao.SessionDAO;
import com.cinema.entity.Booking;
import com.cinema.entity.Seat;
import com.cinema.entity.Session;
import com.util.InputValidator;

import java.awt.print.Book;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Scanner;

public class ConsoleUI {

    private final SeatDAO seatDAO;
    private final SessionDAO sessionDAO;
    private final BookingDAO bookingDAO;
    private final Scanner sc;
    private Object LocalDateTime;

    public ConsoleUI(SeatDAO seatDAO, SessionDAO sessionDAO, BookingDAO bookingDAO) {
        this.seatDAO = seatDAO;
        this.sessionDAO = sessionDAO;
        this.bookingDAO = bookingDAO;
        this.sc = new Scanner(System.in);
    }


    public void start(){

        while (true){
            System.out.println("1. Показать сеансы");
            System.out.println("2. Показать места для сеанса");
            System.out.println("3. Забронировать место");
            System.out.println("4. Отменить бронь");
            System.out.println("5. Показать брони");
            System.out.println("6. Выход");
            System.out.println("Выберите действие: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> displaySessions();
                case 2 -> displaySeatsForSession();
                case 3 -> bookSeat();
                case 4 -> canelBooking();
                case 5 -> displayBookings();
                case 6 -> { return; }
                default -> System.out.println("Неверный выбор");
            }
        }

    }

    private void displaySessions(){
        try{
            List<Session> sessions = sessionDAO.getAllSessions();
            for (Session session : sessions) {
                System.out.println(session);
            }
        } catch (SQLException e) {
            System.out.println("Ошибка при загрузке сеанса" + e.getMessage());
        }
    }

    private void displaySeatsForSession(){
        try{
            System.out.println("Введите ID сеанса: ");
             int sessionId = sc.nextInt();
             sc.nextLine();
             Session session = sessionDAO.getSessionById(sessionId);

             if(session == null){
                 System.out.println("Сеанс не найден!");
                 return;
             }

             List<Seat> seats = seatDAO.getAllSeats();
             System.out.println("Схема зала для сеанса: " + session.getNameSession());
            for (int row = 1; row <= 5 ; row++) {
                System.out.print("Ряд " + row + ": ");
                for (int seatNum = 1; seatNum < 10; seatNum++) {
                    boolean booked = false;
                    for (Seat seat : seats) {
                        if(seat.getRow() == row && seat.getSeatNum() == seatNum){
                            booked = seatDAO.isSeatBooked(seat.getId(),sessionId);
                            break;
                        }
                    }
                    System.out.print(booked ? "X " : "0 ");
                }
                System.out.println();
            }
        } catch (SQLException e) {
            System.out.println("Ошибка при загрузке мест сеанса" + e.getMessage());
        }
    }

    private void bookSeat(){
        try {
            System.out.println("Введите ID сеанса: ");
            int sessionId = sc.nextInt();
            sc.nextLine();

            if(sessionDAO.getSessionById(sessionId) == null){
                System.out.println("Сеанс не найден!");
                return;
            }

            System.out.println("Введите ряд: ");
            int row = sc.nextInt();
            System.out.println("Введите номер места: ");
            int seatNum = sc.nextInt();
            sc.nextLine();

            if(!InputValidator.isValidRow(row) || !InputValidator.isValidSeatNum(seatNum)) {
                System.out.println("Некорректный ряд или место!");
                return;
            }

            System.out.println("Введите ваше имя: ");
            String userName = sc.nextLine();

            if(InputValidator.isValidName(userName) ){
                System.out.println("Неккоректное имя!");
                return;
            }

            int seatId = -1;

            for (Seat seat : seatDAO.getAllSeats()) {
                if(seat.getRow() == row && seat.getSeatNum() == seatNum) {
                    seatId = seat.getId();
                    break;
                }
            }

            if(seatId == -1){
                System.out.println("Место не найдено!");
                return;
            }

            if(seatDAO.isSeatBooked(seatId,sessionId)){
                System.out.println("Место уже забронировано!");
                return;
            }

            bookingDAO.createBooking(seatId,sessionId,userName);
            System.out.println("Место успешно забронировано!");

        }catch (SQLException e) {
            System.out.println("Ошибка при бронировании мест сеанса" + e.getMessage());
        }
    }

    private void canelBooking(){
        try{

            System.out.println("Введите ID брони: ");
            int bookingId = sc.nextInt();
            sc.nextLine();



            bookingDAO.deleteBooking(bookingId);
            System.out.println("Бронь успешно снята!");


        }catch (SQLException e) {
            System.out.println("Ошибка при отмене бронирования места сеанса " + e.getMessage());
        }
    }

    private void displayBookings(){
        try{

            List<Booking> bookings = bookingDAO.getAllBookings();

            if (bookings.isEmpty()){
                System.out.println("Нет доступных броней для просмотра");
            }

            for (Booking booking : bookings) {
                System.out.println(booking);
            }
        } catch (SQLException e) {
            System.out.println("Ошибка при загрузке сеанса" + e.getMessage());
        }
    }
}
