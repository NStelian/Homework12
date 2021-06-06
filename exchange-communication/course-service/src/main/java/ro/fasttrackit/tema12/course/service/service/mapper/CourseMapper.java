package ro.fasttrackit.tema12.course.service.service.mapper;

import org.springframework.stereotype.Service;
import ro.fasttrackit.tema12.course.service.model.entity.Course;
import ro.fasttrackit.tema12.course.service.model.request.CourseRequestDto;
import ro.fasttrackit.tema12.course.service.model.response.CourseResponseDto;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseMapper {
    public List<CourseResponseDto> mapEntityListToResponseDto(List<Course> entities) {
        return entities.stream()
                .map(this::mapEntityToResponseDto)
                .collect(Collectors.toList());
    }

    public CourseResponseDto mapEntityToResponseDto(Course entity) {
        CourseResponseDto courseResponseDto = new CourseResponseDto();
        courseResponseDto.setCourseId(entity.getCourseId());
        courseResponseDto.setDiscipline(entity.getDiscipline());
        courseResponseDto.setDescription(entity.getDescription());

        return courseResponseDto;
    }

    public Course mapRequestDtoToEntity(CourseRequestDto request) {
        Course course = new Course();
        course.setDiscipline(request.getDiscipline());
        course.setDescription(request.getDescription());

        return course;
    }
}
