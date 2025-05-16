package main.com.cinema.dao;

import main.com.cinema.entity.Session;
import main.com.util.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SessionDAO {

    private static final String SQL_GET_ALL_SESSIONS = """
            SELECT *
            FROM session
            """;

    private static final String SQL_GET_SESSION_BY_ID = """
            SELECT *
            FROM session
            WHERE id = ?
            """;



    public List<Session> getAllSessions() throws SQLException {

        List<Session> sessions = new ArrayList<>();

        try(Connection con = ConnectionManager.open();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(SQL_GET_ALL_SESSIONS)){


                while(rs.next()){
                    sessions.add( new Session(
                            sessionConstructor(rs)
                    ));
                }

        }

        return sessions;
    }

    public Session getSessionById(int id) throws SQLException{

        try(Connection con = ConnectionManager.open();
            PreparedStatement prSt = con.prepareStatement(SQL_GET_SESSION_BY_ID)){

            prSt.setInt(1,id);

            try(ResultSet rs = prSt.executeQuery()){
                if(rs.next()){
                    return new Session(
                            sessionConstructor(rs)
                    );
                }
            }

        }

        return null;
    }




    public Session sessionConstructor(ResultSet rs) throws SQLException {
        return new Session(
                rs.getInt("id"),
                rs.getString("session_name"),
                rs.getTimestamp("session_time"),
                rs.getInt("hall_id"));
    }




    private SessionDAO(){
    }

}
