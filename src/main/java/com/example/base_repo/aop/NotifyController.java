package com.example.base_repo.aop;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/testNotification")
public class NotifyController {
    public final Notification notification;

    public NotifyController(Notification notification) {
        this.notification = notification;
    }

    @GetMapping(path = "/{msg}")
    public ResponseEntity<Void> get(@PathVariable(value = "msg") String message) throws Exception {
        notification.aopNotificationExample(message);
        return ResponseEntity.ok().build();
    }
}
