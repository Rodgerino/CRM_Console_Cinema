package com.cinema.dao;

import com.cinema.entity.Seat;
import com.cinema.util.HibernateUtil;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


import java.sql.SQLException;
import java.util.List;

@Slf4j
public class SeatDAO {

    public List<Seat> getAllSeats() {
        try (SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
             Session session = sessionFactory.openSession()) {

            log.info("получен список всех мест");
            return session.createQuery("from Seat ", Seat.class)
                    .getResultList();
        } catch (Exception e) {

            log.error(e.getMessage());
            throw new RuntimeException("Ошибка при получвении мест", e);
        }

    }


    public boolean isSeatBooked(int seatId, int sessionId) throws SQLException {

        try(SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
            Session session = sessionFactory.openSession()) {

            return session.createQuery("SELECT COUNT(b) > 0 FROM Booking b " +
                            "WHERE b.seat.id = :seatId AND b.session.id = :sessionId", Boolean.class)
                    .setParameter("seatId", seatId)
                    .setParameter("sessionId", sessionId)
                    .uniqueResult();

        } catch (Exception e) {

            log.error(e.getMessage());
            throw new RuntimeException("Ошибка при получвении мест", e);
        }


    }




    public SeatDAO(){
    }

}
