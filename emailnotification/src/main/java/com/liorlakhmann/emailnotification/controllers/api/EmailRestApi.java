package com.liorlakhmann.emailnotification.controllers.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@RequestMapping("/api/notify/email")
@Tag(name = "Email Notifications")
public interface EmailRestApi {

    @Operation(
            summary = "Send notification",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Notification sent successfully"
                    )
            }
    )
    @PostMapping
    ResponseEntity<Map<String, Object>> sendNotification();

    @Operation(
            summary = "Get number of notifications",
            description = "Number of messages sent through this channel.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Number retrieved successfully"
                    )
            }
    )
    @GetMapping("/count")
    ResponseEntity<Integer> getCount();
}
