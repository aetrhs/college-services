package ie.tus.eng.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ie.tus.eng.course.model.Course;

// need to extend the JpaRepository interface
// 'Create a repo for the Course entity, whose primary key is a long'
public interface CourseRepository extends JpaRepository<Course, Long>{
	
	// can define a new method 'findByCode'
	// note the naming convention 'findBy' followed by column name capitalised
	Course findByCode(String code);
	
}
