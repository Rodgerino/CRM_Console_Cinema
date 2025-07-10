package com.cinema.dao;

import com.cinema.entity.Booking;
import com.cinema.entity.Seat;
import com.cinema.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;


import java.sql.SQLException;

public class SeatDAOTest {

    @Test
    void getAllSeats() {

        try(SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
            Session session = sessionFactory.openSession()){

            session.beginTransaction();

            String hql = "FROM Seat";
            session.createQuery(hql, Seat.class);

            session.getTransaction().commit();


        }

    }

    @Test
    void isSeatBooked() {

        try(SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
            Session session = sessionFactory.openSession()){

            session.beginTransaction();

            Seat seat = Seat.builder()
                    .build();

            com.cinema.entity.Session sessionCinema = com.cinema.entity.Session.builder().build();

            session.saveOrUpdate(seat);
            session.saveOrUpdate(sessionCinema);

            session.createQuery("SELECT COUNT(b) > 0" +
                    "            FROM Booking b" +
                    "            WHERE b.seat = :seat AND b.session = :session", Booking.class)
                    .setParameter("seat", seat.getId())
                    .setParameter("session", sessionCinema.getId())
                    .uniqueResult();

        }


    }
}
