package validation;

import domain.Tema;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TemaValidatorTest {
    TemaValidator temaValidator = new TemaValidator();
    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void temaIdNull_throwsException(){
        Tema tema = new Tema(null,"asa",10,1);
        try {
            this.temaValidator.validate(tema);
            assert false;
        } catch (Exception e) {
            assert true;
        }
    }

    @Test
    void temaIdEmpty_throwsException(){
        Tema tema = new Tema("","asa",10,1);
        try {
            this.temaValidator.validate(tema);
            assert false;
        } catch (Exception e) {
            assert true;
        }
    }
    @Test
    void temaIdValid_doesNotThrowException(){

    }


    @Test
    void temaDescriereNull_throwsException(){

    }

    @Test
    void temaDescriereEmpty_throwsException(){

    }
    @Test
    void temaDescriereValid_doesNotThrowException(){

    }


    @Test
    void temaDeadlineLessThanLowerBound_throwsException(){

    }

    @Test
    void temaDeadlineGreaterThanUpperBound_throwsException(){

    }

    @Test
    void temaDeadlineSmallerThanStartline_throwsException(){

    }

    @Test
    void temaDeadlineValid_doesNotThrowException(){

    }
}