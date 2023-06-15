package com.example.base_repo.decorator;

import java.util.Base64;

public class EncryptionDecorator extends DataSourceDecorator {
    public EncryptionDecorator(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public void writeData(String message) {
        super.writeData(encode(message));
    }

    @Override
    public String readData() {
        return decode(super.readData());
    }

    private String encode(String message) {
        return Base64.getEncoder().encodeToString(message.getBytes());
    }

    private String decode(String message) {
        byte[] decode = Base64.getDecoder().decode(message);
        return new String(decode);
    }

}
