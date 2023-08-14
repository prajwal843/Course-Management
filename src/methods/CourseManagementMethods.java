package methods;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Course {

    private String name;
    private String code;

    String type = "Theory Class";

    public Course(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public void displayCourseInfo() {
        System.out.println("Course Name: " + name);
        System.out.println("Course Code: " + code);
    }
}

class PracticalCourse extends Course {

    private int numOfPracticals;
    String type = "Practical Class";

    public PracticalCourse(String name, String code, int practicals) {
        super(name, code);
        this.numOfPracticals = practicals;
    }
    public String getType() {
        return type;
    }
    public int getNumPracticals() {
        return numOfPracticals;
    }

    public void displayCourseInfo() {
        super.displayCourseInfo();
        System.out.println("Number of Sections: " + numOfPracticals);
    }
}

class TermWorkCourses extends Course {

    private int numOfTuts;
    String type = "Term Work Class";

    public TermWorkCourses(String name, String code, int tuts) {
        super(name, code);
        this.numOfTuts = tuts;
    }

    public String getType() {
        return type;
    }

    public int getnumOfTuts() {
        return numOfTuts;
    }

    public void displayCourseInfo() {
        super.displayCourseInfo();
        System.out.println("Numbers of Tuts: " + numOfTuts);
    }
}

class Student {

    private String name;
    private int id;

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public int getId() {
        return id;
    }
    public String toString() {
        return "Name: " + name + ", ID: " + id;
    }
}

public class CourseManagementMethods {

    private HashMap<String, Course> courses;
    private HashMap<String, ArrayList<Student>> roster;

    public CourseManagementMethods() {
        courses = new HashMap<String, Course>();
        roster = new HashMap<String, ArrayList<Student>>();
    }

    public void addCourse() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter course code: ");
        String code = scanner.nextLine();
        if (courses.containsKey(code)) {
            System.out.println("Course already exists.");
            return;
        }
        System.out.print("Enter course name: ");
        String name = scanner.nextLine();
        System.out.print("Enter course type \n1. for Theory Class, \n2. for Practical Class, \n3. for Term Work Class ");

        int type;
        try {
            type = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid course type.");
            return;
        }
        Course course;
        if (type == 1) {
            course = new Course(name, code);
        } else if (type == 2) {
            System.out.print("Enter number of Practicals: ");
            int practicals;
            try {
                practicals = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid number of Practicals.");
                return;
            }
            course = new PracticalCourse(name, code, practicals);
        } else if (type == 3) {
            System.out.print("Enter Numbers Of Tutorials: ");
            int tuts;
            try {
                tuts = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid number of Tutorials.");
                return;
            }
            course = new TermWorkCourses(name, code, tuts);
        }else {
            System.out.println("Invalid course type.");
            return;
        }
        courses.put(code, course);
        roster.put(code, new ArrayList<Student>());
        System.out.println("Course added.");
    }

    public void removeCourse() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter course code: ");
        String code = scanner.nextLine();
        Course course = courses.get(code);  //Course course = courses.get(code); - Looks up the 
                                           //Course object associated with the given code in the courses 
                                          //collection and stores it in a variable named course.
                                         //If there is no such course, course will be null.
        if (course == null) {
            System.out.println("Course not found.");
            return;
        }
        courses.remove(code);
        roster.remove(code);
        System.out.println("Course removed.");
    }

    public void addStudentToCourse() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter course code: ");
        String code = scanner.nextLine();
         ArrayList<Student> courseRoster = roster.get(code);
        if (courseRoster == null) {
            System.out.println("Course not found.");
            return;
        }
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        System.out.print("Enter student ID: ");
        int id;
        try {
            id = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid student ID.");
            return;
        }
        for (Student student : courseRoster) {
            if (student.getId() == id) {
                System.out.println("Student already enrolled in course.");
                return;
            }
        }
        Student student = new Student(name, id);
        courseRoster.add(student);
        System.out.println("Student added to course roster.");
    }

    public void removeStudentFromCourse() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter course code: ");
        String code = scanner.nextLine();
        ArrayList<Student> courseRoster = roster.get(code);
        if (courseRoster == null) {
            System.out.println("Course not found.");
            return;
        }
        System.out.print("Enter student ID: ");
        int id;
        try {
            id = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid student ID.");
            return;
        }
        for (Student student : courseRoster) {
            if (student.getId() == id) {
                courseRoster.remove(student);
                System.out.println("Student removed from course roster.");
                return;
            }
        }
        System.out.println("Student not found in course roster.");
    }

    public void displayCourseRoster() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter course code: ");
        String code = scanner.nextLine();
        ArrayList<Student> courseRoster = roster.get(code);
        if (courseRoster == null) {
            System.out.println("Course not found.");
            return;
        }
        System.out.println("Course Roster:");
        for (Student student : courseRoster) {
            System.out.println(student);
        }
    }
    
    public void displayCourseRoster(String code) {
        ArrayList<Student> courseRoster = roster.get(code);
        System.out.println("Enrolled Students:");
        for (Student student : courseRoster) {
            System.out.println(student);
        }
    }

    public void showCourses(){
        System.out.println("All Courses: ");
        for(Map.Entry<String, Course> m : courses.entrySet()){
            System.out.println("Course Name: " + m.getValue().getName() + " | Course Type: " + m.getValue().getType() + " | Course Code: "+ m.getKey());
            displayCourseRoster(m.getKey());
            System.out.println();
        }
    }
}

