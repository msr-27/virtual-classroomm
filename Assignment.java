package virtualclassroom.models;

import java.util.Objects;

public class Assignment {
    private final String id;
    private final String className;
    private final String details;

    public Assignment(String className, String details) {
        this.className = Objects.requireNonNull(className);
        this.details = Objects.requireNonNull(details);
        // Generate a unique ID, for simplicity we combine class name and details
        this.id = className + ":" + details.replace(" ", "_");
    }

    public String getId() {
        return id;
    }

    public String getClassName() {
        return className;
    }

    public String getDetails() {
        return details;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Assignment that = (Assignment) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
