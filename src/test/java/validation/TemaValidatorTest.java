package validation;

import domain.Tema;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TemaValidatorTest {
    TemaValidator temaValidator = new TemaValidator();

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void temaIdNull_throwsException() {
        Tema tema = new Tema(null, "description", 14, 1);
        try {
            this.temaValidator.validate(tema);
            assert false;
        } catch (Exception e) {
            assert true;
        }
    }

    @Test
    void temaIdEmpty_throwsException() {
        Tema tema = new Tema("", "description", 14, 1);
        try {
            this.temaValidator.validate(tema);
            assert false;
        } catch (Exception e) {
            assert true;
        }
    }

    @Test
    void temaDescriereNull_throwsException() {
        Tema tema = new Tema("1", null, 14, 1);
        try {
            this.temaValidator.validate(tema);
            assert false;
        } catch (Exception e) {
            assert true;
        }
    }

    @Test
    void temaDescriereEmpty_throwsException() {
        Tema tema = new Tema("1", "", 14, 1);
        try {
            this.temaValidator.validate(tema);
            assert false;
        } catch (Exception e) {
            assert true;
        }
    }

    @Test
    void temaDeadlineLessThanLowerBound_throwsException() {
        Tema tema = new Tema("1", "description", 0, 1);
        try {
            this.temaValidator.validate(tema);
            assert false;
        } catch (Exception e) {
            assert true;
        }
    }

    @Test
    void temaDeadlineGreaterThanUpperBound_throwsException() {
        Tema tema = new Tema("1", "description", 15, 1);
        try {
            this.temaValidator.validate(tema);
            assert false;
        } catch (Exception e) {
            assert true;
        }
    }

    @Test
    void temaDeadlineSmallerThanStartline_throwsException() {
        Tema tema = new Tema("1", "description", 1, 3);
        try {
            this.temaValidator.validate(tema);
            assert false;
        } catch (Exception e) {
            assert true;
        }
    }

    @Test
    void temaStartlineLessThanLowerBound_throwsException() {
        Tema tema = new Tema("1", "description", 14, 0);
        try {
            this.temaValidator.validate(tema);
            assert false;
        } catch (Exception e) {
            assert true;
        }
    }

    @Test
    void temaStartlineGreaterThanUpperBound_throwsException() {
        Tema tema = new Tema("1", "description", 14, 15);
        try {
            this.temaValidator.validate(tema);
            assert false;
        } catch (Exception e) {
            assert true;
        }
    }

    @Test
    void temaStartlineGraterThanDeadline_throwsException() {
        Tema tema = new Tema("1", "description", 7, 10);
        try {
            this.temaValidator.validate(tema);
            assert false;
        } catch (Exception e) {
            assert true;
        }
    }

    @Test
    void temaValid_throwsNoException() {
        Tema tema = new Tema("1", "description", 14, 1);
        try {
            this.temaValidator.validate(tema);
            assert true;
        } catch (Exception e) {
            assert false;
        }
    }
}