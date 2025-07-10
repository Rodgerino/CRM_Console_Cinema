package com.cinema.dao;

import com.cinema.entity.Session;
import com.cinema.util.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;

import java.sql.SQLException;
import java.util.List;

public class SessionDAO {

    private static final Logger log = Logger.getLogger(SessionDAO.class);

    public List<Session> getAllSessions() throws SQLException {
        try (SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
             org.hibernate.Session session = sessionFactory.openSession()) {

            log.info("полкчены все сеансы");
            return session.createQuery("FROM Session", Session.class)
                    .getResultList();

        } catch (Exception e) {

            log.error(e.getMessage());
            throw new RuntimeException("Ошибка при получении сеансов", e);
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
