package ie.tus.eng.student.course;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

public class Course {

	private Long courseId;
	private String name;
	private String code;

	public Course(Long courseId, String name, String code) {
		super();
		this.courseId = courseId;
		this.name = name;
		this.code = code;
	}

	public Course() { // no args constructor needed by JPA
		super();
	}

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", name=" + name + ", code=" + code + "]";
	}
	
	
}
