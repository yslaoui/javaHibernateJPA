package com.learnSpring.hibernate;
import com.learnSpring.hibernate.dao.StudentDao;
import com.learnSpring.hibernate.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HibernateApplication {

	public static void main(String[] args) {

		SpringApplication.run(HibernateApplication.class, args);

	}

	@Bean
	CommandLineRunner commandLineRunner(StudentDao studentDao) {
		return runner -> {
			createStudent(studentDao);
		};
	}

	public void createStudent(StudentDao dao) {
		Student firstStudent = new Student("Alain", "Minc", "alain.minc@gmail.com");
		dao.save(firstStudent);
		System.out.println("Student " + firstStudent.getFirstName() + "Added");
	}



}
