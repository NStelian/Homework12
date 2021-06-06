package ro.fasttrackit.tema12.course.service.model.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseStudentRequestDto {
    private String studentId;
    private int grade;
}
