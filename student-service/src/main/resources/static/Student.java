package ie.tus.eng.student.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "students")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long studentId;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String birthDate;

	@Column(nullable = false)
	private Long courseId;

	public Student(Long studentId, String name, String birthDate, Long courseId) {
		super();
		this.studentId = studentId;
		this.name = name;
		this.birthDate = birthDate;
		this.courseId = courseId;
	}

	public Student() {
	}

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", name=" + name + ", birthDate=" + birthDate + ", courseId="
				+ courseId + "]";
	}

}
