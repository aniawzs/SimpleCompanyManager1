package managers;

import companyModules.Company;
import companyModules.Employees;
import utils.Printer;

import java.util.Arrays;

public class EmployeesManager {
    private Printer printer = new Printer();

    public void addNewEmployee(Company company, Employees employee) {
        for (int i = 0; i < company.getEmployees().length; i++) {
            if (company.getEmployees()[i] == null) {
                company.getEmployees()[i] = employee;
                return;
            }
        }

        company.setEmployees(Arrays.copyOf(company.getEmployees(), company.getEmployees().length + 1));
        company.getEmployees()[company.getEmployees().length - 1] = employee;
    }

    public boolean canCompanyAddEmployee(Company company, Employees employee) {
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
        if (company.getEmployees().length == 0) {
            printer.print("Lista pracowników jest pusta");
            return;
        }

        for (int i = 0; i < company.getEmployees().length; i++) {
            if (company.getEmployees()[i] != null) {
                System.out.println("Imię: " + company.getEmployees()[i].getName() +
                        ", nazwisko: " + company.getEmployees()[i].getLastname() +
                        ", wiek: " + company.getEmployees()[i].getAge() +
                        ", stanowisko: " + company.getEmployees()[i].getPosition());
            }
        }
    }

    public void giveARise(Company company, int employeeIndex, int newSalary) {
        company.getEmployees()[employeeIndex].setSalary(newSalary);
    }

    public boolean canCompanyChangeEmployeeSettings(Company company, int employeeIndex) {
        if (employeeIndex >= company.getEmployees().length) {
            return false;
        } else {
            return company.getEmployees()[employeeIndex] != null;
        }
    }

    public void changeEmployeePosition(Company company, int employeeIndex, String newPosition) {
        company.getEmployees()[employeeIndex].setPosition(newPosition);
    }
}
