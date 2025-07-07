package com.cinema.dao;

import com.cinema.entity.Booking;
import com.cinema.entity.Seat;
import com.cinema.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;

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
}
