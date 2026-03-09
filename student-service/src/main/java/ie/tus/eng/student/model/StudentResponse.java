package ie.tus.eng.student.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import ie.tus.eng.student.course.Course;

@JsonPropertyOrder({
	"id",
	"name",
	"birthDate",
	"course"
})

public class StudentResponse {
	private int id;
	private String name;
	private LocalDate birthDate;
	private Course course;
	
	public StudentResponse() {
		super();
	}

	public StudentResponse(Student student, Course course) {
		super();
		this.id = student.getStudentId();
		this.name = student.getName();
		this.birthDate = student.getBirthDate();
		this.course = course;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "StudentResponse [id=" + id + ", name=" + name + ", birthDate=" + birthDate + ", course=" + course + "]";
	}
	
	
}
