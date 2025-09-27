package virtualclassroom.models;

import java.util.Objects;

public class Student {
    private final String id;
    private final String className;

    public Student(String id, String className) {
        this.id = Objects.requireNonNull(id);
        this.className = Objects.requireNonNull(className);
    }

    public String getId() {
        return id;
    }

    public String getClassName() {
        return className;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id.equals(student.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
