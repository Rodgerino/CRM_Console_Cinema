package com.cinema.dao;

import com.cinema.entity.Booking;
import com.cinema.entity.Seat;
import com.cinema.util.ConnectionManager;
import com.cinema.util.HibernateUtil;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class BookingDAO {

    public List<Booking> getAllBookings() {
        try (SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
             Session session = sessionFactory.openSession()) {

            String hql = "FROM Booking";
            Query<Booking> query = session.createQuery(hql, Booking.class);
            return query.getResultList();

        } catch (Exception e) {

            throw new RuntimeException("Failed to get all bookings", e);
        }

    }

    public void deleteBooking(int bookingId) throws SQLException {

        try(SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
            Session session = sessionFactory.openSession()){

            session.beginTransaction();

            Booking booking = session.get(Booking.class,bookingId);

            session.delete(booking);

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

            session.saveOrUpdate(booking);

            session.getTransaction().commit();

        }

    }

    public Booking getBookingById (int bookingId) throws SQLException {

        try (SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
             Session session = sessionFactory.openSession()) {

            return session.get(Booking.class, bookingId);

        }catch (Exception e){
            throw new RuntimeException("Failed to get booking by id", e);
        }
    }
}
