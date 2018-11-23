package menu;

import companyModules.Assets;
import companyModules.Company;
import companyModules.Employees;
import managers.AssetsManager;
import managers.CompanyManager;
import managers.EmployeesManager;
import managers.FinancialAssetsManager;
import utils.Printer;

import java.util.Scanner;

public class Menu {
    private Printer printer;
    private Scanner scanner;
    private EmployeesManager employeesManager;
    private CompanyManager companyManager;
    private AssetsManager assetsManager;
    private FinancialAssetsManager financialAssetsManager;


    public Menu() {
        this.printer = new Printer();
        this.scanner = new Scanner(System.in);
        this.employeesManager = new EmployeesManager();
        this.companyManager = new CompanyManager();
        this.assetsManager = new AssetsManager();
        this.financialAssetsManager = new FinancialAssetsManager();
    }

    private Printer getPrinter() {
        return printer;
    }

    private Scanner getScanner() {
        return scanner;
    }

    private EmployeesManager getEmployeesManager() {
        return employeesManager;
    }

    private CompanyManager getCompanyManager() {
        return companyManager;
    }

    private AssetsManager getAssetsManager() {
        return assetsManager;
    }

    private FinancialAssetsManager getFinancialAssetsManager() {
        return financialAssetsManager;
    }


    public void runMainMenu() {
        boolean isProgramRunning = true;
        String choice;
        getPrinter().print("Witaj w programie do zarządzania Twoją firmą!");
        Company company = createCompany();

        while (isProgramRunning) {
            getPrinter().print("Wpisz wybrany numer modułu: \n" +
                    "1. Zarządzanie firmą \n" +
                    "2. Zarzadzanie pracownikami \n" +
                    "3. Zarządzanie majątkiem \n" +
                    "4. Zarządzanie sprzętem firmy \n" +
                    "5. Wyjdź z programu");

            choice = getScanner().next();

            switch (choice) {
                case "1":
                    runCompanyModule(company);
                    break;
                case "2":
                    runEmployeesModule(company);
                    break;
                case "3":
                    runFinancialAssetsModule(company);
                    break;
                case "4":
                    runAssetsModule(company);
                    break;
                case "5":
                    isProgramRunning = false;
            }
        }
    }

    private void runCompanyModule(Company company) {
        boolean isModulRunning = true;
        String choice;

        while (isModulRunning) {
            getPrinter().print("Wybierz : \n" +
                    "1. Informacje o firmie \n" +
                    "2. Zmiana nazwy firmy \n" +
                    "3. Zmiana siedziby firmy  \n" +
                    "4. Zmiana adresu firmy \n" +
                    "5. Zmiana majątku początkowego \n" +
                    "6. Wyjdź z modułu zarządzanie firmą");

            choice = getScanner().next();
            switch (choice) {
                case "1":
                    getCompanyManager().showCompanyInformation(company);
                    break;
                case "2":
                    getPrinter().print("Podaj nową nazwę firmy");
                    String newCompanyName = getScanner().next();

                    getCompanyManager().changeCompanyName(company, newCompanyName);
                    getPrinter().print("Nazwa firmy została zmieniona");
                    break;
                case "3":
                    getPrinter().print("Podaj nową siedzibę firmy");
                    String newHeadquarter = getScanner().next();

                    getCompanyManager().changeCompanyHeadquarter(company, newHeadquarter);
                    getPrinter().print("Siedziba firmy zostala zmieniona");
                    break;
                case "4":
                    getPrinter().print("Podaj nowy adres firmy");
                    String newAddress = getScanner().next();

                    getCompanyManager().changeCompanyAddress(company, newAddress);
                    getPrinter().print("Adres firmy został zmieniony");
                    break;
                case "5":
                    getPrinter().print("Podaj nowy kapitał początkowy");
                    int newStartUpCapital = getScanner().nextInt();

                    getCompanyManager().changeStartUpCapital(company, newStartUpCapital);
                    getPrinter().print("Kapitał zakładowy został zmieniony");
                    break;
                case "6":
                    isModulRunning = false;
                    getPrinter().print("Moduł zarządzanie firmą zostanie zamknięty.");
            }
        }
    }


    private void runEmployeesModule(Company company) {
        boolean isModulRunning = true;
        String choice;
        int employeeIndex;

        while (isModulRunning) {
            getPrinter().print("Wybierz : \n" +
                    "1. Zatrudnienia \n" +
                    "2. Wyświetlanie pracowników \n" +
                    "3. Zwolnienia  \n" +
                    "4. Awanse \n" +
                    "5. Podwyżki \n" +
                    "6. Wyjdź z modułu pracownicy");

            choice = getScanner().next();
            switch (choice) {
                case "1":
                    getPrinter().print("Podaj imię pracownika");
                    String name = getScanner().next();

                    getPrinter().print("Podaj nazwisko pracownika");
                    String lastname = getScanner().next();

                    getPrinter().print("Podaj wiek pracownika");
                    int age = getScanner().nextInt();

                    getPrinter().print("Podaj wysokość wynagrodzenia pracownika");
                    int salary = getScanner().nextInt();

                    getPrinter().print("Podaj stanowisko pracy");
                    String position = getScanner().next();

                    Employees employee = new Employees(name, lastname, age, salary, position);

                    if (getEmployeesManager().canCompanyAddEmployee(company, employee)) {
                        getEmployeesManager().addNewEmployee(company, employee);
                        getPrinter().print("Nowy pracownik został dodany do listy pracowników");
                    } else {
                        getPrinter().print("Nie można dodać pracownika, ponieważ pracownik o danym imieniu i " +
                                "nazwisku już istnieje w bazie danych.");
                    }
                    break;
                case "2":
                    getEmployeesManager().showAllEmployees(company);
                    break;
                case "3":
                    getPrinter().print("Podaj numer indeksu pracownika do zwolnienia.");
                    employeeIndex = getScanner().nextInt();

                    if (getEmployeesManager().canCompanyChangeEmployeeSettings(company, employeeIndex)) {
                        getPrinter().print("Nie możesz zwolnić pracownika o podanym indeksie.");
                    } else {
                        getEmployeesManager().fireEmployee(company, employeeIndex);
                        getPrinter().print("Pracownik o indeksie: " + employeeIndex + " został usunięty z listy" +
                                " pracowników");
                    }
                    break;
                case "4":
                    getPrinter().print("Podaj index pracownika, dla którego zostanie zmienione stanowisko");
                    employeeIndex = getScanner().nextInt();

                    if (getEmployeesManager().canCompanyChangeEmployeeSettings(company, employeeIndex)) {
                        getPrinter().print("Nie możesz zmienić stanowiska dla pracownika o podanym indeksie.");
                    } else {
                        getPrinter().print("Podaj nazwę nowego stanowiska");
                        String newPosition = getScanner().next();

                        getEmployeesManager().changeEmployeePosition(company, employeeIndex, newPosition);
                        getPrinter().print("Stanowisko pracownika zostało zmienione");
                    }
                    break;
                case "5":
                    getPrinter().print("Podaj index pracownika, dla którego zostanie zmienione wynagrodzenie");
                    employeeIndex = getScanner().nextInt();

                    if (getEmployeesManager().canCompanyChangeEmployeeSettings(company, employeeIndex)) {
                        getPrinter().print("Nie możesz zmienić wynagrodzenia dla pracownika o podanym indeksie");
                    } else {
                        getPrinter().print("Podaj nową wysokość wynagrodzenia");
                        int newSalary = getScanner().nextInt();

                        getEmployeesManager().giveARise(company, employeeIndex, newSalary);
                        getPrinter().print("Wynagrodzenie zostało zmienione dla pracownika o indeksie: " + employeeIndex);
                    }
                    break;
                case "6":
                    isModulRunning = false;
                    getPrinter().print("Moduł pracowniczy zostanie zamknięty");
            }
        }
    }

    private void runFinancialAssetsModule(Company company) {
        boolean isModulRunning = true;
        int cashValue;
        String choice;

        while (isModulRunning) {
            getPrinter().print("Wybierz : \n" +
                    "1. Zobacz wszystkie środki pieniężne i bieżącą wartość aktywów trwałych.\n" +
                    "2. Dodaj środki pieniężne\n" +
                    "3. Usuń środki pieniężne \n" +
                    "4. Wypłata wynagrodzeń \n" +
                    "5. Amortyzacja sprzętu \n" +
                    "6. Wyjdź z modułu zarządzanie środkami finansowymi");

            choice = getScanner().next();
            switch (choice) {
                case "1":
                    getFinancialAssetsManager().showAllFinancialAssets(company);
                    break;
                case "2":
                    printer.print("Podaj wartość środków pieniężnych");
                    cashValue = scanner.nextInt();

                    company.addCash(cashValue);
                    break;
                case "3":
                    printer.print("Podaj wartość środków pieniężnych do usunięcia");
                    cashValue = scanner.nextInt();

                    if (!getFinancialAssetsManager().canCompanySpendCash(company, cashValue)) {
                        getPrinter().print("Podana wartość jest wyższa od wartości posiadanych środków pieniężnych");
                    } else {
                        company.spendCash(cashValue);
                        getPrinter().print("środki pieniężne został usunięte");
                    }
                    break;
                case "4":
                    if (getFinancialAssetsManager().canCompanyPaySalary(company)) {
                        getPrinter().print("Firma ma za mało środków pieniężnych na wypłatę wynagrodzeń");
                    } else {
                        getFinancialAssetsManager().paySalary(company);
                        getPrinter().print("Wynagrodzenie zostało wypłacone pracownikom.");
                    }
                    break;
                case "5":
                    if (!getFinancialAssetsManager().canCompanyCalculateDepreciationRate(company)) {
                        getPrinter().print("Brak środków trwałych w firmie - nie możesz policzyć stopy amortyzacji");
                    } else {
                        getFinancialAssetsManager().calculateDepreciationRate(company);
                        getPrinter().print("Wartość środków trwałych została pomniejszona o stopę amortyzacji");
                    }
                    break;
                case "6":
                    isModulRunning = false;
                    getPrinter().print("Moduł zarządzanie środkami finansowymi zostanie zamknięty.");
            }
        }
    }

    private void runAssetsModule(Company company) {
        boolean isModulRunning = true;
        int assetIndex;

        String choice;
        while (isModulRunning) {
            getPrinter().print("Wybierz : \n" +
                    "1. Wyświetl majątek całkowity \n" +
                    "2. Dodaj nowy sprzęt \n" +
                    "3. Usuń sprzęt \n" +
                    "4. Wyjdź z modułu zarządzanie sprzętem firmy");

            choice = getScanner().next();

            switch (choice) {
                case "1":
                    getAssetsManager().showAllAssets(company);
                    break;
                case "2":
                    getPrinter().print("Podaj nazwę sprzętu");
                    String assetName = scanner.next();

                    getPrinter().print("Podaj typ sprzętu");
                    String assetType = scanner.next();

                    getPrinter().print("Podaj wartość sprzętu");
                    int assetValue = scanner.nextInt();

                    getPrinter().print("Podaj stopę amortyzacji");
                    int depreciationRate = scanner.nextInt();

                    Assets asset = new Assets(assetName, assetType, assetValue, depreciationRate);
                    getAssetsManager().addAsset(company, asset);
                    break;
                case "3":
                    getPrinter().print("Podaj indeks sprzętu do usunięcia");
                    assetIndex = scanner.nextInt();

                    if (!getAssetsManager().canCompanyDeleteAsset(company, assetIndex)) {
                        getPrinter().print("Nie możesz usunąć sprzętu o danym indeksie");
                    } else {
                        getAssetsManager().deleteAsset(company, assetIndex);
                        getPrinter().print("Sprzęt o indeksie: " + assetIndex + " został usunięty");
                    }
                    break;
                case "4":
                    isModulRunning = false;
                    getPrinter().print("Moduł zarządzanie firmą zostanie zamknięty");
            }
        }
    }

    private Company createCompany() {
        String headquarters;
        String address;
        int startUpCapital;
        String companyName;

        getPrinter().print("Podaj nazwę firmy");
        companyName = getScanner().nextLine();

        getPrinter().print("Podaj siedzibę firmy");
        headquarters = getScanner().nextLine();

        getPrinter().print("Podaj adres firmy");
        address = getScanner().nextLine();

        getPrinter().print("Podaj kapitał początkowy firmy w PLN");
        startUpCapital = getScanner().nextInt();

        return new Company(companyName, headquarters, address, startUpCapital);
    }

}
