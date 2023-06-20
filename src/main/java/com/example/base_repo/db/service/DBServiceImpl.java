package com.example.base_repo.db.service;

import org.postgresql.ds.PGSimpleDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBServiceImpl implements DBService{
    @Override
    public DataSource createDataSource() {
        final String url =
                "jdbc:postgresql://localhost:5432/encyclopedia?user=postgres&password=postgres";
        final PGSimpleDataSource dataSource = new PGSimpleDataSource();
        dataSource.setUrl(url);
        return dataSource;
    }

    @Override
    public ResultSet getAllBirds(Connection conn) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("select * from birds");
        ResultSet rs = stmt.executeQuery();
        return rs;
    }

    @Override
    public ResultSet getFilteredBirds(Connection conn, String birdName) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("select * from birds where bird=?");
        stmt.setString(1, birdName);
        ResultSet rs = stmt.executeQuery();
        return rs;
    }

    @Override
    public int insertBird(Connection conn, String birdName, String birdDescription) throws SQLException {
        PreparedStatement insertStmt =
                conn.prepareStatement("INSERT INTO birds(bird, description) VALUES (?, ?)");
        insertStmt.setString(1, birdName);
        insertStmt.setString(2, birdDescription);
        int insertedRows = insertStmt.executeUpdate();
        return insertedRows;
    }

    @Override
    public int updateBird(Connection conn, String birdName, String birdDescription) throws SQLException {
        PreparedStatement updateStmt =
                conn.prepareStatement("UPDATE birds SET description = ? WHERE bird = ?");
        updateStmt.setString(1, birdDescription);
        updateStmt.setString(2, birdName);
        int updatedRows = updateStmt.executeUpdate();
        return updatedRows;
    }

    @Override
    public int deleteBird(Connection conn, String birdName) throws SQLException {
        PreparedStatement deleteStmt = conn.prepareStatement("DELETE FROM birds WHERE bird = ?");
        deleteStmt.setString(1, birdName);
        int deletedRows = deleteStmt.executeUpdate();
        return deletedRows;
    }
}
