public class Student {
    private String name;
    private String id;
    private double grade;
    private double gpa;

    // Constructor
    public Student(String name, String id, double grade) {
        this.name = name;
        this.id = id;
        this.grade = grade;
        this.gpa = calculateGPA(grade);
    }

    // GPA Calculation (simple scale)
    public double calculateGPA(double grade) {
        return grade / 20;  // Just an example, you can adjust GPA calculation logic
    }

    // Getter and Setter methods
    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public double getGrade() {
        return grade;
    }

    public double getGpa() {
        return gpa;
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', id='" + id + "', grade=" + grade + ", GPA=" + gpa + '}';
    }
}
