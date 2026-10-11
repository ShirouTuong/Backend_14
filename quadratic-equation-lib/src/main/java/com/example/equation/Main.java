package com.example.equation;

import java.util.Scanner;

/**
 * Lớp chạy demo mẫu sử dụng thư viện giải phương trình bậc 2.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" DEMO THƯ VIỆN GIẢI PHƯƠNG TRÌNH BẬC 2 (ax^2 + bx + c = 0)");
        System.out.println("==================================================");

        // Trường hợp chạy kèm tham số dòng lệnh: java -jar lib.jar 1 -5 6
        if (args.length == 3) {
            try {
                double a = Double.parseDouble(args[0]);
                double b = Double.parseDouble(args[1]);
                double c = Double.parseDouble(args[2]);
                System.out.printf("Phương trình: %.2fx^2 + %.2fx + %.2f = 0%n", a, b, c);
                EquationResult result = QuadraticEquationSolver.solve(a, b, c);
                System.out.println("Kết quả: " + result);
                return;
            } catch (NumberFormatException e) {
                System.err.println("Lỗi: Các tham số truyền vào phải là số thực hợp lệ!");
            }
        }

        // Các ca kiểm thử mẫu tự động
        runSampleTest(1, -5, 6, "2 nghiệm phân biệt (x1 = 3, x2 = 2)");
        runSampleTest(1, -4, 4, "Nghiệm kép (x = 2)");
        runSampleTest(1, 0, 1, "Vô nghiệm (x^2 + 1 = 0)");
        runSampleTest(0, 2, -4, "Phương trình bậc nhất 2x - 4 = 0 (x = 2)");
        runSampleTest(0, 0, 0, "Vô số nghiệm (0x + 0 = 0)");
        runSampleTest(0, 0, 5, "Vô nghiệm (0x + 5 = 0)");

        System.out.println("==================================================");
        System.out.println("Demo hoàn tất! Thư viện hoạt động chính xác.");
    }

    private static void runSampleTest(double a, double b, double c, String expectedDesc) {
        System.out.printf("Test: %.2fx^2 + %.2fx + %.2f = 0 (Kỳ vọng: %s)%n", a, b, c, expectedDesc);
        EquationResult result = QuadraticEquationSolver.solve(a, b, c);
        System.out.println("-> " + result);
        System.out.println();
    }
}
