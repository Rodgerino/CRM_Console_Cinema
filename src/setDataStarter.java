import com.util.ConnectionManager;

import java.sql.*;

public class setDataStarter {

    public static void main(String[] args) throws SQLException {
        setSeats();
        setSessions();
    }

    public static void setSeats() throws SQLException {
        String sql = """
                INSERT INTO seats(row,seat_num)
                VALUES (1,1), (1,2), (1,3), (1,4), (1,5), (1,6), (1,7), (1,8), (1,9), (1,10), 
                       (2,1), (2,2), (2,3), (2,4), (2,5), (2,6), (2,7), (2,8), (2,9), (2,10),
                       (3,1), (3,2), (3,3), (3,4), (3,5), (3,6), (3,7), (3,8), (3,9), (3,10),
                       (4,1), (4,2), (4,3), (4,4), (4,5), (4,6), (4,7), (4,8), (4,9), (4,10),
                       (5,1), (5,2), (5,3), (5,4), (5,5), (5,6), (5,7), (5,8), (5,9), (5,10)
                """;

        try(Connection con = ConnectionManager.open();
            PreparedStatement prSt = con.prepareStatement(sql)) {

            prSt.executeUpdate();

            System.out.println("Таблица мест заполнена!");

        }
    }

    public static void setSessions() throws SQLException {
        String sql = """
                INSERT INTO session (session_name,session_time,hall_id)
                VALUES ('ПитерFM', '2025-05-19 18:00:00', 1),
                       ('Пророк',  '2025-05-19 20:00:00', 1)
                """;

        try(Connection con = ConnectionManager.open();
            PreparedStatement prSt = con.prepareStatement(sql)) {

            prSt.executeUpdate();

            System.out.println("Таблица сеансов заполнена!");

        }
    }
}
