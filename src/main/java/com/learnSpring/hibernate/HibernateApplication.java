package com.learnSpring.hibernate;
import ch.qos.logback.core.joran.spi.NoAutoStartUtil;
import com.learnSpring.hibernate.dao.StudentDao;
import com.learnSpring.hibernate.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.Lifecycle;
import org.springframework.context.annotation.Bean;
import java.util.List;

@SpringBootApplication
public class HibernateApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernateApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(StudentDao studentDao) {
		return runner -> {
//			createMultipleStudents(studentDao);
//			System.out.println("printing all students");
//			getAllStudents(studentDao);
//			getStudentByLastName(studentDao, "Macron");
			changeLastName(studentDao, 1, "Merkel");
		};
	}

	public void changeLastName(StudentDao dao, int id, String newName) {
		dao.update(id, newName);
	}

	public void getStudentByLastName(StudentDao dao, String someStudent) {
		List<Student> students = dao.findByLastName(someStudent);
		for (Student student: students ) {
			System.out.println(student);
		}

	}

	public void getAllStudents(StudentDao dao) {
		List<Student> students = dao.findAll();
		for (Student student: students) {
			System.out.println(student);
		}
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



