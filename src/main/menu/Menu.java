package main.menu;

import main.manager.*;
import main.modules.Company;
import main.utils.Printer;

import java.util.Scanner;

public class Menu {
    private Printer printer;
    private Scanner scanner;
    private EmployeesManager employeesManager;
    private CompanyManager companyManager;
    private AssetsManager assetsManager;
    private FinancialAssetsManager financialAssetsManager;
    private Company company;

    public Menu() {
        this.printer = new Printer();
        this.scanner = new Scanner(System.in);
        this.employeesManager = new EmployeesManager();
        this.companyManager = new CompanyManager();
        this.assetsManager = new AssetsManager();
        this.financialAssetsManager = new FinancialAssetsManager();
    }


    public void runMainMenu() {
        boolean isProgramRunning = true;
        String choice;
        printer.print("Witaj w programie do zarządzania Twoją firmą!");
        company = CompanySingleton.getInstance().getCompany();

        while (isProgramRunning) {
            printer.print("Wpisz wybrany numer modułu: \n" +
                    "1. Zarządzanie firmą \n" +
                    "2. Zarzadzanie pracownikami \n" +
                    "3. Zarządzanie majątkiem \n" +
                    "4. Zarządzanie sprzętem firmy \n" +
                    "5. Wyjdź z programu");

            choice = scanner.next();

            switch (choice) {
                case "1":
                    runCompanyModule();
                    break;
                case "2":
                    runEmployeesModule();
                    break;
                case "3":
                    runFinancialAssetsModule();
                    break;
                case "4":
                    runAssetsModule();
                    break;
                case "5":
                    isProgramRunning = false;
            }
        }
    }

    private void runCompanyModule() {
        boolean isModuleRunning = true;
        String choice;

        while (isModuleRunning) {
            printer.print("Wybierz : \n" +
                    "1. Informacje o firmie \n" +
                    "2. Zmiana nazwy firmy \n" +
                    "3. Zmiana siedziby firmy  \n" +
                    "4. Zmiana adresu firmy \n" +
                    "5. Zmiana majątku początkowego \n" +
                    "6. Wyjdź z modułu zarządzanie firmą");

            choice = scanner.next();
            switch (choice) {
                case "1":
                    companyManager.showCompanyInformation();
                    break;
                case "2":
                    companyManager.changeCompanyNameModule();
                    break;
                case "3":
                    companyManager.changeHeadquarterModule();
                    break;
                case "4":
                    companyManager.changeCompanyAddressModule();
                    break;
                case "5":
                    companyManager.changeStartUpCapitalModule();
                    break;
                case "6":
                    isModuleRunning = false;
                    printer.print("Moduł zarządzanie firmą zostanie zamknięty.");
            }
        }
    }


   


    private void runEmployeesModule() {
        boolean isModulRunning = true;
        String choice;

        while (isModulRunning) {
            printer.print("Wybierz : \n" +
                    "1. Zatrudnienia \n" +
                    "2. Wyświetlanie pracowników \n" +
                    "3. Zwolnienia  \n" +
                    "4. Awanse \n" +
                    "5. Podwyżki \n" +
                    "6. Wyjdź z modułu pracownicy");

            choice = scanner.next();
            switch (choice) {
                case "1":
                    employeesManager.addNewEmployeeModule();
                    break;
                case "2":
                    employeesManager.showAllEmployees();
                    break;
                case "3":
                    employeesManager.fireEmployeeModule();
                    break;
                case "4":
                    employeesManager.changeEmployeePositionModule();
                    break;
                case "5":
                    employeesManager.changeEmployeeSalaryModule();
                    break;
                case "6":
                    isModulRunning = false;
                    printer.print("Moduł pracowniczy zostanie zamknięty");
            }
        }
    }

    private void runFinancialAssetsModule() {
        boolean isModulRunning = true;
        String choice;

        while (isModulRunning) {
            printer.print("Wybierz : \n" +
                    "1. Zobacz wszystkie środki pieniężne i bieżącą wartość aktywów trwałych.\n" +
                    "2. Dodaj środki pieniężne\n" +
                    "3. Usuń środki pieniężne \n" +
                    "4. Wypłata wynagrodzeń \n" +
                    "5. Amortyzacja sprzętu \n" +
                    "6. Wyjdź z modułu zarządzanie środkami finansowymi");

            choice = scanner.next();
            switch (choice) {
                case "1":
                    financialAssetsManager.showAllFinancialAssets();
                    break;
                case "2":
                    financialAssetsManager.addCashModule();
                    break;
                case "3":
                    financialAssetsManager.removeCashModule();
                    break;
                case "4":
                    financialAssetsManager.paySalaryModule();
                    break;
                case "5":
                    financialAssetsManager.calculateDepreciationModule();
                    break;
                case "6":
                    isModulRunning = false;
                    printer.print("Moduł zarządzanie środkami finansowymi zostanie zamknięty.");
            }
        }
    }

    private void runAssetsModule() {
        boolean isModulRunning = true;

        String choice;
        while (isModulRunning) {
            printer.print("Wybierz : \n" +
                    "1. Wyświetl majątek całkowity \n" +
                    "2. Dodaj nowy sprzęt \n" +
                    "3. Usuń sprzęt \n" +
                    "4. Wyjdź z modułu zarządzanie sprzętem firmy");

            choice = scanner.next();

            switch (choice) {
                case "1":
                    assetsManager.showAllAssets();
                    break;
                case "2":
                    assetsManager.addNewAssetModule();
                    break;
                case "3":
                    assetsManager.removeAssetModule();
                    break;
                case "4":
                    isModulRunning = false;
                    printer.print("Moduł zarządzanie firmą zostanie zamknięty");
            }
        }
    }
    
}
