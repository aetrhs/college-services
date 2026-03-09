package ie.tus.eng.student.controller;

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

import ie.tus.eng.student.course.Course;
import ie.tus.eng.student.course.CourseClient;
import ie.tus.eng.student.model.Student;
import ie.tus.eng.student.model.StudentResponse;
import ie.tus.eng.student.repository.StudentRepository;

@RestController
@RequestMapping("/students")
public class StudentController {

	private final StudentRepository repository;
	private CourseClient courseClient;

	public StudentController(StudentRepository repository, CourseClient courseClient) {
		super();
		this.repository = repository;
		this.courseClient = courseClient;
	}

	@GetMapping
	public List<Student> getAllStudents() {
		return repository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<StudentResponse> getOneStudent(@PathVariable long id) {
		Optional<Student> student = repository.findById(id);

		if (student.isEmpty()) {
			System.out.println("Student not found in database");
			return ResponseEntity.notFound().build();
		} else {
			Course course = courseClient.getCourseById(student.get().getCourseId());
			StudentResponse studentResponse = new StudentResponse(student.get(), course);
			return ResponseEntity.ok(studentResponse);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteStudent(@PathVariable long id) {
		Optional<Student> student = repository.findById(id);

		if (student.isEmpty()) {
			System.out.println("Student not found in database");
			return ResponseEntity.notFound().build();
		} else {
			repository.deleteById(id);
			return ResponseEntity.noContent().build();
		}
	}

	@DeleteMapping
	public ResponseEntity<Void> deleteAllStudents() {
		repository.deleteAll();
		return ResponseEntity.noContent().build();
	}

	@PostMapping
	public ResponseEntity<Student> createStudent(@RequestBody Student student, Course course) {

		Student savedStudent = repository.save(student);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedStudent.getStudentId()).toUri();
		return ResponseEntity.created(location).build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Student> editStudent(@RequestBody Student student) {

		repository.save(student);
		return ResponseEntity.ok().build();

	}

}
