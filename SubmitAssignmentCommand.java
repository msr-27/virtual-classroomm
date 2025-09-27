package virtualclassroom.commands;

import virtualclassroom.VirtualClassroomManager;

public class SubmitAssignmentCommand implements Command {
    private final String studentId;
    private final String className;
    private final String assignmentDetails;

    public SubmitAssignmentCommand(String studentId, String className, String assignmentDetails) {
        this.studentId = studentId;
        this.className = className;
        this.assignmentDetails = assignmentDetails;
    }

    @Override
    public void execute() {
        VirtualClassroomManager.getInstance().submitAssignment(studentId, className, assignmentDetails);
    }
}
