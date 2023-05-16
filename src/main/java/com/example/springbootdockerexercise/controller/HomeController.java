package com.example.springbootdockerexercise.controller;

import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.Date;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping
    @ResponseBody
    public String home() {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        String webhookUrl = "https://discord.com/api/webhooks/1090549186040184913/_nVKm8TfNkMjjZDz2lgNqbVQBmciLcgii6trO7nXIEz7LAtMHVRBXkSVwoSd-nYRGxzU"; // 웹훅 수신 URL

        Date date = new Date();
        // 웹훅으로 전송할 데이터
        String payload = "{\"message\": \" ?? \"}";

        HttpEntity<String> entity = new HttpEntity<>(payload, headers);

        ResponseEntity<String> response = restTemplate.exchange(webhookUrl, HttpMethod.POST, entity, String.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            return "Webhook sent successfully";
        } else {
            return "Failed to send webhook";
        }
    }
}
