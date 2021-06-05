package ro.fasttrackit.tema12.course.service.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.fasttrackit.tema12.course.service.model.entity.CourseStudent;
import ro.fasttrackit.tema12.course.service.repository.CourseStudentRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CourseStudentService {
    private final CourseStudentRepository courseStudentRepository;

    public List<String> getAllStudentsForCourseId(String courseId) {
        List<CourseStudent> courseStudents = courseStudentRepository.findAllByCourseId(courseId);

        return courseStudents
                .stream()
                .map(CourseStudent::getStudentId)
                .collect(Collectors.toList());
    }

    public CourseStudent registerStudentToCourse(String courseId, CourseStudent courseStudent) {
        courseStudent.setCourseId(courseId);
        return courseStudentRepository.save(courseStudent);
    }

    public List<CourseStudent> getAllCourseStudents() {
        return courseStudentRepository.findAll();
    }
}
