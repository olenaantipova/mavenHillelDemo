package ua.hillel;

import org.junit.jupiter.api.*;

import java.time.format.DateTimeParseException;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DateConverterTest {

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
    @Order(3)
    public void testGetKnowDateFormat() {
        String dateStr = "2023-11-01";
        String expectedFormat = "yyyy-MM-dd";
        String detectedFormat = DateConverter.detectDateFormat(dateStr);
        assertEquals(expectedFormat, detectedFormat);
    }

    @Test
    @Order(2)
    public void testConvertDate() {
        String inputDate = "01-11-2023";
        String inputFormat = "dd-MM-yyyy";
        String outputFormat = "yyyy-MM-dd";
        String expectedOutput = "2023-11-01";

        String convertedDate = DateConverter.convertDate(inputDate, inputFormat, outputFormat);
        assertEquals(expectedOutput, convertedDate);
    }

    @Test
    @Order(1)
    public void testDetectDateFormatText() {
        String dateStr = "01 November 2023";
        String expectedFormat = "dd MMMM yyyy";
        String detectedFormat = DateConverter.detectDateFormat(dateStr);

        assertEquals(expectedFormat, detectedFormat);
    }
}