package main.com.cinema.dao;

import main.com.cinema.entity.Booking;
import main.com.util.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookingDAO {

    private static final String SQL_CREATE_BOOKING = """
            INSERT INTO bookings (seat_id,session_id,user_name,booking_time)
            VALUES (?,?,?,?)
            """;

    private static final String SQL_DELETE_BOOKING = """
            DELETE FROM bookings
            WHER id =  ?
            """;

    private static final String SQL_GET_ALL_BOOKINGS = """
            SELECT *
            FROM bookings
            """;

    public List<Booking> getAllBookings() throws SQLException {
        List<Booking> bookings = new ArrayList<>();

        try(Connection con = ConnectionManager.open();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(SQL_GET_ALL_BOOKINGS)){

            while(rs.next()){
                bookings.add(new Booking(
                        rs.getInt("id"),
                        rs.getInt("seat_id"),
                        rs.getString("user_name"),
                        rs.getInt("session_id")
                ));
            }
        }
        return bookings;
    }

    public void deleteBooking(int bookingId) throws SQLException {
        try (Connection con = ConnectionManager.open();
             PreparedStatement prSt = con.prepareStatement(SQL_DELETE_BOOKING)) {
            prSt.setInt(1, bookingId);
            prSt.executeUpdate();
        }
    }

    public void createBooking(int seatId, int sessionId, String userName, Timestamp bookingTime) throws SQLException {
        try (Connection con = ConnectionManager.open();
             PreparedStatement prSt = con.prepareStatement(SQL_CREATE_BOOKING)){
                 prSt.setInt(1,seatId);
                 prSt.setInt(2,sessionId);
                 prSt.setString(3,userName);
                 prSt.setTimestamp(4,bookingTime);


                 prSt.executeUpdate();
        }

    }


    private BookingDAO(){
    }

}
