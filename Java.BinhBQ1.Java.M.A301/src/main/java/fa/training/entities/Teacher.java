package fa.training.entities;

public class Teacher extends Person {
    private double basicSalary;
    private double subsidy;

    // Constructor
    public Teacher(String fullName, String gender, String phone, String email, double basicSalary, double subsidy) {
        super(fullName, gender, phone, email);
        this.basicSalary = basicSalary;
        this.subsidy = subsidy;
    }

    // Getters and Setters
    public double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }

    public double getSubsidy() {
        return subsidy;
    }

    public void setSubsidy(double subsidy) {
        this.subsidy = subsidy;
    }

    // Calculate salary
    public double calculateSalary() {
        return basicSalary + subsidy;
    }

    @Override
    public String toString() {
        return "Teacher{" + super.toString() +
                ", basicSalary=" + basicSalary +
                ", subsidy=" + subsidy +
                ", totalSalary=" + calculateSalary() +
                '}';
    }
}