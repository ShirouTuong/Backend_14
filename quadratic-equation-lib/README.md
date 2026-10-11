# Quadratic Equation Solver Library (Thư viện giải phương trình bậc 2)

Thư viện Java chuyên dụng để giải phương trình bậc 2 dạng tổng quát:

$$ax^2 + bx + c = 0$$

Dự án được cấu trúc chuẩn Maven, hỗ trợ đầy đủ các trường hợp suy biến ($a = 0$), nghiệm thực, nghiệm kép, vô nghiệm và vô số nghiệm.

---

## 🌟 Tính năng nổi bật

- **Xử lý toàn diện mọi trường hợp:**
  - $a \neq 0$: Phương trình bậc hai thông thường ($\Delta > 0$, $\Delta = 0$, $\Delta < 0$).
  - $a = 0, b \neq 0$: Tự động hạ bậc về phương trình bậc nhất $bx + c = 0$.
  - $a = 0, b = 0, c = 0$: Kết luận vô số nghiệm.
  - $a = 0, b = 0, c \neq 0$: Kết luận vô nghiệm.
- **Thiết kế chuẩn thư viện (Library Design):**
  - Trả về đối tượng `EquationResult` với trạng thái `enum` rõ ràng thay vì chỉ in ra console.
  - Hỗ trợ đầy đủ Unit Tests với JUnit 5.
  - Hỗ trợ đóng gói thành file `.jar` độc lập hoặc cài vào Local Maven Repository.

---

## 📁 Cấu trúc thư mục

```text
quadratic-equation-solver-lib/
├── .gitignore
├── pom.xml
├── README.md
└── src/
    ├── main/
    │   └── java/
    │       └── com/
    │           └── example/
    │               └── equation/
    │                   ├── EquationResult.java          # Model kết quả nghiệm
    │                   ├── QuadraticEquationSolver.java # Thuật toán giải phương trình
    │                   └── Main.java                    # Chương trình Demo / Entry point
    └── test/
        └── java/
            └── com/
                └── example/
                    └── equation/
                        └── QuadraticEquationSolverTest.java # Unit Test (JUnit 5)
```

---

## 🚀 Hướng dẫn biên dịch và đóng gói

### 1. Yêu cầu môi trường
- **JDK 17** trở lên.
- **Apache Maven** (3.6+).

### 2. Chạy kiểm thử tự động (Unit Test)
```bash
mvn test
```

### 3. Đóng gói ra file `.jar`
```bash
mvn clean package
```
Sau khi chạy xong, file thư viện `.jar` sẽ nằm trong thư mục `target/`:
- `target/quadratic-equation-solver-lib-1.0.0.jar`

### 4. Chạy file JAR trực tiếp (Demo)
```bash
# Chạy demo các bộ test tự động:
java -jar target/quadratic-equation-solver-lib-1.0.0.jar

# Hoặc truyền trực tiếp 3 hệ số a b c qua command-line:
java -jar target/quadratic-equation-solver-lib-1.0.0.jar 1 -5 6
```

### 5. Cài đặt vào Local Maven Repo (để dự án khác sử dụng)
```bash
mvn clean install
```

---

## 💻 Cách sử dụng thư viện trong dự án khác

### Cách A: Thêm dependency qua Maven
Nếu đã chạy `mvn install`, bạn chỉ cần thêm dependency sau vào `pom.xml` của dự án mới:

```xml
<dependency>
    <groupId>com.example</groupId>
    <artifactId>quadratic-equation-solver-lib</artifactId>
    <version>1.0.0</version>
</dependency>
```

### Cách B: Thêm file `.jar` thủ công trong IntelliJ / Eclipse
- Copy file `quadratic-equation-solver-lib-1.0.0.jar` vào thư mục dự án của bạn (ví dụ thư mục `libs/`).
- Trong **IntelliJ IDEA**: Vào `File` -> `Project Structure` -> `Libraries` -> Bấm `+` và chọn file `.jar`.

### Ví dụ code sử dụng:
```java
import com.example.equation.EquationResult;
import com.example.equation.QuadraticEquationSolver;

public class App {
    public static void main(String[] args) {
        // Giải phương trình: x^2 - 5x + 6 = 0
        EquationResult result = QuadraticEquationSolver.solve(1, -5, 6);

        if (result.getStatus() == EquationResult.Status.TWO_SOLUTIONS) {
            System.out.println("x1 = " + result.getX1());
            System.out.println("x2 = " + result.getX2());
        } else {
            System.out.println(result);
        }
    }
}
```

---

## 📤 Hướng dẫn đẩy lên GitHub (Push to GitHub)

1. Mở terminal tại thư mục dự án này:
   ```bash
   cd quadratic-equation-solver-lib
   ```
2. Khởi tạo Git repository và commit:
   ```bash
   git init
   git add .
   git commit -m "feat: complete quadratic equation solver library with tests"
   ```
3. Đổi tên nhánh chính thành `main` (nếu cần):
   ```bash
   git branch -M main
   ```
4. Liên kết với kho lưu trữ trên GitHub của bạn:
   *(Thay URL bên dưới bằng URL repository bạn tạo trên GitHub)*
   ```bash
   git remote add origin https://github.com/<tai-khoan-cua-ban>/<ten-repo>.git
   ```
5. Đẩy mã nguồn lên GitHub:
   ```bash
   git push -u origin main
   ```
