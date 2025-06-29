package fa.training.entities;

public abstract class Person {
    protected String fullName;
    protected String gender;
    protected String phone;
    protected String email;

    // Constructor
    public Person(String fullName, String gender, String phone, String email) {
        this.fullName = fullName;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
    }

    // Getters and Setters
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "fullName='" + fullName + "', gender='" + gender + "', phone='" + phone + "', email='" + email + "'";
    }
}