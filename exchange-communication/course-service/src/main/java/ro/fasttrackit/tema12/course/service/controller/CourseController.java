package ro.fasttrackit.tema12.course.service.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ro.fasttrackit.tema12.course.service.controller.exceptions.EntityNotFoundException;
import ro.fasttrackit.tema12.course.service.model.request.CourseRequestDto;
import ro.fasttrackit.tema12.course.service.model.response.CourseResponseDto;
import ro.fasttrackit.tema12.course.service.service.CourseService;
import ro.fasttrackit.tema12.course.service.model.entity.Course;

import java.util.List;


@RestController
@RequestMapping("courses")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;

    @GetMapping
    List<CourseResponseDto> getAll() {
        return courseService.getAll();
    }

    @PostMapping
    CourseResponseDto addCourse(@RequestBody CourseRequestDto course) {
        return courseService.addCourse(course);
    }

    @GetMapping("{courseId}")
    CourseResponseDto getCourseById(@PathVariable String courseId) {
        return courseService.getCourseById(courseId);
    }
}
