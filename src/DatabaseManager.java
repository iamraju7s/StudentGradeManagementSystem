import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {
    private static final String URL = "jdbc:mysql://localhost:3306/student_management_system";
    private static final String USER = "root"; // Your MySQL username
    private static final String PASSWORD = "Rs@9912027285"; // Your MySQL password

    // Establish connection to the MySQL database
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Add student to the database
    public void addStudent(Student student) {
        String query = "INSERT INTO students (name, student_id, grade, gpa) VALUES (?, ?, ?, ?)";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getId());
            preparedStatement.setDouble(3, student.getGrade());
            preparedStatement.setDouble(4, student.getGpa());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Retrieve all students from the database
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        String query = "SELECT * FROM students";

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String id = resultSet.getString("student_id");
                double grade = resultSet.getDouble("grade");
                double gpa = resultSet.getDouble("gpa");

                students.add(new Student(name, id, grade));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    // Search student by name
    public Student searchStudentByName(String name) {
        String query = "SELECT * FROM students WHERE name = ?";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String studentName = resultSet.getString("name");
                String id = resultSet.getString("student_id");
                double grade = resultSet.getDouble("grade");
                double gpa = resultSet.getDouble("gpa");
                return new Student(studentName, id, grade);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
