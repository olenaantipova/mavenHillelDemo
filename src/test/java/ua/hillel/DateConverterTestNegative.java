package ua.hillel;

import org.junit.jupiter.api.*;

import java.time.format.DateTimeParseException;
import java.util.ConcurrentModificationException;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DateConverterTestNegative {
    @BeforeAll
    static void start() {
        System.out.println("Testing starts");
    }

    @AfterAll
    static void finish() {
        System.out.println("Testing finished");
    }

    @BeforeEach
    void startEach() {
        System.out.println("Test starts at: " + new Date().getTime());
    }

    @AfterEach
    void finishEach() {
        System.out.println("Test finished");
    }

    @Test
    @Order(1)
    public void testInvalidInputDateFormat (){
        String invalidDate = "2023-11-03";
        String inputFormat = "ddd-MM-yyyy";
        String outputFormat = "MM/dd/yyyy";
        assertThrows(DateTimeParseException.class, () -> {
            DateConverter.convertDate(invalidDate,inputFormat,outputFormat);
        });
    }
    @Order(3)
    @Test
    public void testConvertDateWithInvalidDateValue() {
        assertEquals("2023-11-01", "2023-11-45");
    }

    @Order(2)
    @Test
    public void testDetectDateFormatFailure() {
        String invalidDate = "03-11-2023";
        assertNull(DateConverter.detectDateFormat(invalidDate));
    }
}
