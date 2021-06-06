package ro.fasttrackit.tema12.student.service.service;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import ro.fasttrackit.tema12.model.StudentDeleteEvent;

@Service
@RequiredArgsConstructor
public class RabbitmqService {
    private final RabbitTemplate rabbitTemplate;
    private final FanoutExchange fanoutExchange;

    public void notifyStudentDelete(String studentId) {
        rabbitTemplate.convertAndSend(
                fanoutExchange.getName(),
                studentId,
                new StudentDeleteEvent(studentId));
    }
}
