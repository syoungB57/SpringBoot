package com.example.listproject;

import org.junit.Test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class PostgreSQLConnectionTest {
    private String url = "jdbc:postgresql://localhost:5432/playlistdb";
    private String username = "postgres";
    private String pw = "6156";

    @Test
    public void ConnectionTest() throws Exception {
        Connection con = DriverManager.getConnection(url,username,pw);
        System.out.println(con);

        Statement pre = con.createStatement();
        ResultSet rs = pre.executeQuery("select version()");

        if (rs.next()) {
            System.out.println(rs);
            System.out.println(rs.getString("version"));
        }
    }
}
