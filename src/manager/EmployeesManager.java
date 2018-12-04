package manager;

import company.module.Company;
import company.module.Employee;
import utils.Printer;

public class EmployeesManager {
    private Printer printer = new Printer();

    public void addNewEmployee(Company company, Employee employee) {
        company.getEmployees().add(employee);
    }

    public boolean canCompanyAddEmployee(Company company, Employee employee) {
        for (int i = 0; i < company.getEmployees().size(); i++) {
            if (company.getEmployees().get(i).getName().equals(employee.getName())
                    && company.getEmployees().get(i).getLastname().equals(employee.getLastname())) {
                return false;
            }
        }
        return true;
    }

    public void fireEmployee(Company company, int employeeIndexToDelete) {
        company.getEmployees().remove(employeeIndexToDelete);
    }

    public void showAllEmployees(Company company) {
        if (company.getEmployees().isEmpty()) {
            printer.print("Lista pracowników jest pusta");
            return;
        }

        for (int i = 0; i < company.getEmployees().size(); i++) {

            System.out.println("Imię: " + company.getEmployees().get(i).getName() +
                    ", nazwisko: " + company.getEmployees().get(i).getLastname() +
                    ", wiek: " + company.getEmployees().get(i).getAge() +
                    ", stanowisko: " + company.getEmployees().get(i).getPosition());

        }
    }

    public void giveARise(Company company, int employeeIndex, int newSalary) {
        company.getEmployees().get(employeeIndex).setSalary(newSalary);
    }

    public boolean canCompanyChangeEmployeeSettings(Company company, int employeeIndex) {
        return employeeIndex >= company.getEmployees().size() || employeeIndex < 0;


    }

    public void changeEmployeePosition(Company company, int employeeIndex, String newPosition) {
        company.getEmployees().get(employeeIndex).setPosition(newPosition);
    }
}
