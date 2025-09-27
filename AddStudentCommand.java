package virtualclassroom.commands;

import virtualclassroom.VirtualClassroomManager;

public class AddStudentCommand implements Command {
    private final String studentId;
    private final String className;

    public AddStudentCommand(String studentId, String className) {
        this.studentId = studentId;
        this.className = className;
    }

    @Override
    public void execute() {
        VirtualClassroomManager.getInstance().addStudent(studentId, className);
    }
}
