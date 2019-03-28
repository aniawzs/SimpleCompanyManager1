package main.manager;

import main.modules.Company;
import main.modules.Employee;
import main.utils.Printer;

import java.util.Scanner;

public class EmployeesManager extends ManagerUtils{
    private Printer printer;
    private Company company;
    private Scanner scanner;

    public EmployeesManager(){
        this.printer = super.getPrinter();
        this.company = super.getCompany();
        this.scanner = super.getScanner();
    }


    public void changeEmployeeSalaryModule() {
        int employeeIndex;
        printer.print("Podaj index pracownika, dla którego zostanie zmienione wynagrodzenie");
        employeeIndex = scanner.nextInt();

        if (canCompanyChangeEmployeeSettings(employeeIndex)) {
            printer.print("Nie możesz zmienić wynagrodzenia dla pracownika o podanym indeksie");
        } else {
            printer.print("Podaj nową wysokość wynagrodzenia");
            int newSalary = salaryValidator();

            giveARise(employeeIndex, newSalary);
            printer.print("Wynagrodzenie zostało zmienione dla pracownika o indeksie: " + employeeIndex);
        }
    }

    public void changeEmployeePositionModule() {
        int employeeIndex;
        printer.print("Podaj index pracownika, dla którego zostanie zmienione stanowisko");
        employeeIndex = scanner.nextInt();

        if (canCompanyChangeEmployeeSettings(employeeIndex)) {
            printer.print("Nie możesz zmienić stanowiska dla pracownika o podanym indeksie.");
        } else {
            printer.print("Podaj nazwę nowego stanowiska");
            String newPosition = scanner.next();

            changeEmployeePosition(employeeIndex, newPosition);
            printer.print("Stanowisko pracownika zostało zmienione");
        }
    }

    public void fireEmployeeModule() {
        int employeeIndex;
        printer.print("Podaj numer indeksu pracownika do zwolnienia.");
        employeeIndex = scanner.nextInt();

        if (canCompanyChangeEmployeeSettings(employeeIndex)) {
            printer.print("Nie możesz zwolnić pracownika o podanym indeksie.");
        } else {
            fireEmployee(employeeIndex);
            printer.print("Pracownik o indeksie: " + employeeIndex + " został usunięty z listy" +
                    " pracowników");
        }
    }

    private void fireEmployee(int employeeIndexToDelete) {
        company.getEmployees().remove(employeeIndexToDelete);
    }

    public void showAllEmployees() {
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

    public void addNewEmployeeModule() {
        printer.print("Podaj imię pracownika");
        String name = scanner.next();

        printer.print("Podaj nazwisko pracownika");
        String lastname = scanner.next();

        printer.print("Podaj wiek pracownika");
        int age = ageValidator();


        printer.print("Podaj wysokość wynagrodzenia pracownika");
        int salary = salaryValidator();

        printer.print("Podaj stanowisko pracy");
        String position = scanner.next();

        Employee employee = new Employee(name, lastname, age, salary, position);

        if (canCompanyAddEmployee(employee)) {
            addNewEmployee(employee);
            printer.print("Nowy pracownik został dodany do listy pracowników");
        } else {
            printer.print("Nie można dodać pracownika, ponieważ pracownik o danym imieniu i " +
                    "nazwisku już istnieje w bazie danych.");
        }
    }

    private int ageValidator() {
        int ageToCheck = scanner.nextInt();

        while (ageToCheck < 18 || ageToCheck > 65) {
            printer.print("Wprowadż poprawny wiek pracownika z przedziału 18-65");
            ageToCheck = scanner.nextInt();
        }

        return ageToCheck;
    }

    private int salaryValidator() {
        int salaryToCheck = scanner.nextInt();

        while (salaryToCheck <= 0) {
            printer.print("Wynagrodzenie nie może być mniejsze lub równe 0.");
            salaryToCheck = scanner.nextInt();
        }

        return salaryToCheck;
    }

    private void giveARise(int employeeIndex, int newSalary) {
        company.getEmployees().get(employeeIndex).setSalary(newSalary);
    }

    private boolean canCompanyChangeEmployeeSettings(int employeeIndex) {
        return employeeIndex >= company.getEmployees().size() || employeeIndex < 0;


    }

    private void changeEmployeePosition(int employeeIndex, String newPosition) {
        company.getEmployees().get(employeeIndex).setPosition(newPosition);
    }

    private void addNewEmployee(Employee employee) {
        company.getEmployees().add(employee);
    }

    private boolean canCompanyAddEmployee(Employee employee) {
        for (int i = 0; i < company.getEmployees().size(); i++) {
            if (company.getEmployees().get(i).getName().equals(employee.getName())
                    && company.getEmployees().get(i).getLastname().equals(employee.getLastname())) {
                return false;
            }
        }
        return true;
    }

}
