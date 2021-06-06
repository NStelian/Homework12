package ro.fasttrackit.tema12.course.service.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.fasttrackit.tema12.course.service.model.entity.CourseStudent;
import ro.fasttrackit.tema12.course.service.model.request.CourseStudentRequestDto;
import ro.fasttrackit.tema12.course.service.model.response.CourseStudentResponseDto;
import ro.fasttrackit.tema12.course.service.repository.CourseStudentRepository;
import ro.fasttrackit.tema12.course.service.service.mapper.CourseStudentMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CourseStudentService {
    private final CourseStudentRepository courseStudentRepository;
    private final CourseStudentMapper courseStudentMapper;

    public List<String> getAllStudentsForCourseId(String courseId) {
        List<CourseStudent> courseStudents = courseStudentRepository.findAllByCourseId(courseId);

        return courseStudents
                .stream()
                .map(CourseStudent::getStudentId)
                .collect(Collectors.toList());
    }

    public CourseStudentResponseDto registerStudentToCourse(String courseId, CourseStudentRequestDto request) {
        CourseStudent courseStudent = courseStudentRepository.save(courseStudentMapper.mapCourseStudentRequestDtoToEntity(courseId, request));
        return courseStudentMapper.mapEntityToCourseStudentResponseDto(courseStudent);
    }

    public List<CourseStudent> getAllCourseStudents() {
        return courseStudentRepository.findAll();
    }
}
