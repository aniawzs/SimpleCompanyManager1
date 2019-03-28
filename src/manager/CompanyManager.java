package manager;


import company.module.Company;
import utils.Printer;

import java.util.Scanner;

public class CompanyManager extends ManagerUtils{
    private Printer printer;
    private Scanner scanner;
    private Company company;
    
    public CompanyManager(){
        this.printer = super.getPrinter();
        this.scanner = super.getScanner();
        this.company = super.getCompany();
    }

    public void showCompanyInformation() {
        printer.print("Nazwa firmy: " + super.getCompany().getCompanyName());
        printer.print("Siedziba firmy: " + company.getHeadquarters());
        printer.print("Adres firmy: " + company.getAddress());
        printer.print("Kapital początkowy firmy: " + company.getStartUpCapital());
    }

    public void changeCompanyNameModule() {
        printer.print("Podaj nową nazwę firmy");
        String newCompanyName = scanner.next();

        changeCompanyName(newCompanyName);
        printer.print("Nazwa firmy została zmieniona");
    }

    public void changeStartUpCapitalModule() {
        printer.print("Podaj nowy kapitał początkowy");
        int newStartUpCapital = validateStartUpCapital();

        changeStartUpCapital(newStartUpCapital);
        printer.print("Kapitał zakładowy został zmieniony");
    }

    public void changeCompanyAddressModule() {
        printer.print("Podaj nowy adres firmy");
        String newAddress = scanner.next();

        changeCompanyAddress(newAddress);
        printer.print("Adres firmy został zmieniony");
    }

    public void changeHeadquarterModule() {
        printer.print("Podaj nową siedzibę firmy");
        String newHeadquarter = scanner.next();

        changeCompanyHeadquarter(newHeadquarter);
        printer.print("Siedziba firmy zostala zmieniona");
    }

    private void changeCompanyName(String newCompanyName) {
        company.setCompanyName(newCompanyName);
    }

    private void changeCompanyHeadquarter(String newHeadquarter) {
        company.setHeadquarters(newHeadquarter);
    }

    private void changeCompanyAddress(String newAddress) {
        company.setAddress(newAddress);
    }

    private void changeStartUpCapital(int newStartUpCapital) {
        company.setStartUpCapital(newStartUpCapital);
    }

    private int validateStartUpCapital() {
        int capitalToCheck = scanner.nextInt();

        while (capitalToCheck < 0) {
            printer.print("Kapitał początkowy nie może być mniejszy od 0");

            capitalToCheck = scanner.nextInt();
        }

        return capitalToCheck;
    }
}
