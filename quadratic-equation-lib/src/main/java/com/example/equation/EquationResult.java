package com.example.equation;

import java.util.Objects;

/**
 * Lớp đại diện cho kết quả của phương trình bậc 2.
 */
public class EquationResult {

    /**
     * Trạng thái nghiệm của phương trình
     */
    public enum Status {
        INFINITE_SOLUTIONS, // Vô số nghiệm
        NO_SOLUTION,        // Vô nghiệm
        ONE_SOLUTION,       // 1 nghiệm duy nhất hoặc nghiệm kép
        TWO_SOLUTIONS       // 2 nghiệm phân biệt
    }

    private final Status status;
    private final Double x1;
    private final Double x2;

    public EquationResult(Status status, Double x1, Double x2) {
        this.status = status;
        this.x1 = x1;
        this.x2 = x2;
    }

    public Status getStatus() {
        return status;
    }

    public Double getX1() {
        return x1;
    }

    public Double getX2() {
        return x2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EquationResult that = (EquationResult) o;
        return status == that.status &&
                Objects.equals(x1, that.x1) &&
                Objects.equals(x2, that.x2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, x1, x2);
    }

    @Override
    public String toString() {
        return switch (status) {
            case INFINITE_SOLUTIONS -> "Phương trình có vô số nghiệm.";
            case NO_SOLUTION -> "Phương trình vô nghiệm.";
            case ONE_SOLUTION -> "Phương trình có nghiệm: x = " + x1;
            case TWO_SOLUTIONS -> "Phương trình có 2 nghiệm phân biệt: x1 = " + x1 + ", x2 = " + x2;
        };
    }
}
