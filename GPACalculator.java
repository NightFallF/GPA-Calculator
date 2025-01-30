import java.util.Scanner;

public class GPACalculator {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Welcome to the GPA Calculator!");
            System.out.print("Enter the number of courses: ");
            int numCourses = scanner.nextInt();

            double totalGradePoints = 0;
            int totalCreditHours = 0;

            for (int i = 1; i <= numCourses; i++) {
                System.out.print("Enter grade for course " + i + " (A, B, C, D, F): ");
                char grade = scanner.next().toUpperCase().charAt(0);

                System.out.print("Enter credit hours for course " + i + ": ");
                int creditHours = scanner.nextInt();

                double gradePoint = getGradePoint(grade);
                if (gradePoint == -1) {
                    System.out.println("Invalid grade entered. Try again.");
                    i--;
                    continue;
                }

                totalGradePoints += gradePoint * creditHours;
                totalCreditHours += creditHours;
            }

            double gpa = totalGradePoints / totalCreditHours;
            System.out.printf("Your GPA is: %.2f\n", gpa);
        }
    }

    private static double getGradePoint(char grade) {
        return switch (grade) {
            case 'A' -> 10.0;
            case 'B' -> 8.0;
            case 'C' -> 7.0;
            case 'D' -> 5.0;
            case 'F' -> 0.0;
            default -> -1;
        };
    }
}
