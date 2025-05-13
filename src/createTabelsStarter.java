import main.com.util.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class createTabelsStarter {

    public static void main(String[] args) {

    }

    private static void createSeatTabel(){

        String sql = """
                CREATE TABLE seats(
                    id          INTEGER PRIMARY KEY AUTOINCREMENT,
                    row         INTEGER NOT NULL,
                    seat_num    INTEGER NOT NULL
                );
                """;


        try(Connection con = ConnectionManager.open();
            PreparedStatement prSt = con.prepareStatement(sql)) {

            prSt.executeUpdate();

            System.out.println("Таблица мест создана!");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void createBookingsTabel(){

        String sql = """
                CREATE TABLE bookings(
                    id              INTEGER PRIMARY KEY AUTOINCREMENT,
                    seat_id         INTEGER NOT NULL,
                    session_id      INTEGER NOT NULL,
                    user_name       VARCHAR(100) NOT NULL,
                    booking_time    TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                    FOREIGN KEY (seat_id) REFERENCES seats("id"),
                    FOREIGN KEY (session_id) REFERENCES sessions("id")
                );
                """;


        try(Connection con = ConnectionManager.open();
            PreparedStatement prSt = con.prepareStatement(sql)) {

            prSt.executeUpdate();

            System.out.println("Таблица бронирований создана!");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    private static void createSessionTabel(){

        String sql = """
                CREATE TABLE session(
                    id              INTEGER PRIMARY KEY AUTOINCREMENT,
                    session_name    VARCHAR(100) NOT NULL,
                    session_time    TIMESTAMP NOT NULL,
                    hall_id         INTEGER NOT NULL
                );
                """;


        try(Connection con = ConnectionManager.open();
            PreparedStatement prSt = con.prepareStatement(sql)) {

            prSt.executeUpdate();

            System.out.println("Таблица сеансов создана!");


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
