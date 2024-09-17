package com.jerry.provider.sender;

import jakarta.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class Tut1SenderTest {

    @Resource
    private Tut1Sender tut1Sender;

    @Test
    void send() {
        tut1Sender.send();
    }
}