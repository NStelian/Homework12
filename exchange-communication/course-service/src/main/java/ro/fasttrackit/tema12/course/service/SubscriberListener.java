package ro.fasttrackit.tema12.course.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import ro.fasttrackit.tema12.course.service.repository.CourseStudentRepository;
import ro.fasttrackit.tema12.model.StudentEvent;

@Slf4j
@Service
@RequiredArgsConstructor
public class SubscriberListener {
    private final CourseStudentRepository courseStudentRepository;

    @RabbitListener(queues = "#{fanoutQueue.name}")
    void fanoutListener(StudentEvent event) {
        log.info("Delete Student Courses by studentId: " + event.getStudentId());
        courseStudentRepository.deleteCourseStudentsByStudentId(event.getStudentId());
    }
}
