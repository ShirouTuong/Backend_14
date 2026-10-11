package com.example.equation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Kiểm thử thư viện giải phương trình bậc 2")
class QuadraticEquationSolverTest {

    private static final double EPSILON = 1e-9;

    @Test
    @DisplayName("a != 0, Delta > 0: Có 2 nghiệm phân biệt (x^2 - 5x + 6 = 0)")
    void testTwoDistinctRoots() {
        EquationResult result = QuadraticEquationSolver.solve(1, -5, 6);
        assertEquals(EquationResult.Status.TWO_SOLUTIONS, result.getStatus());
        assertNotNull(result.getX1());
        assertNotNull(result.getX2());
        assertEquals(3.0, result.getX1(), EPSILON);
        assertEquals(2.0, result.getX2(), EPSILON);
    }

    @Test
    @DisplayName("a != 0, Delta = 0: Có nghiệm kép (x^2 - 4x + 4 = 0)")
    void testDoubleRoot() {
        EquationResult result = QuadraticEquationSolver.solve(1, -4, 4);
        assertEquals(EquationResult.Status.ONE_SOLUTION, result.getStatus());
        assertNotNull(result.getX1());
        assertNull(result.getX2());
        assertEquals(2.0, result.getX1(), EPSILON);
    }

    @Test
    @DisplayName("a != 0, Delta < 0: Vô nghiệm thực (x^2 + 1 = 0)")
    void testNoRealRoots() {
        EquationResult result = QuadraticEquationSolver.solve(1, 0, 1);
        assertEquals(EquationResult.Status.NO_SOLUTION, result.getStatus());
        assertNull(result.getX1());
        assertNull(result.getX2());
    }

    @Test
    @DisplayName("a = 0, b != 0: Phương trình bậc nhất có 1 nghiệm duy nhất (2x - 4 = 0)")
    void testLinearEquation() {
        EquationResult result = QuadraticEquationSolver.solve(0, 2, -4);
        assertEquals(EquationResult.Status.ONE_SOLUTION, result.getStatus());
        assertNotNull(result.getX1());
        assertNull(result.getX2());
        assertEquals(2.0, result.getX1(), EPSILON);
    }

    @Test
    @DisplayName("a = 0, b = 0, c = 0: Vô số nghiệm (0 = 0)")
    void testInfiniteSolutions() {
        EquationResult result = QuadraticEquationSolver.solve(0, 0, 0);
        assertEquals(EquationResult.Status.INFINITE_SOLUTIONS, result.getStatus());
        assertNull(result.getX1());
        assertNull(result.getX2());
    }

    @Test
    @DisplayName("a = 0, b = 0, c != 0: Vô nghiệm (5 = 0)")
    void testLinearNoSolution() {
        EquationResult result = QuadraticEquationSolver.solve(0, 0, 5);
        assertEquals(EquationResult.Status.NO_SOLUTION, result.getStatus());
        assertNull(result.getX1());
        assertNull(result.getX2());
    }
}
