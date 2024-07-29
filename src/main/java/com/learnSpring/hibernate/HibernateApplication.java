package com.learnSpring.hibernate;
import ch.qos.logback.core.joran.spi.NoAutoStartUtil;
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
//			createMultipleStudents(studentDao);
			System.out.println("Looking for student with id 3");
			Student foundStudent = findAStudent(studentDao, 3);
			System.out.println(foundStudent);
		};
	}

	public Student findAStudent(StudentDao dao, int id) {
		return dao.findById(id);
	}

	public void createStudent(StudentDao dao) {
		Student firstStudent = new Student("Alain", "Minc", "alain.minc@gmail.com");
		dao.save(firstStudent);
		System.out.println("Student " + firstStudent.getFirstName() + "Added");
	}

	public void createMultipleStudents(StudentDao dao) {
		Student student1 = new Student("Alain", "Minc", "alain.minc@gmail.com");
		Student student2 = new Student("Gaby", "attal", "gaby.attal@gmail.com");
		Student student3 = new Student("Emmy", "Macron", "emmy.macron@gmail.com");
		dao.save(student1);
		dao.save(student2);
		dao.save(student3);
		System.out.println("The three students were added");
	}




}



