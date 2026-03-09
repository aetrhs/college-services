package ie.tus.eng.course.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import ie.tus.eng.course.model.Course;
import ie.tus.eng.course.repository.CourseRepository;

@RestController
@RequestMapping("/courses")
public class CourseController {
	private final CourseRepository repository;

	public CourseController(CourseRepository repository) {
		this.repository = repository;
	}

	@GetMapping
	public List<Course> retrieveAllCourses() {
		return repository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Course> retrieveOneCourse(@PathVariable long id) {
		Optional<Course> course = repository.findById(id);
		if (course.isEmpty()) {
			System.out.println("Course not found in database");
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(course.get());
		}
	}


	@PostMapping
	public ResponseEntity<Course> createCourse(@RequestBody Course course) {
		Course savedCourse = repository.save(course);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedCourse.getCourseId()).toUri();
		return ResponseEntity.created(location).build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCourse(@PathVariable long id) {
		Optional<Course> course = repository.findById(id);
		if (course.isPresent()) {
			repository.deleteById(id);
			System.out.println("Course deleted!");
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping
	public ResponseEntity<Void> deleteAllCourses() {
		repository.deleteAll();
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Course> editCourse(@PathVariable long id, @RequestBody Course course){
		if (repository.findById(id).isPresent()) {
			repository.saveAndFlush(course);
			System.out.println("Course edited!");
			return ResponseEntity.ok(course);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
