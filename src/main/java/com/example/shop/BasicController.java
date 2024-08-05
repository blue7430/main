package com.example.shop;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.util.Date;

@Controller
public class BasicController {
    @GetMapping("/")
    String hello() {
        return "index.html";
    }

    @GetMapping("/date")
    @ResponseBody
    String date() {
        return LocalDateTime.now().toString();
    }

    @GetMapping("/mypage")
    @ResponseBody
    String my() {
        return "마이페이지";
    }

}