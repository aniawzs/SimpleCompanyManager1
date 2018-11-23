package companyModules;

public class Employees {
    private String name;
    private String lastname;
    private int age;
    private int salary;
    private String position;


    public Employees(String name, String lastname, int age, int salary, String position) {
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.salary = salary;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getLastname() {
        return lastname;
    }
}
