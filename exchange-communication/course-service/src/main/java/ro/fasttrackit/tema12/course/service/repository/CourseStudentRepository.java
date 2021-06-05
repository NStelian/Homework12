package ro.fasttrackit.tema12.course.service.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ro.fasttrackit.tema12.course.service.model.entity.CourseStudent;

import java.util.List;

@Repository
public interface CourseStudentRepository extends MongoRepository<CourseStudent, String> {
    List<CourseStudent> findAllByCourseId(String courseId);
    void deleteCourseStudentsByStudentId(String studentId);
}
