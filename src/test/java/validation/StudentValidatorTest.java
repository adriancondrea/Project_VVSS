package validation;

import domain.Student;
import org.junit.jupiter.api.Test;

class StudentValidatorTest {
    StudentValidator validator = new StudentValidator();

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void validate() {
        nullStudentId_throwsException();
        emptyStudentId_throwsException();

        nullStudentName_throwsException();
        emptyStudentName_throwsException();

        nullStudentEmail_throwsException();
        emptyStudentEmail_throwsException();

        outOfBoundsStudentGroup_throwsException();
        invalidStudentGroupSecondDigit_throwsException();
        invalidStudentGroupLastDigit_throwsException();

        validStudent_throwsNoException();
    }

    @Test
    void invalidStudentGroupLastDigit_throwsException() {
        Student student = new Student("1", "test_name", 930, "test@mail.com");
        try {
            this.validator.validate(student);
            assert false;
        } catch (Exception e) {
            assert true;
        }
    }

    @Test
    void validStudent_throwsNoException() {
        Student student = new Student("1", "test_name", 932, "test@mail.com");
        try {
            this.validator.validate(student);
            assert true;
        } catch (Exception e) {
            assert false;
        }
    }

    @Test
    void nullStudentId_throwsException() {
        Student student = new Student(null, "test_name", 932, "test@mail.com");
        try {
            this.validator.validate(student);
            assert false;
        } catch (Exception e) {
            assert true;
        }
    }

    @Test
    void emptyStudentId_throwsException() {
        Student student = new Student("", "test_name", 932, "test@mail.com");
        try {
            this.validator.validate(student);
            assert false;
        } catch (Exception e) {
            assert true;
        }
    }

    @Test
    void emptyStudentName_throwsException() {
        Student student = new Student("1", "", 932, "test@mail.com");
        try {
            this.validator.validate(student);
            assert false;
        } catch (Exception e) {
            assert true;
        }
    }

    @Test
    void nullStudentName_throwsException() {
        Student student = new Student("123", null, 932, "test@mail.com");
        try {
            this.validator.validate(student);
            assert false;
        } catch (Exception e) {
            assert true;
        }
    }

    @Test
    void emptyStudentEmail_throwsException() {
        Student student = new Student("1", "test", 932, "");
        try {
            this.validator.validate(student);
            assert false;
        } catch (Exception e) {
            assert true;
        }
    }

    @Test
    void nullStudentEmail_throwsException() {
        Student student = new Student("123", "test", 932, null);
        try {
            this.validator.validate(student);
            assert false;
        } catch (Exception e) {
            assert true;
        }
    }

    @Test
    void outOfBoundsStudentGroup_throwsException() {
        Student student = new Student("123", "test", 999, "test@mail.com");
        try {
            this.validator.validate(student);
            assert false;
        } catch (Exception e) {
            assert true;
        }
    }

    @Test
    void invalidStudentGroupSecondDigit_throwsException() {
        Student student = new Student("123", "test", 892, "test@mail.com");
        try {
            this.validator.validate(student);
            assert false;
        } catch (Exception e) {
            assert true;
        }
    }
}