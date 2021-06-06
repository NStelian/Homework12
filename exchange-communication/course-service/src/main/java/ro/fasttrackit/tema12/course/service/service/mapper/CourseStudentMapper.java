package ro.fasttrackit.tema12.course.service.service.mapper;

import org.springframework.stereotype.Service;
import ro.fasttrackit.tema12.course.service.model.entity.CourseStudent;
import ro.fasttrackit.tema12.course.service.model.request.CourseStudentRequestDto;
import ro.fasttrackit.tema12.course.service.model.response.CourseStudentResponseDto;

@Service
public class CourseStudentMapper {
    public CourseStudent mapCourseStudentRequestDtoToEntity(String courseId, CourseStudentRequestDto request) {
        CourseStudent courseStudent = new CourseStudent();
        courseStudent.setCourseId(courseId);
        courseStudent.setStudentId(request.getStudentId());
        courseStudent.setGrade(request.getGrade());

        return courseStudent;
    }

    public CourseStudentResponseDto mapEntityToCourseStudentResponseDto(CourseStudent courseStudent) {
        CourseStudentResponseDto courseStudentResponseDto = new CourseStudentResponseDto();
        courseStudentResponseDto.setCourseStudentId(courseStudent.getCourseStudentId());
        courseStudentResponseDto.setCourseId(courseStudent.getCourseId());
        courseStudentResponseDto.setStudentId(courseStudent.getStudentId());
        courseStudentResponseDto.setGrade(courseStudent.getGrade());

        return courseStudentResponseDto;
    }
}
