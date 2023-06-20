package com.example.base_repo.db;

import com.example.base_repo.db.service.DBService;
import com.example.base_repo.db.service.DBServiceImpl;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class App {
    public static void main(String[] args) throws Exception {
        DBService dbService= new DBServiceImpl();
        DataSource dataSource = dbService.createDataSource();
        Connection conn = dataSource.getConnection();

        ResultSet rs = dbService.getAllBirds(conn);
        while (rs.next()) {
            System.out.printf("All birds: id:%d bird:%s description:%s%n", rs.getLong("id"),
                    rs.getString("bird"), rs.getString("description"));
        }

        ResultSet rsFiltered = dbService.getFilteredBirds(conn, "eagle");
        while (rsFiltered.next()) {
            System.out.printf("Filtered birds: id:%d bird:%s description:%s%n", rsFiltered.getLong("id"),
                    rsFiltered.getString("bird"), rsFiltered.getString("description"));
        }

        try {
            int insertedRows = dbService.insertBird(conn, "rooster", "wakes you up in the morning");
            System.out.printf("inserted %s bird(s)%n", insertedRows);
        } catch (SQLException e) {
            String errorCode = e.getSQLState();
            // 08000 - connection_exception
            if (errorCode == "08000") {
                // retry query after re-establishing connection
            }
            // 42601 - syntax error
            else if (errorCode == "42601") {
                // throw error so that we can see the failure
                throw e;
            } else {
                // log a warning, or do some other action based on the error code
                System.out.printf("SQL failed with error code: %s%n", errorCode);
            }

        }
        int updatedRows = dbService.updateBird(conn, "rooster2", "has a red crown");
        System.out.printf("updated %s bird(s)%n", updatedRows);
        int deletedRows = dbService.deleteBird(conn, "rooster1");
        System.out.printf("deleted %s bird(s)%n", deletedRows);
    }

}