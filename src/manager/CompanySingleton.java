package manager;

import company.module.Company;
import utils.Printer;

import java.util.Scanner;

public class CompanySingleton {
    private static CompanySingleton company_instance = null;
    private static Company company;
    private Printer printer;
    private Scanner scanner;

    private CompanySingleton() {
        this.printer = new Printer();
        this.scanner = new Scanner(System.in);
    }

    public static CompanySingleton getInstance() {
        if (company_instance == null) {
            company_instance = new CompanySingleton();
            company = company_instance.createCompany();

        }
        return company_instance;
    }

    public Company getCompany() {
        return company;
    }

    private Company createCompany() {
        String headquarters;
        String address;
        int startUpCapital;
        String companyName;

        printer.print("Podaj nazwę firmy");
        companyName = scanner.nextLine();

        printer.print("Podaj siedzibę firmy");
        headquarters = scanner.nextLine();

        printer.print("Podaj adres firmy");
        address = scanner.nextLine();

        printer.print("Podaj kapitał początkowy firmy w PLN");
        startUpCapital = validateStartUpCapital();

        return new Company(companyName, headquarters, address, startUpCapital);
    }

    private int validateStartUpCapital() {
        int capitalToCheck = new Scanner(System.in).nextInt();

        while (capitalToCheck < 0) {
            printer.print("Kapitał początkowy nie może być mniejszy od 0");

            capitalToCheck = new Scanner(System.in).nextInt();
        }

        return capitalToCheck;
    }
}
