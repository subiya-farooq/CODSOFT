import java.util.*;

public class RegSystem {
    public static void main(String[] args) {
        Student S = new Student();
        S.display_courses();
        S.displayCourses();
        S.inputStudentDetails();
        S.displayCourses();
        S.registerCourse();
        S.removeCourse();
    }
}

class Course {
    int courseCount;
    String[] course_code;
    String[] title;
    int[] capacity;
    int[] stu_enrolled;

    Scanner sc = new Scanner(System.in);

    void display_courses() {
        System.out.println("Enter total number of courses:");
        courseCount = sc.nextInt();
        sc.nextLine(); // Consume newline

        course_code = new String[courseCount];
        title = new String[courseCount];
        capacity = new int[courseCount];
        stu_enrolled = new int[courseCount];

        for (int i = 0; i < courseCount; i++) {
            System.out.println("Enter Course name:");
            title[i] = sc.nextLine();
            System.out.println("Enter Course code:");
            course_code[i] = sc.nextLine();
            System.out.println("Enter maximum capacity:");
            capacity[i] = sc.nextInt();
            System.out.println("Enter number of students enrolled:");
            stu_enrolled[i] = sc.nextInt();
            sc.nextLine(); // Consume newline
        }
    }

    void displayCourses() {
        System.out.println("\nCourse Name\tCourse Code\tCapacity\tStudents Enrolled");
        for (int i = 0; i < courseCount; i++) {
            System.out.println(title[i] + "\t\t" + course_code[i] + "\t\t" + capacity[i] + "\t\t" + stu_enrolled[i]);
        }
    }
}

class Student extends Course {
    int studentCount;
    String[] id;
    String[] name;
    ArrayList<String>[] reg_courses;

    Scanner sc = new Scanner(System.in);

    void inputStudentDetails() {
        System.out.println("Enter total number of students:");
        studentCount = sc.nextInt();
        sc.nextLine(); // Consume newline

        id = new String[studentCount];
        name = new String[studentCount];
        reg_courses = new ArrayList[studentCount];

        for (int i = 0; i < studentCount; i++) {
            reg_courses[i] = new ArrayList<>();

            System.out.println("Enter your name:");
            name[i] = sc.nextLine();
            System.out.println("Enter your id:");
            id[i] = sc.nextLine();
        }
    }

    void registerCourse() {
        System.out.println("\n--- Course Registration ---");
        System.out.println("Enter your id:");
        String studentId = sc.nextLine();

        int studentIndex = getStudentIndex(studentId);
        if (studentIndex == -1) {
            System.out.println("Student not found.");
            return;
        }

        System.out.println("Enter the course name to register:");
        String courseName = sc.nextLine();

        int courseIndex = getCourseIndex(courseName);
        if (courseIndex == -1) {
            System.out.println("Course not found.");
            return;
        }

        if (stu_enrolled[courseIndex] >= capacity[courseIndex]) {
            System.out.println("Cannot register. Course is full.");
            return;
        }

        reg_courses[studentIndex].add(courseName);
        stu_enrolled[courseIndex]++;
        System.out.println("Course registered successfully.");
    }

    void removeCourse() {
        System.out.println("\n--- Course Removal ---");
        System.out.println("Enter your id:");
        String studentId = sc.nextLine();

        int studentIndex = getStudentIndex(studentId);
        if (studentIndex == -1) {
            System.out.println("Student not found.");
            return;
        }

        System.out.println("Enter the course name to remove:");
        String courseName = sc.nextLine();

        int courseIndex = getCourseIndex(courseName);
        if (courseIndex == -1) {
            System.out.println("Course not found.");
            return;
        }

        if (reg_courses[studentIndex].remove(courseName)) {
            stu_enrolled[courseIndex]--;
            System.out.println("Course removed successfully.");
        } else {
            System.out.println("Course not found in student's registered list.");
        }
    }

    int getStudentIndex(String studentId) {
        for (int i = 0; i < studentCount; i++) {
            if (id[i].equalsIgnoreCase(studentId)) {
                return i;
            }
        }
        return -1;
    }

    int getCourseIndex(String courseName) {
        for (int i = 0; i < courseCount; i++) {
            if (title[i].equalsIgnoreCase(courseName)) {
                return i;
            }
        }
        return -1;
    }
}

