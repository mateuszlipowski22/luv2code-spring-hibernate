package com.luv2code.crud;

import com.luv2code.crud.dao.StudentDAO;
import com.luv2code.crud.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner ->{
//			createStudent(studentDAO);
			createMultipleStudents(studentDAO);
		};
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
