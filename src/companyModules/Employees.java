package companyModules;

public class Employees {
    private String name;
    private String lastname;
    private int age;
    private int salary;
    private String position;


    public Employees(String name, String lastname, int age, int salary, String position){
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.salary = salary;
        this.position = position;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name  = name;
    }

    public int getAge(){
        return age;
    }

    private void setAge(int age){
        this.age = age;
    }

    public int getSalary(){
        return salary;
    }

    public void setSalary(int salary){
        this.salary = salary;
    }

    public String getPosition(){
        return position;
    }

    public void setPosition(String position){
        this.position = position;
    }

    public void setLastname(String lastname){
        this.lastname = lastname;
    }

    public String getLastname(){
        return lastname;
    }
}
