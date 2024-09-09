package com.project.portfolio.core.utilities;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ExecuteSQL {
    public static void main(String[] args) throws FileNotFoundException {
        String url = "jdbc:sqlserver://localhost:1433;encrypt=true;trustServerCertificate=true;databaseName=portfolio";
        String user = "gokhan";
        String password = "1234";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement()) {

            String sql = new String(Files.readAllBytes(Paths.get("data.sql")));
            stmt.execute(sql);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
