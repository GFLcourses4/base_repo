package com.example.base_repo.schedule;

import org.springframework.stereotype.Component;

@Component(value = "testBla")
public class TestComponent {
    private String type;
    private Integer arg;

    public TestComponent() {
        this.type = "Test";
        this.arg = 3000;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getArg() {
        return arg;
    }

    public void setArg(Integer arg) {
        this.arg = arg;
    }
}
