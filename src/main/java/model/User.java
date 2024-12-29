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

    public int getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public String getUserType() { return userType; }
    public double getSalary() { return salary; }
}
