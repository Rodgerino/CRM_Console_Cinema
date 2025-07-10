package com.cinema.dao;

import com.cinema.entity.Booking;
import com.cinema.entity.Seat;
import com.cinema.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;

public class SessionDAOTest {
    @Test
    void getSessiongById () {
        try(SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
            Session session = sessionFactory.openSession()){

            session.beginTransaction();

            session.get(com.cinema.entity.Session.class, 1);

            session.getTransaction().commit();

        }
    }

    @Test
    void getAllSessions() {
        try(SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
            Session session = sessionFactory.openSession()){

            session.beginTransaction();

            session.createQuery("from Session ", com.cinema.entity.Session.class);

            session.getTransaction().commit();


        }

    }
}
