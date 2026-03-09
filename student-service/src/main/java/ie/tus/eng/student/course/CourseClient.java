package ie.tus.eng.student.course;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name = "course-service", url = "http://localhost:8080")
@FeignClient(name = "course-service", url = "${course.service.url}")
public interface CourseClient {
	@GetMapping("/courses/{course_id}")
	Course getCourseById(@PathVariable long course_id);
}
