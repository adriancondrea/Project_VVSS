package service;

import domain.Tema;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.NotaXMLRepository;
import repository.StudentXMLRepository;
import repository.TemaRepository;
import validation.NotaValidator;
import validation.StudentValidator;
import validation.TemaValidator;

import static org.junit.jupiter.api.Assertions.*;

class ServiceTest {

    TemaValidator temaValidator = new TemaValidator();
    TemaRepository temaRepository = new TemaRepository(temaValidator);
    StudentXMLRepository fileRepository1 = new StudentXMLRepository(new StudentValidator(), "studenti.xml");
    NotaXMLRepository fileRepository3 = new NotaXMLRepository(new NotaValidator(), "note.xml");
    Service service = new Service(fileRepository1, temaRepository, fileRepository3);
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
}