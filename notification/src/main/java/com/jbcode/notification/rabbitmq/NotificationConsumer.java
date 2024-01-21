//package com.jbcode.notification.rabbitmq;
//
//
//import com.jbcode.clients.notification.record.NotificationRequest;
//import com.jbcode.notification.service.NotificationService;
//import lombok.AllArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Component;
//
//@Component
//@AllArgsConstructor
//@Slf4j
//public class NotificationConsumer {
//
//    private final NotificationService notificationService;
//
//    @RabbitListener(queues = "${rabbitmq.queues.notification}")
//    public void consumer(NotificationRequest notificationRequest) {
//        log.info("Consumed {} from queue", notificationRequest);
//        notificationService.send(notificationRequest);
//    }
//}