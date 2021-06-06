package ro.fasttrackit.tema12.course.service.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.fasttrackit.tema12.course.service.controller.exceptions.EntityNotFoundException;
import ro.fasttrackit.tema12.course.service.model.entity.Course;
import ro.fasttrackit.tema12.course.service.model.request.CourseRequestDto;
import ro.fasttrackit.tema12.course.service.model.response.CourseResponseDto;
import ro.fasttrackit.tema12.course.service.repository.CourseRepository;
import ro.fasttrackit.tema12.course.service.service.mapper.CourseMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;

    public List<CourseResponseDto> getAll() {
        return courseMapper.mapEntityListToResponseDto(courseRepository.findAll());
    }

    public CourseResponseDto addCourse(CourseRequestDto request) {
        Course course = courseRepository.save(courseMapper.mapRequestDtoToEntity(request));
        return courseMapper.mapEntityToResponseDto(course);
    }

    public CourseResponseDto getCourseById(String courseId) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new EntityNotFoundException("Course with id " + courseId + " not Found"));

        return courseMapper.mapEntityToResponseDto(course);
    }
}
