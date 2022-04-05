package repository;

import domain.Nota;
import domain.Pair;
import domain.Student;
import domain.Tema;
import org.junit.jupiter.api.Test;
import validation.NotaValidator;
import validation.StudentValidator;
import validation.TemaValidator;

import java.util.concurrent.atomic.AtomicInteger;

public class IntegrationTest {

    StudentValidator studentValidator = new StudentValidator();
    StudentRepository studentRepository = new StudentRepository(studentValidator);

    TemaValidator temaValidator = new TemaValidator();
    TemaRepository temaRepository = new TemaRepository(temaValidator);

    NotaValidator notaValidator = new NotaValidator();
    NotaRepository notaRepository = new NotaRepository(notaValidator);

    @Test
    void allIntegration (){
        addStudent();
        addTema();
        addGrade();
    }
    @Test
    void addStudent(){
        Student student = new Student("1", "test_name", 932, "test@mail.com");
        assert(studentRepository.save(student) == null);

        AtomicInteger numberOfStudents = new AtomicInteger();
        studentRepository.findAll().forEach(e -> numberOfStudents.addAndGet(1));

        assert(numberOfStudents.get() == 1);
    }
    @Test
    void addGrade(){
        Nota nota = new Nota(new Pair<String, String>("1","1"), 10, 14, "all good");
        assert(notaRepository.save(nota) == null);

        AtomicInteger numberOfNote = new AtomicInteger();
        notaRepository.findAll().forEach(e -> numberOfNote.addAndGet(1));

        assert(numberOfNote.get() == 1);
    }
    @Test
    void addTema(){
        Tema tema = new Tema("1", "test_description", 14, 1);
        assert(temaRepository.save(tema) == null);

        AtomicInteger numberOfTeme = new AtomicInteger();
        temaRepository.findAll().forEach(e -> numberOfTeme.addAndGet(1));

        assert(numberOfTeme.get() == 1);
    }
}
