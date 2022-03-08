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
    }

    @Test
    void nullStudentId_throwsException() {
        Student student = new Student(null, "test_name", 932);
        try {
            this.validator.validate(student);
            assert false;
        } catch (Exception e) {
            assert true;
        }
    }

    @Test
    void nullStudentName_throwsException() {
        Student student = new Student("123", null, 932);
        try {
            this.validator.validate(student);
            assert false;
        } catch (Exception e) {
            assert true;
        }
    }
}