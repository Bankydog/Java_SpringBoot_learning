package com.mergency.crudapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.mergency.crudapp.repository.PersonDAO;
import com.mergency.crudapp.entity.Person;
import java.util.List;

@SpringBootApplication
public class CrudappApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudappApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(PersonDAO dao) {
		return runner -> {
			updateDate(dao);
		};
	}

	public void saveData(PersonDAO dao) {
		Person obj1 = new Person("Belle", "Sora");
		dao.save(obj1);
		System.out.println("Insert Complete");
	}

	public void deleteData(PersonDAO dao) {
		int id = 2;
		dao.delete(id);
		System.out.println("Delete Complete");
	}

	public void getDAta(PersonDAO dao) {
		int id = 4;
		Person person = dao.get(id);
		System.out.println(person);
	}

	public void getAllData(PersonDAO dao) {
		List<Person> data = dao.getAll();
		for (Person person : data) {
			System.out.println(person);
		}
	}

	public void updateDate(PersonDAO dao) {
		int id = 3;
		Person myPerson = dao.get(id);
		myPerson.setFname("BOWW");
		myPerson.setLname("SUTHIDA");
		dao.update(myPerson);
		System.out.println("Update Compelete");
	}
}
