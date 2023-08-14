package pbl;
import methods.*;
import java.util.*;

public class CourseManagements {
    public static void main(String[] args) {
        CourseManagementMethods cms = new CourseManagementMethods();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Course");
            System.out.println("2. Remove Course");
            System.out.println("3. Add Student to Course");
            System.out.println("4. Remove Student from Course");
            System.out.println("5. Display Course Roster");
            System.out.println("6. Show all Couses and enrolled Students List");
            System.out.println("7. Exit");
            System.out.print("Enter option: ");
            int option;
            try {
                option = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid option.");
                continue;
            }
            switch (option) {
                case 1:
                    cms.addCourse();
                    break;
                case 2:
                    cms.removeCourse();
                    break;
                case 3:
                    cms.addStudentToCourse();
                    break;
                case 4:
                    cms.removeStudentFromCourse();
                    break;
                case 5:
                    cms.displayCourseRoster();
                    break;
                case 6:
                    cms.showCourses();
                    break;
                case 7:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option.");
                    break;
            }
            System.out.println();
        }
    }
}