package managers;

import companyModules.Company;
import companyModules.Employees;

public class EmployeesManager {
    public void addNewEmployee(Company company, Employees employee) {
        for (int i = 0; i < company.getEmployees().length; i++) {
            if (company.getEmployees()[i] == null) {
                company.getEmployees()[i] = employee;
                break;
            }
        }

    }

    public boolean canIAddEmployee(Company company, Employees employee) {
        for (int i = 0; i < company.getEmployees().length; i++) {
            if (company.getEmployees()[i] != null) {
                if (company.getEmployees()[i].getName().equals(employee.getName())
                        && company.getEmployees()[i].getLastname().equals(employee.getLastname())) {
                    return false;
                }
            }
        }
        return true;

    }



    public void fireEmployee(Company company, int employeeIndexToDelete) {
        company.getEmployees()[employeeIndexToDelete] = null;


    }

    public void showAllEmployees(Company company) {
        for (int i = 0; i < company.getEmployees().length; i++) {
            if (company.getEmployees()[i] != null) {
                System.out.println("Imię: " + company.getEmployees()[i].getName() +
                        ", nazwisko: " + company.getEmployees()[i].getLastname() +
                        ", wiek: " + company.getEmployees()[i].getAge() +
                        ", stanowisko: " + company.getEmployees()[i].getPosition());
            }
        }

    }

    public boolean employeesListIsFull(Company company) {
        for (int i = 0; i < company.getEmployees().length; i++) {
            if (company.getEmployees()[i] == null) {
                return false;
            }
        }
        return true;
    }


    public void giveARise(Company company, int employeeIndex, int newSalary) {
        company.getEmployees()[employeeIndex].setSalary(newSalary);
    }

    public boolean canIChangeEmployeeSettings(Company company, int employeeIndex) {
        if (employeeIndex >= company.getEmployees().length) {
            return false;
        } else {
            return company.getEmployees()[employeeIndex] == null;
        }
    }

    public void changeEmployeePosition(Company company, int employeeIndex, String newPosition) {
        company.getEmployees()[employeeIndex].setPosition(newPosition);
    }
}
