package repository;

import domain.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import validation.StudentValidator;

import java.util.concurrent.atomic.AtomicInteger;

class StudentRepositoryTest {
    StudentValidator studentValidator = new StudentValidator();
    StudentRepository studentRepository = new StudentRepository(studentValidator);

    @BeforeEach
    void setUp() {
        studentRepository = new StudentRepository(studentValidator);
    }

    @Test
    void save(){
        saveValidStudent_addsStudentToRepository();
        saveDuplicateIdStudent_doesNotAddStudentToRepository();
    }

    @Test
    void saveDuplicateIdStudent_doesNotAddStudentToRepository() {
        Student student = new Student("1", "test_name", 932, "test@mail.com");
        Student student2 = new Student("1", "second_student", 832, "student2@mail.com");

        studentRepository.save(student);
        assert(studentRepository.save(student2).equals(student));

        AtomicInteger numberOfStudents = new AtomicInteger();
        studentRepository.findAll().forEach(e -> numberOfStudents.addAndGet(1));

        assert(numberOfStudents.get() == 1);
    }

    @Test
    void saveValidStudent_addsStudentToRepository() {
        Student student = new Student("1", "test_name", 932, "test@mail.com");
        assert(studentRepository.save(student) == null);

        AtomicInteger numberOfStudents = new AtomicInteger();
        studentRepository.findAll().forEach(e -> numberOfStudents.addAndGet(1));

        assert(numberOfStudents.get() == 1);
    }

    @Test
    void WBTsaveStudent_addsStudentToRepository(){

    }
}