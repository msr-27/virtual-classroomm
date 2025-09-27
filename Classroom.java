package virtualclassroom.models;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Classroom {
    private final String name;
    private final Set<Student> students;
    private final Set<String> assignments;

    public Classroom(String name) {
        this.name = Objects.requireNonNull(name);
        this.students = new HashSet<>();
        this.assignments = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public Set<String> getAssignments() {
        return assignments;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Classroom classroom = (Classroom) o;
        return name.equals(classroom.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
