package ie.tus.eng.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ie.tus.eng.student.model.Student;

public interface StudentRepository extends JpaRepository<Student,Long>{

	
	//Course findByCode(String code);

}
