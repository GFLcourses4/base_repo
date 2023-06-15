package com.example.base_repo.decorator;

public class DataSourceDecorator implements DataSource {

    private DataSource dataSource;

    public DataSourceDecorator(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void writeData(String message) {
        dataSource.writeData(message);
    }

    @Override
    public String readData() {
        return dataSource.readData();
    }
}
