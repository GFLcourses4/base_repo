package com.example.base_repo.decorator;

public class FileDataSource implements DataSource {
    private String message;

    public FileDataSource(String message) {
        this.message = message;
    }

    @Override
    public void writeData(String message) {
        System.out.println("Imitation write message ->" + message);
    }

    @Override
    public String readData() {
        System.out.println("Imitation read message ->" + message);
        return message;
    }
}
