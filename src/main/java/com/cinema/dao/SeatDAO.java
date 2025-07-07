package com.cinema.dao;

import com.cinema.entity.Booking;
import com.cinema.entity.Seat;
import com.cinema.util.ConnectionManager;
import com.cinema.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SeatDAO {

    private static final String SQL_IS_SEAT_BOOKED = """
            SELECT COUNT(*)
            FROM bookings
            WHERE seat_id = ? AND session_id = ?
            """;


    public List<Seat> getAllSeats() {
        try (SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
             Session session = sessionFactory.openSession()) {

            String hql = "FROM Seat";
            Query<Seat> query = session.createQuery(hql, Seat.class);
            return query.getResultList();

        } catch (Exception e) {

            throw new RuntimeException("Failed to get all bookings", e);
        }

    }


    //TODO нужно переписать метод на хибер
    public boolean isSeatBooked(int seatId, int sessionId) throws SQLException {

        try(Connection con = ConnectionManager.open();
            PreparedStatement prSt = con.prepareStatement(SQL_IS_SEAT_BOOKED)){

            prSt.setInt(1,seatId);
            prSt.setInt(2,sessionId);

            try(ResultSet rs = prSt.executeQuery()) {
                return rs.next() && rs.getInt(1) > 0;
            }

        }


    }




    public SeatDAO(){
    }

}
