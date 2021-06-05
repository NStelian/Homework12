package ro.fasttrackit.tema12.course.service.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ro.fasttrackit.tema12.course.service.controller.exceptions.EntityNotFoundException;
import ro.fasttrackit.tema12.course.service.service.CourseService;
import ro.fasttrackit.tema12.course.service.model.entity.Course;

import java.util.List;


@RestController
@RequestMapping("courses")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;

    @GetMapping
    List<Course> getAll() {
        return courseService.getAll();
    }

    @PostMapping
    Course addCourse(@RequestBody Course course) {
        return courseService.addCourse(course);
    }

    @GetMapping("{courseId}")
    Course getCourseById(@PathVariable String courseId) {
        return courseService.getCourseById(courseId)
                .orElseThrow(() -> new EntityNotFoundException("Course with id " + courseId + " not Found"));
    }
}
