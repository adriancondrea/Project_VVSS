package repository;

import domain.Tema;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import validation.TemaValidator;
import validation.ValidationException;

import java.util.concurrent.atomic.AtomicInteger;

class TemaRepositoryTest {

    TemaValidator temaValidator = new TemaValidator();
    TemaRepository temaRepository = new TemaRepository(temaValidator);

    @BeforeEach
    void setUp() {
        temaRepository = new TemaRepository(temaValidator);
    }

    @Test
    void save(){
        saveValidTema_addsTemaToRepository();
        saveDuplicateIdTema_doesNotAddTemaToRepository();
    }

    @Test
    void saveDuplicateIdTema_doesNotAddTemaToRepository() {
        Tema tema = new Tema("1", "test_description", 14, 1);
        Tema tema2 = new Tema("1", "test_description", 14, 4);

        temaRepository.save(tema);
        assert(temaRepository.save(tema2).equals(tema));

        AtomicInteger numberOfAssignments = new AtomicInteger();
        temaRepository.findAll().forEach(e -> numberOfAssignments.addAndGet(1));

        assert(numberOfAssignments.get() == 1);
    }

    @Test
    void saveValidTema_addsTemaToRepository() {
        Tema tema = new Tema("1", "test_description", 14, 1);
        assert(temaRepository.save(tema) == null);

        AtomicInteger numberOfStudents = new AtomicInteger();
        temaRepository.findAll().forEach(e -> numberOfStudents.addAndGet(1));

        assert(numberOfStudents.get() == 1);
    }

    @Test
    void saveInvalidTema_throwsException() {
        Tema tema = new Tema("", "description", 14, 1);
        try {
            temaRepository.save(tema);
        } catch (ValidationException e) {
            assert (e.getMessage().equals("ID invalid! \n"));
        }
    }

    @Test
    void WBTsaveStudent_addsStudentToRepository(){

    }
}