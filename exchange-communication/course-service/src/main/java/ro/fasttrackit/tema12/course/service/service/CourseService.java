package ro.fasttrackit.tema12.course.service.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.fasttrackit.tema12.course.service.repository.CourseRepository;
import ro.fasttrackit.tema12.course.service.model.entity.Course;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;

    public List<Course> getAll() {
        return courseRepository.findAll();
    }

    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }

    public Optional<Course> getCourseById(String courseId) {
        return courseRepository.findById(courseId);
    }
}
