package com.example.base_repo.decorator;

public class AdditionalDateDecorator extends DataSourceDecorator {
    public AdditionalDateDecorator(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public void writeData(String message) {
        super.writeData(addStringData(message));
    }

    @Override
    public String readData() {
        return removeStringData(super.readData());
    }

    private String addStringData(String message) {
        return message + "-Additional text";
    }

    private String removeStringData(String message) {
        String[] split = message.split("-");
        return split[0];
    }
}
