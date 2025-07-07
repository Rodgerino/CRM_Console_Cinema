package com.cinema.dao;

import com.cinema.entity.Booking;
import com.cinema.entity.Session;
import com.cinema.util.ConnectionManager;
import com.cinema.util.HibernateUtil;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SessionDAO {

    public List<Session> getAllSessions() throws SQLException {
        try (SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
             org.hibernate.Session session = sessionFactory.openSession()) {

            String hql = "FROM Session";
            Query<Session> query = session.createQuery(hql, Session.class);
            return query.getResultList();

        } catch (Exception e) {

            throw new RuntimeException("Failed to get all bookings", e);
        }

    }

    public Session getSessionById (int sessionId) throws SQLException {

        try (SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
             org.hibernate.Session session = sessionFactory.openSession()) {

            return session.get(Session.class, sessionId);

        }catch (Exception e){
            throw new RuntimeException("Failed to get session by id", e);
        }
    }


    public SessionDAO(){
    }

}
