package service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.NotaRepository;
import repository.StudentRepository;
import repository.TemaRepository;
import validation.NotaValidator;
import validation.StudentValidator;
import validation.TemaValidator;

class ServiceTest {

    TemaValidator temaValidator = new TemaValidator();
    StudentValidator studentValidator = new StudentValidator();
    NotaValidator notaValidator = new NotaValidator();
    TemaRepository temaRepository = new TemaRepository(temaValidator);
    StudentRepository studentRepository = new StudentRepository(studentValidator);
    NotaRepository notaRepository = new NotaRepository(notaValidator);
    Service service = new Service(studentRepository, temaRepository, notaRepository);

    @BeforeEach
    void setUp() {

    }

    @Test
    void saveValidTema_TemaWasSaved() {
        assert (service.saveTema("1", "test_description", 14, 1) == 1);
    }

    @Test
    void saveValidTema_TemaWasNotSaved() {
        service.saveTema("1", "test_description", 14, 1);
        assert (service.saveTema("1", "test_description", 14, 1) == 0);
    }

    @Test
    void saveStudent_StudentWasSaved() {
        assert (service.saveStudent("1", "nume1", 932, "email@gmail.com") == 1);
    }

    @Test
    void saveStudentAndTema_StudentAndTema() {
        assert (service.saveStudent("1", "nume1", 932, "email@gmail.com") == 1);
        assert (service.saveTema("1", "test_description", 14, 1) == 1);
    }

    @Test
    void saveStudentAndTemaAndGrade_StudentAndTemaAndGrade() {
        assert (service.saveStudent("1", "nume1", 932, "email@gmail.com") == 1);
        assert (service.saveTema("1", "test_description", 14, 1) == 1);
        assert (service.saveNota("1","1",10.0,5,"feedback") == 1);
    }

}