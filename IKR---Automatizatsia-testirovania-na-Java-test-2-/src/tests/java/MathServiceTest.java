import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MathServiceTest {
    static MathService mathService;

    @BeforeAll
    static void setUp() {
        mathService = new MathService();
    }


    @ParameterizedTest
    @CsvSource(value = {"3, -4, 2, -8"})
    @DisplayName("1.Test that discriminant < 0 ")
    void checkThanDLessZeroFirst(int a, int b, int c, int result) throws NotFoundAnswerException {
        int discriminant = mathService.getD(a, b, c);
        Assertions.assertEquals(result, discriminant);
    }

    @ParameterizedTest
    @CsvSource(value = {"-5, -12, 3, 204"})
    @DisplayName("2.Test that discriminant > 0 ")
    void checkThanDLessZeroSecond(int a, int b, int c, int result) {
        int discriminant = mathService.getD(a, b, c);
        Assertions.assertEquals(result, discriminant);
    }


    @ParameterizedTest
    @CsvSource(value = {"1,-6,9,0"})
    @DisplayName("2.Test that discriminant == 0 , has only one root number answer = 3")
    void testGetOneAnswerEqualZero(int a, int b, int c, int result) {
        int discriminant = mathService.getD(a, b, c);
        Assertions.assertEquals(result, discriminant);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,-4,-5,36"})
    @DisplayName("2.Test that discriminant > 0 , has two root number answer = 5 & -1")
    void testGetOneAnswerMoreZero(int a, int b, int c, int result) {
        int discriminant = mathService.getD(a, b, c);
        Assertions.assertEquals(result, discriminant);
    }

    @ParameterizedTest
    @DisplayName("2.Test that discriminant < 0 , has no root number answer -> Drop Exception !")
    @CsvSource(value = {"9,-6,2"})
    void testGetAnswerDecLessZeroNegative(int a, int b, int c) {
        Throwable exception = assertThrows(NotFoundAnswerException.class,
                () -> mathService.getAnswer(a, b, c));
        Assertions.assertEquals("Корни не могут быть найдены", exception.getMessage());
    }
}
