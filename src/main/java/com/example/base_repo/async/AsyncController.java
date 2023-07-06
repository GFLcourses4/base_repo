package com.example.base_repo.async;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AsyncController {
    private final AsyncComponent asyncComponent;

    public AsyncController(AsyncComponent asyncComponent) {
        this.asyncComponent = asyncComponent;
    }

    @GetMapping(path = "/api/run/async")
    public ResponseEntity<Void> runAsync() {
        System.out.println("Main thread - " + Thread.currentThread().getName());
        asyncComponent.async();
        return ResponseEntity.ok().build();
    }
}
