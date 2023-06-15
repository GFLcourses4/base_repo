package com.example.base_repo.decorator;

public interface DataSource {
    void writeData(String message);

    String readData();
}
