package com.jerry.provider.sender;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class Tut2SenderTest {

    @Resource
    private Tut2Sender tut2Sender;

    @Test
    void send() {
        new Thread(() -> {while (true) {
            tut2Sender.send();
        }}).start();
    }
}