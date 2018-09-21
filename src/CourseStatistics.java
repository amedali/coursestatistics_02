import java.util.*;

public class CourseStatistics {

    public static Scanner console = new Scanner(System.in);
    public static int numberOfAssignments;
    public static int numberOfStudents;
    public static double exam1Weight;
    public static double exam2Weight;
    public static double assignmentWeight;
    public static double totalCourseGrade;
    public static double[] arrayOfCourseGrades;

    public static void main(String[] args) {

        courseInfo();
        studentInfo();
        courseStatistics();

    }

    public static void courseInfo() {

        System.out.println("Course Information:");

        System.out.print("Enter Exam 1, Exam 2, and Assignment weights: ");
        exam1Weight = console.nextDouble();
        exam2Weight = console.nextDouble();
        assignmentWeight = console.nextDouble();

        System.out.print("Enter the number of assignments: ");
        numberOfAssignments = console.nextInt();

        System.out.print("Enter the number of students: ");
        numberOfStudents = console.nextInt();

        arrayOfCourseGrades = new double[numberOfStudents];

        System.out.println(" ");

    }

    public static void studentInfo() {

        System.out.println("Student scores:");

        for(int i = 1; i <= numberOfStudents; i++) {

            double exam1Score;
            double exam2Score;
            double totalAssignmentScore = 0;
            double courseGrade;

            System.out.println("Student " + i + " scores:");

            System.out.print("Exam 1 score: ");
            exam1Score = console.nextDouble();

            System.out.print("Exam 2 score: ");
            exam2Score = console.nextDouble();

            for(int j = 1; j <= numberOfAssignments; j++) {

                System.out.print("Assignment " + j + " score: ");
                double assignmentScore = console.nextDouble();

                totalAssignmentScore = totalAssignmentScore + assignmentScore;
            }

            courseGrade = (exam1Score * ( exam1Weight / 100))
                    + (exam2Score * ( exam2Weight / 100))
                    + (totalAssignmentScore / numberOfAssignments) * ( assignmentWeight / 100);

            totalCourseGrade = totalCourseGrade + courseGrade;

            arrayOfCourseGrades[i - 1] = courseGrade;

            System.out.printf("Course grade = %.2f\n", courseGrade);

        System.out.println(" ");

        }
    }

    public static void courseStatistics() {

        double courseAvg = (totalCourseGrade / numberOfStudents);
        double courseMax = Arrays.stream(arrayOfCourseGrades).max().getAsDouble();
        double courseMin = Arrays.stream(arrayOfCourseGrades).min().getAsDouble();

        System.out.printf("Average course grade = %.2f\n", courseAvg);
        System.out.printf("Maximum course grade = %.2f\n", courseMax);
        System.out.printf("Minimum course grade = %.2f\n", courseMin);

    }
}