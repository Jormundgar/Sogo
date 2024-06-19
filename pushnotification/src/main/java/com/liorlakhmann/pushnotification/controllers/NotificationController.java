package com.liorlakhmann.pushnotification.controllers;

import com.liorlakhmann.pushnotification.controllers.api.PushRestApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@Slf4j
public class NotificationController implements PushRestApi {
    private AtomicInteger counter = new AtomicInteger();

    @Override
    public ResponseEntity<Map<String, Object>> sendNotification() {
        Map<String, Object> stubJson = new HashMap<>() {};
        stubJson.put("notification", "Push Notification");
        stubJson.put("when", new Date());
        counter.incrementAndGet();
        log.info("Push notification number {} was sent", counter);
        return new ResponseEntity<>(stubJson, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Integer> getCount() {
        return ResponseEntity.ok(counter.get());
    }
}