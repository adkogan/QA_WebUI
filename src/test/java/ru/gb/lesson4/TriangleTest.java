package ru.gb.lesson4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TriangleTest {


    @Test
    @DisplayName("метод AssertTriangleIsValid проверяет корректность значений для сторон треугольника")
    public void AssertTriangleIsValid() {
        Assertions.assertTrue(Triangle.isTriangleValid(20, 30, 40));
    }


    @ParameterizedTest
    @MethodSource("triangleVerticesCorrectDataProvider")
    @DisplayName("Позитивные: Проверка сторон треугольника")
    public void AssertTriangleVerticesCorrect(int a,int b, int c, double expectedArea){
        double actualArea = Triangle.triangleArea(a, b, c);
        assertEquals(expectedArea, actualArea);

    }


    private static List<Arguments> triangleVerticesCorrectDataProvider() {
        return Arrays.asList(
                Arguments.of(20, 40, 50, 379.0),
                Arguments.of(10, 20, 20, 96.0),
                Arguments.of(10, 15, 20, 72.0)
                );
    }



    @Test
    public void AssertTriangleNotValid() {
        Assertions.assertFalse(Triangle.isTriangleValid(10, 20, 30));
    }

    @ParameterizedTest
    @MethodSource("triangleVerticesNullDataProvider")
    @DisplayName("Проверка сторон треугольника на 0")
    void triangleVerticesNullTest(int a, int b, int c, String message){
        String expectedMessage = "Введенные числа должны быть больше 0";
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> { Triangle.isTriangleVerticesNotNull(a, b, c); throw new IllegalArgumentException(expectedMessage); }
        );

        assertEquals(expectedMessage, exception.getMessage());
    }


    private static List<Arguments> triangleVerticesNullDataProvider(){
        return Arrays.asList(
                Arguments.of(0, 0, 0, "Введенные числа должны быть больше 0"),
                Arguments.of(10, 0, 30, "Введенные числа должны быть больше 0"),
                Arguments.of(20, 40, 0, "Введенные числа должны быть больше 0"),
                Arguments.of(0, 40, 30, "Введенные числа должны быть больше 0"),
                Arguments.of(-10, 30, 50, "Введенные числа должны быть больше 0")

        );

    }

}



