import java.util.*; // for Scanner

public class CourseStatistics {

    public static Scanner console = new Scanner(System.in);
    public static int numberOfAssignments;
    public static int numberOfStudents;
    public static double exam1Weight;
    public static double exam2Weight;
    public static double assignmentWeight;
    public static double exam1Score;
    public static double exam2Score;
    public static double assignmentScore;
    public static double totalAssignmentScore;
    public static double courseGrade;
    public static double totalCourseGrade;
    public static double[] arrayOfCourseGrades;

    public static void main(String[] args) {

        courseInformation();
        studentInfo();
        courseStatistics();

    }

    public static void courseInformation() {

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

            System.out.println("Student " + i + " scores:");

            System.out.print("Exam 1 score: ");
            exam1Score = console.nextDouble();

            System.out.print("Exam 2 score: ");
            exam2Score = console.nextDouble();

            for(int ii = 1; ii <= numberOfAssignments; ii++) {

                System.out.print("Assignment " + ii + " score: ");
                assignmentScore = console.nextDouble();
                totalAssignmentScore = totalAssignmentScore + assignmentScore;
            }

            courseGrade = (exam1Score * ( exam1Weight / 100))
                    + (exam2Score * ( exam2Weight / 100))
                    + (totalAssignmentScore / numberOfAssignments) * ( assignmentWeight / 100);

            totalCourseGrade = totalCourseGrade + courseGrade;

            int iii = i - 1;

            arrayOfCourseGrades[iii] = courseGrade;

            System.out.println("Course grade = " + String.format("%.2f", courseGrade));

        System.out.println(" ");

        }
    }

    public static void courseStatistics() {

        double courseAvg = (totalCourseGrade / numberOfStudents);
        double courseMax = Arrays.stream(arrayOfCourseGrades).max().getAsDouble();
        double courseMin = Arrays.stream(arrayOfCourseGrades).min().getAsDouble();

        System.out.println("Average course grade = " + String.format("%.2f", courseAvg));
        System.out.println("Maximum course grade = " + String.format("%.2f", courseMax));
        System.out.println("Minimum course grade = " + String.format("%.2f", courseMin));

    }
}