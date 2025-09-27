package virtualclassroom;

import virtualclassroom.models.Classroom;
import virtualclassroom.models.Student;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class VirtualClassroomManager {
    private static VirtualClassroomManager instance;
    private final Map<String, Classroom> classrooms;
    private final Map<String, Student> students;
    private final Map<String, Set<String>> submittedAssignments;

    private VirtualClassroomManager() {
        this.classrooms = new HashMap<>();
        this.students = new HashMap<>();
        this.submittedAssignments = new HashMap<>();
    }

    public static synchronized VirtualClassroomManager getInstance() {
        if (instance == null) {
            instance = new VirtualClassroomManager();
        }
        return instance;
    }

    public void addClassroom(String className) {
        if (classrooms.containsKey(className)) {
            System.out.println("Error: Classroom " + className + " already exists.");
            return;
        }
        classrooms.put(className, new Classroom(className));
        System.out.println("Classroom " + className + " has been created.");
    }

    public void addStudent(String studentId, String className) {
        if (!classrooms.containsKey(className)) {
            System.out.println("Error: Classroom " + className + " not found.");
            return;
        }
        if (students.containsKey(studentId)) {
            System.out.println("Error: Student " + studentId + " is already enrolled.");
            return;
        }
        Student newStudent = new Student(studentId, className);
        students.put(studentId, newStudent);
        classrooms.get(className).getStudents().add(newStudent);
        System.out.println("Student " + studentId + " has been enrolled in " + className + ".");
    }

    public void scheduleAssignment(String className, String assignmentDetails) {
        if (!classrooms.containsKey(className)) {
            System.out.println("Error: Classroom " + className + " not found.");
            return;
        }
        classrooms.get(className).getAssignments().add(assignmentDetails);
        System.out.println("Assignment for " + className + " has been scheduled.");
    }

    public void submitAssignment(String studentId, String className, String assignmentDetails) {
        if (!students.containsKey(studentId) || !students.get(studentId).getClassName().equals(className)) {
            System.out.println("Error: Student " + studentId + " not found in " + className + ".");
            return;
        }
        if (!classrooms.get(className).getAssignments().contains(assignmentDetails)) {
            System.out.println("Error: Assignment '" + assignmentDetails + "' not found in " + className + ".");
            return;
        }
        submittedAssignments.computeIfAbsent(studentId, k -> new HashSet<>()).add(assignmentDetails);
        System.out.println("Assignment submitted by Student " + studentId + " in " + className + ".");
    }
}
