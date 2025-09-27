package virtualclassroom.commands;

import virtualclassroom.VirtualClassroomManager;

public class ScheduleAssignmentCommand implements Command {
    private final String className;
    private final String assignmentDetails;

    public ScheduleAssignmentCommand(String className, String assignmentDetails) {
        this.className = className;
        this.assignmentDetails = assignmentDetails;
    }

    @Override
    public void execute() {
        VirtualClassroomManager.getInstance().scheduleAssignment(className, assignmentDetails);
    }
}
