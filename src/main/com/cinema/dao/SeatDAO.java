package main.com.cinema.dao;

import main.com.cinema.entity.Seat;
import main.com.util.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SeatDAO {

    private static final String SQL_GET_ALL_SEATS = """
            SELECT *
            FROM seats
            """;

    private static final String SQL_IS_SEAT_BOOKED = """
            SELECT COUNT(*)
            FROM bookings
            WHERE seat_id = ? AND session_id = ?
            """;


    public List<Seat> getAllSeats() throws SQLException {
        List<Seat> seats = new ArrayList<>();

        try(Connection con = ConnectionManager.open();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(SQL_GET_ALL_SEATS)){

            while(rs.next()) {
                seats.add(new Seat(
                        rs.getInt("id"),
                        rs.getInt("row"),
                        rs.getInt("seat_num")
                ));

            }

        }

        return seats;
    }

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




    private SeatDAO(){
    }

}
