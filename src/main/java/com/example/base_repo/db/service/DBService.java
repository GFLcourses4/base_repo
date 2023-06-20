package com.example.base_repo.db.service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface DBService {
    DataSource createDataSource();
    ResultSet getAllBirds(Connection conn) throws SQLException;
    ResultSet getFilteredBirds(Connection conn, String birdName) throws SQLException;
    int insertBird(Connection conn, String birdName, String birdDescription) throws SQLException;
    int updateBird(Connection conn, String birdName, String birdDescription) throws SQLException;
    int deleteBird(Connection conn, String birdName) throws SQLException;
}
