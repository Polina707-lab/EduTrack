
package ru.polina.edutrack;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.polina.edutrack.config.SpringConfig;
import ru.polina.edutrack.model.Student;
import ru.polina.edutrack.service.StudentService;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try (AnnotationConfigApplicationContext context =
                     new AnnotationConfigApplicationContext(SpringConfig.class)) {

            StudentService service = context.getBean(
                    "student_service_id", StudentService.class
            );

            service.printWelcomeMessage();

            // Создание тестовых учеников
            Student student1 = new Student(1, "Ivan", "Ivanov", "10A");
            Student student2 = new Student(2, "Anna", "Petrova", "10A");
            Student student3 = new Student(3, "Petr", "Sidorov", "11B");

            service.addStudent(student1);
            service.addStudent(student2);
            service.addStudent(student3);

            // Вывод всех учеников
            System.out.println("\nСписок учеников:");

            for (Student student : service.getAllStudents()) {
                System.out.println(student);
            }

            Scanner scan = new Scanner(System.in);

            // Поиск ученика по ID
            System.out.println("\nПоиск ученика по ID -------");
            System.out.print("Введите ID ученика для поиска: ");

            int id = scan.nextInt();
            scan.nextLine();

            Student foundStudent = service.findById(id);

            if (foundStudent != null) {
                System.out.println("Найден ученик: " + foundStudent);
            } else {
                System.out.println("Ученик с таким ID не найден.");
            }

            // Добавление нового ученика
            System.out.println("\nДобавление ученика -------");
            System.out.println("Введите данные ученика:");

            System.out.print("Имя: ");
            String firstName = scan.nextLine().trim();

            System.out.print("Фамилия: ");
            String lastName = scan.nextLine().trim();

            System.out.print("Класс: ");
            String className = scan.nextLine().trim();

            // Определяем следующий ID
            List<Student> students = service.getAllStudents();

            int maxId = 0;

            for (Student student : students) {
                if (student.getId() > maxId) {
                    maxId = student.getId();
                }
            }

            int newId = maxId + 1;

            Student addedStudent = new Student(
                    newId, firstName, lastName, className
            );

            if (service.addStudent(addedStudent)) {
                System.out.println("Ученик успешно добавлен!");
            } else {
                System.out.println("Не удалось добавить ученика.");
            }

            // Вывод обновлённого списка
            System.out.println("\nОбновлённый список учеников:");

            for (Student student : service.getAllStudents()) {
                System.out.println(student);
            }
        }
    }
}
