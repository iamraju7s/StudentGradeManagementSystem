import java.util.List;

public class GradeManager {
    private DatabaseManager databaseManager;

    public GradeManager() {
        this.databaseManager = new DatabaseManager();
    }

    // Add a student (now it stores in the database)
    public void addStudent(Student student) {
        databaseManager.addStudent(student);
    }

    // Get all students from the database
    public List<Student> getAllStudents() {
        return databaseManager.getAllStudents();
    }

    // Search by name (from the database)
    public Student searchStudentByName(String name) {
        return databaseManager.searchStudentByName(name);
    }
}
