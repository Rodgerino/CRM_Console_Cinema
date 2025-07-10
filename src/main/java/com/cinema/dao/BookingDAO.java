package com.cinema.dao;

import com.cinema.entity.Booking;
import com.cinema.entity.Seat;
import com.cinema.util.HibernateUtil;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.sql.*;
import java.util.List;


public class BookingDAO {


    private static final Logger log = Logger.getLogger(BookingDAO.class);

    public List<Booking> getAllBookings() {
        try (SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
             Session session = sessionFactory.openSession()) {

            log.info("Получены все брони");

            return session.createQuery("FROM Booking", Booking.class)
                    .getResultList();



        } catch (Exception e) {

            log.error("Ошибка при получении броней",e);
            throw new RuntimeException("Ошибка при получении броней", e);
        }

    }

    public void deleteBooking(int bookingId) throws SQLException {

        try(SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
            Session session = sessionFactory.openSession()){

            session.beginTransaction();

            Booking booking = session.get(Booking.class,bookingId);

            session.delete(booking);

            log.info("Бронирование удалено");

            session.getTransaction().commit();


        }
    }

    public void createBooking(int seatId, int sessionId, String userName) throws SQLException {
        try(SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
            Session session = sessionFactory.openSession()){

            session.beginTransaction();

            Booking booking = Booking.builder()
                    .seat(session.get(Seat.class, seatId))
                    .session(session.get(com.cinema.entity.Session.class,sessionId))
                    .userName(userName)
                    .build();

            log.info("Бронирование создано");

            session.saveOrUpdate(booking);

            session.getTransaction().commit();

            log.info("Бронирование сохранено");

        }

    }

    public Booking getBookingById (int bookingId) throws SQLException {

        try (SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
             Session session = sessionFactory.openSession()) {

            log.info("Бронирование получено");
            return session.get(Booking.class, bookingId);



        }catch (Exception e){
            log.error("Ошибка при получении бронирования ",e);
            throw new RuntimeException("Ошибка при получении бронирования", e);
        }
    }
}
