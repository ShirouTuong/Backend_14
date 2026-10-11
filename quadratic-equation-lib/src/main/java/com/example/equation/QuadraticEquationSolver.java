package com.example.equation;

/**
 * Lớp cung cấp phương thức giải phương trình bậc 2: ax^2 + bx + c = 0
 */
public final class QuadraticEquationSolver {

    private QuadraticEquationSolver() {
        // Chặn khởi tạo đối tượng vì đây là utility class
    }

    /**
     * Giải phương trình bậc 2 dạng tổng quát: ax^2 + bx + c = 0
     *
     * @param a hệ số bậc hai
     * @param b hệ số bậc nhất
     * @param c hệ số tự do
     * @return đối tượng {@link EquationResult} chứa trạng thái và các nghiệm tìm được
     */
    public static EquationResult solve(double a, double b, double c) {
        // Trường hợp a = 0: phương trình suy biến thành bx + c = 0
        if (a == 0) {
            if (b == 0) {
                if (c == 0) {
                    return new EquationResult(EquationResult.Status.INFINITE_SOLUTIONS, null, null);
                } else {
                    return new EquationResult(EquationResult.Status.NO_SOLUTION, null, null);
                }
            } else {
                double x = -c / b;
                // Chuẩn hóa -0.0 thành 0.0 để tránh hiển thị -0.0
                if (x == -0.0) x = 0.0;
                return new EquationResult(EquationResult.Status.ONE_SOLUTION, x, null);
            }
        }

        // Trường hợp a != 0: tính biệt thức Delta = b^2 - 4ac
        double delta = b * b - 4 * a * c;

        if (delta < 0) {
            return new EquationResult(EquationResult.Status.NO_SOLUTION, null, null);
        } else if (delta == 0) {
            double x = -b / (2 * a);
            if (x == -0.0) x = 0.0;
            return new EquationResult(EquationResult.Status.ONE_SOLUTION, x, null);
        } else {
            double sqrtDelta = Math.sqrt(delta);
            double x1 = (-b + sqrtDelta) / (2 * a);
            double x2 = (-b - sqrtDelta) / (2 * a);
            if (x1 == -0.0) x1 = 0.0;
            if (x2 == -0.0) x2 = 0.0;
            return new EquationResult(EquationResult.Status.TWO_SOLUTIONS, x1, x2);
        }
    }
}
