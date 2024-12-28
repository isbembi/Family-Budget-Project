package model;

public class User {
    private int id;
    private String name;
    private String email;
    private String password;
    private String userType;
    private double salary;

    public User(int id, String name, String email, String password, String userType, double salary) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.userType = userType;
        this.salary = salary;
    }

    // Геттеры и сеттеры
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getUserType() { return userType; }
    public void setUserType(String userType) { this.userType = userType; }

    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }
}
