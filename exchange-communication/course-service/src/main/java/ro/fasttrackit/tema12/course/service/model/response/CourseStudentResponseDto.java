package ro.fasttrackit.tema12.course.service.model.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseStudentResponseDto {
    private String courseStudentId;
    private String courseId;
    private String studentId;
    private int grade;
}
