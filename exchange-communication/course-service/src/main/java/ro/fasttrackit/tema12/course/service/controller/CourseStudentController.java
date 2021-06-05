package ro.fasttrackit.tema12.course.service.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ro.fasttrackit.tema12.course.service.model.entity.CourseStudent;
import ro.fasttrackit.tema12.course.service.service.CourseStudentService;

import java.util.List;

@RestController
@RequestMapping("course")
@RequiredArgsConstructor
public class CourseStudentController {
    private final CourseStudentService courseStudentService;

    @GetMapping("/students")
    List<CourseStudent> getAllCourseStudents() {
        return courseStudentService.getAllCourseStudents();
    }

    @GetMapping("{courseId}/students")
    List<String> getAllStudentsForCourseId(@PathVariable String courseId) {
        return courseStudentService.getAllStudentsForCourseId(courseId);
    }

    @PostMapping("{courseId}/students")
    CourseStudent registerStudentToCourse(@PathVariable String courseId, @RequestBody CourseStudent courseStudent) {
        return courseStudentService.registerStudentToCourse(courseId, courseStudent);
    }
}
