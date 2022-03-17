package labs.filesystem.file;

import java.time.LocalDate;
import java.util.Objects;

public abstract class File {

    private static final String NULL_ARG_ERROR = "%s cannot be null.";
    private static final String DELETED_FILE_ERROR = "File has been deleted.";

    private final String name;
    private final LocalDate creationDate;
    private String location;
    private boolean isDeleted;

    public File(String name, String location, LocalDate creationDate) {
        this.name = name;
        this.location = location;
        this.creationDate = creationDate;
    }

    public abstract void modify(byte[] data);

    public abstract File copy(String newLocation);

    public void move(String newLocation) {
        checkValidLocation(newLocation);
        if (isDeleted) {
            throw new IllegalStateException(DELETED_FILE_ERROR);
        }

        location = newLocation;
    }

    public void delete() {
        this.isDeleted = true;
    }

    public String getInfo() {
        return String.format("""
            Name: %s;
            Location: %s;
            Creation Date: %s
            """, this.name, this.location, this.creationDate);
    }

    private void checkValidLocation(String location) {
        Objects.requireNonNull(location, String.format(NULL_ARG_ERROR, "location"));

        if (location.isEmpty() || location.isBlank()) {
            throw new IllegalArgumentException("Location cannot be empty or blank.");
        }
    }
}
