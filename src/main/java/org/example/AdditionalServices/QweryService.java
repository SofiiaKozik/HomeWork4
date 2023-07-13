package org.example.AdditionalServices;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class QweryService {
    public void executeComand(String query){
        try {
            getStatement().execute(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ResultSet executeQuery(String query){
        try {
            return getStatement().executeQuery(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void executeQueryUpdate(String query){
        try {
            getStatement().executeUpdate(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Statement getStatement() throws SQLException {
        Connection conn = Database.getInstance().getConnection();
        return conn.createStatement();
    }

}
