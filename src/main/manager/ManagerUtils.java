package main.manager;

import main.modules.Company;
import main.utils.Printer;

import java.util.Scanner;

public class ManagerUtils {
    private Company company;
    private final Printer printer;
    private final Scanner scanner;

    ManagerUtils(){
        printer = new Printer();
        scanner = new Scanner(System.in);
        company = CompanySingleton.getInstance().getCompany();
    }

    public Printer getPrinter() {
        return printer;
    }

    public Company getCompany() {
        return company;
    }

    public Scanner getScanner() {
        return scanner;
    }
}
