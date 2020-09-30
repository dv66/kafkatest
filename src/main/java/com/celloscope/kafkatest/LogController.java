package com.celloscope.kafkatest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogController {

    @Autowired
    KafkaTemplate kafkaTemplate;

    int logCount = 1;

    @GetMapping("/send")
    public String sendLogToKafka(){
        String logMessage = "sending log to kafka " + logCount;
        logCount++;
        kafkaTemplate.send("testtopic", logMessage);
        System.out.println(logMessage);
        return logMessage;
    }

}
