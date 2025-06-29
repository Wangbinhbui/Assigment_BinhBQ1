package fa.training.entities;

public class Student extends Person {
    private String studentId;
    private double theory;
    private double practice;

    // Constructor
    public Student(String fullName, String gender, String phone, String email, String studentId, double theory, double practice) {
        super(fullName, gender, phone, email);
        this.studentId = studentId;
        this.theory = theory;
        this.practice = practice;
    }

    // Getters and Setters
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public double getTheory() {
        return theory;
    }

    public void setTheory(double theory) {
        this.theory = theory;
    }

    public double getPractice() {
        return practice;
    }

    public void setPractice(double practice) {
        this.practice = practice;
    }

    // Calculate final mark
    public double calculateFinalMark() {
        return (theory + practice) / 2;
    }

    @Override
    public String toString() {
        return "Student{" + super.toString() +
                ", studentId='" + studentId + '\'' +
                ", theory=" + theory +
                ", practice=" + practice +
                ", finalMark=" + calculateFinalMark() +
                '}';
    }
}