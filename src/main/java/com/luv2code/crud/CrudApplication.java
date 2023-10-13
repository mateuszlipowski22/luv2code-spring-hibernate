package com.luv2code.crud;

import com.luv2code.crud.dao.StudentDAO;
import com.luv2code.crud.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner ->{
//			createStudent(studentDAO);
//			createMultipleStudents(studentDAO);
//			readStudent(studentDAO);
//			queryForStudents(studentDAO);
//			queryForStudentsByLastName(studentDAO);
//			updateStudent(studentDAO);
//			deleteStudent(studentDAO);
			deleteAllStudents(studentDAO);


		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleting all students");
		int numberRowsDeleted = studentDAO.deleteAll();
		System.out.println("Deleted row count: "+numberRowsDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int idStudent = 3;
		System.out.println("Deleting the student with id = "+idStudent);
		studentDAO.delete(idStudent);
	}

	private void updateStudent(StudentDAO studentDAO) {
		int idStudent = 1;
		System.out.println("Getting student with id : "+idStudent);
		Student student = studentDAO.findById(idStudent);
		System.out.println("Updating student");
		student.setFirstName("Scooby");
		studentDAO.update(student);
		System.out.println("Updated student: "+student);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		List<Student> theStudents = studentDAO.findAllByLastName("Duck");
		theStudents.forEach(System.out::println);
	}

	private void queryForStudents(StudentDAO studentDAO) {
		List<Student> theStudents = studentDAO.findAll();
		theStudents.forEach(System.out::println);
	}

	private void readStudent(StudentDAO studentDAO) {
		System.out.println("Creating new student object...");
		Student tempStudent = new Student("Duffy", "Duck", "duffy@yahoo.pl");
		System.out.println("Saving the stundent...");
		studentDAO.save(tempStudent);
		System.out.println("Student saved. Generated id = "+tempStudent.getId());
		System.out.println("Retriving student with id = "+tempStudent.getId());
		Student myStudent = studentDAO.findById(tempStudent.getId());
		System.out.println("Found the student: "+myStudent);

	}

	private void createMultipleStudents(StudentDAO studentDAO) {

		System.out.println("Creating 3 new student objects...");
		Student tempStudent1 = new Student("John", "Doe", "john@yahoo.pl");
		Student tempStudent2 = new Student("Mary", "Public", "marypublich@yahoo.pl");
		Student tempStudent3 = new Student("Bonita", "Apple", "jBonita@yahoo.pl");
		System.out.println("Saving students ...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent3);
		studentDAO.save(tempStudent2);

	}

	private void createStudent(StudentDAO studentDAO) {
		System.out.println("Creating new student object...");
		Student tempStudent = new Student("Joe", "Smith", "joe.smith@yahoo.pl");
		System.out.println("Saving the stundent...");
		studentDAO.save(tempStudent);
		System.out.println("Student saved. Generated id = "+tempStudent.getId());
	}

}
