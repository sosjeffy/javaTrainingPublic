package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import static java.lang.System.exit;
@SpringBootApplication
public class DemoApplication {
	@Autowired
	EmployeeRepository employeeRepository;

	@EventListener(ApplicationReadyEvent.class)
	public void exampleEmployeeRepositoryUsage() {
		employeeRepository.clearDatabase();
		System.out.print("Initial state of database: ");
		if (employeeRepository.getEmployees().isEmpty()) System.out.println("Empty database");

		System.out.println("Inserted John Employee. Current Database elements: ");
		employeeRepository.insertEmployee(new Employee(1, "John", "Developer"));
		employeeRepository.getEmployees().forEach(System.out::println);

		System.out.println("Adding a bunch of employees...DB is now: ");
		employeeRepository.insertEmployee(new Employee(2, "Bobby", "Human Managementer"));
		employeeRepository.insertEmployee(new Employee(3, "Maria", "President"));
		employeeRepository.insertEmployee(new Employee(4, "Bobby", "Intern"));
		employeeRepository.getEmployees().forEach(System.out::println);

		System.out.println("Clearing DB...");
		employeeRepository.clearDatabase();
		System.out.print("State of database: ");
		if (employeeRepository.getEmployees().isEmpty()) System.out.println("Empty database");
		exit(0);
	}
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
