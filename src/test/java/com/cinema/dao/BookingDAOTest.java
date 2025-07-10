package com.cinema.dao;


import com.cinema.entity.Booking;
import com.cinema.entity.Seat;
import com.cinema.util.ConnectionManager;
import com.cinema.util.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class BookingDAOTest {

    private static final Logger log = Logger.getLogger(BookingDAOTest.class);

    @Test
    void getAllBookings() {

        try(SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
            Session session = sessionFactory.openSession()){

            session.beginTransaction();

            session.createQuery("from Booking ", Booking.class);

            session.getTransaction().commit();

            log.info("Getting all bookings");

        }

    }

    @Test
    void getBookingById () {
        try(SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
            Session session = sessionFactory.openSession()){

            session.beginTransaction();

            session.get(Booking.class, 1);

            session.getTransaction().commit();

        }
    }

    @Test
    void createBooking() {
        try(SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
            Session session = sessionFactory.openSession()){

            session.beginTransaction();

            Booking booking = Booking.builder()
                    .seat(session.get(Seat.class, 1))
                    .session(session.get(com.cinema.entity.Session.class,1))
                    .userName("Aboba")
                    .build();

            session.saveOrUpdate(booking);

            session.getTransaction().commit();

        }


    }

    @Test
    void deleteBooking() {
        try(SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
            Session session = sessionFactory.openSession()){

            session.beginTransaction();

            Booking booking = session.get(Booking.class,3);

            session.delete(booking);

            session.getTransaction().commit();

        }
    }



}
