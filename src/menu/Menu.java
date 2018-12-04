package menu;

import company.module.Asset;
import company.module.Company;
import company.module.Employee;
import manager.AssetsManager;
import manager.CompanyManager;
import manager.EmployeesManager;
import manager.FinancialAssetsManager;
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
                    changeCompanyNameModule(company);
                    break;
                case "3":
                    changeHeadquarterModule(company);
                    break;
                case "4":
                    changeCompanyAddressModule(company);
                    break;
                case "5":
                    changeStartUpCapitalModule(company);
                    break;
                case "6":
                    isModulRunning = false;
                    getPrinter().print("Moduł zarządzanie firmą zostanie zamknięty.");
            }
        }
    }

    private void changeStartUpCapitalModule(Company company) {
        getPrinter().print("Podaj nowy kapitał początkowy");
        int newStartUpCapital = validateStartUpCapital();

        getCompanyManager().changeStartUpCapital(company, newStartUpCapital);
        getPrinter().print("Kapitał zakładowy został zmieniony");
    }

    private void changeCompanyAddressModule(Company company) {
        getPrinter().print("Podaj nowy adres firmy");
        String newAddress = getScanner().next();

        getCompanyManager().changeCompanyAddress(company, newAddress);
        getPrinter().print("Adres firmy został zmieniony");
    }

    private void changeHeadquarterModule(Company company) {
        getPrinter().print("Podaj nową siedzibę firmy");
        String newHeadquarter = getScanner().next();

        getCompanyManager().changeCompanyHeadquarter(company, newHeadquarter);
        getPrinter().print("Siedziba firmy zostala zmieniona");
    }

    private void changeCompanyNameModule(Company company) {
        getPrinter().print("Podaj nową nazwę firmy");
        String newCompanyName = getScanner().next();

        getCompanyManager().changeCompanyName(company, newCompanyName);
        getPrinter().print("Nazwa firmy została zmieniona");
    }


    private void runEmployeesModule(Company company) {
        boolean isModulRunning = true;
        String choice;

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
                    addNewEmployeeModule(company);
                    break;
                case "2":
                    getEmployeesManager().showAllEmployees(company);
                    break;
                case "3":
                    fireEmployeeModule(company);
                    break;
                case "4":
                    changeEmployeePositionModule(company);
                    break;
                case "5":
                    changeEmployeeSalaryModule(company);
                    break;
                case "6":
                    isModulRunning = false;
                    getPrinter().print("Moduł pracowniczy zostanie zamknięty");
            }
        }
    }

    private void changeEmployeeSalaryModule(Company company) {
        int employeeIndex;
        getPrinter().print("Podaj index pracownika, dla którego zostanie zmienione wynagrodzenie");
        employeeIndex = getScanner().nextInt();

        if (getEmployeesManager().canCompanyChangeEmployeeSettings(company, employeeIndex)) {
            getPrinter().print("Nie możesz zmienić wynagrodzenia dla pracownika o podanym indeksie");
        } else {
            getPrinter().print("Podaj nową wysokość wynagrodzenia");
            int newSalary = salaryValidator();

            getEmployeesManager().giveARise(company, employeeIndex, newSalary);
            getPrinter().print("Wynagrodzenie zostało zmienione dla pracownika o indeksie: " + employeeIndex);
        }
    }

    private void changeEmployeePositionModule(Company company) {
        int employeeIndex;
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
    }

    private void fireEmployeeModule(Company company) {
        int employeeIndex;
        getPrinter().print("Podaj numer indeksu pracownika do zwolnienia.");
        employeeIndex = getScanner().nextInt();

        if (getEmployeesManager().canCompanyChangeEmployeeSettings(company, employeeIndex)) {
            getPrinter().print("Nie możesz zwolnić pracownika o podanym indeksie.");
        } else {
            getEmployeesManager().fireEmployee(company, employeeIndex);
            getPrinter().print("Pracownik o indeksie: " + employeeIndex + " został usunięty z listy" +
                    " pracowników");
        }
    }

    private void addNewEmployeeModule(Company company) {
        getPrinter().print("Podaj imię pracownika");
        String name = getScanner().next();

        getPrinter().print("Podaj nazwisko pracownika");
        String lastname = getScanner().next();

        getPrinter().print("Podaj wiek pracownika");
        int age = ageValidator();


        getPrinter().print("Podaj wysokość wynagrodzenia pracownika");
        int salary = salaryValidator();

        getPrinter().print("Podaj stanowisko pracy");
        String position = getScanner().next();

        Employee employee = new Employee(name, lastname, age, salary, position);

        if (getEmployeesManager().canCompanyAddEmployee(company, employee)) {
            getEmployeesManager().addNewEmployee(company, employee);
            getPrinter().print("Nowy pracownik został dodany do listy pracowników");
        } else {
            getPrinter().print("Nie można dodać pracownika, ponieważ pracownik o danym imieniu i " +
                    "nazwisku już istnieje w bazie danych.");
        }
    }

    private int ageValidator() {
        int ageToCheck = scanner.nextInt();

        while (ageToCheck < 18 || ageToCheck > 65) {
            getPrinter().print("Wprowadż poprawny wiek pracownika z przedziału 18-65");
            ageToCheck = scanner.nextInt();
        }

        return ageToCheck;
    }

    private int salaryValidator() {
        int salaryToCheck = scanner.nextInt();

        while (salaryToCheck <= 0) {
            getPrinter().print("Wynagrodzenie nie może być mniejsze lub równe 0.");
            salaryToCheck = scanner.nextInt();
        }

        return salaryToCheck;
    }

    private void runFinancialAssetsModule(Company company) {
        boolean isModulRunning = true;
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
                    addCashModule(company);
                    break;
                case "3":
                    removeCashModule(company);
                    break;
                case "4":
                    paySalaryModule(company);
                    break;
                case "5":
                    calculateDepreciationModule(company);
                    break;
                case "6":
                    isModulRunning = false;
                    getPrinter().print("Moduł zarządzanie środkami finansowymi zostanie zamknięty.");
            }
        }
    }

    private void calculateDepreciationModule(Company company) {
        if (!getFinancialAssetsManager().canCompanyCalculateDepreciationRate(company)) {
            getPrinter().print("Brak środków trwałych w firmie - nie możesz policzyć stopy amortyzacji");
        } else {
            getFinancialAssetsManager().calculateDepreciationRate(company);
            getPrinter().print("Wartość środków trwałych została pomniejszona o stopę amortyzacji");
        }
    }

    private void paySalaryModule(Company company) {
        if (getFinancialAssetsManager().canCompanyPaySalary(company)) {
            getPrinter().print("Firma ma za mało środków pieniężnych na wypłatę wynagrodzeń");
        } else {
            getFinancialAssetsManager().paySalary(company);
            getPrinter().print("Wynagrodzenie zostało wypłacone pracownikom.");
        }
    }

    private void removeCashModule(Company company) {
        int cashValue;
        printer.print("Podaj wartość środków pieniężnych do usunięcia");
        cashValue = scanner.nextInt();

        if (!getFinancialAssetsManager().canCompanySpendCash(company, cashValue)) {
            getPrinter().print("Podana wartość jest wyższa od wartości posiadanych środków pieniężnych");
        } else {
            company.spendCash(cashValue);
            getPrinter().print("środki pieniężne został usunięte");
        }
    }

    private void addCashModule(Company company) {
        int cashValue;
        printer.print("Podaj wartość środków pieniężnych");
        cashValue = cashValidator();

        company.addCash(cashValue);
    }

    private int cashValidator() {
        int cashToCheck = scanner.nextInt();

        while (cashToCheck < 0) {
            getPrinter().print("Wartość gotówki nie może być mniejsza od 0");

            cashToCheck = scanner.nextInt();
        }

        return cashToCheck;
    }

    private void runAssetsModule(Company company) {
        boolean isModulRunning = true;

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
                    addNewAssetModule(company);
                    break;
                case "3":
                    removeAssetModule(company);
                    break;
                case "4":
                    isModulRunning = false;
                    getPrinter().print("Moduł zarządzanie firmą zostanie zamknięty");
            }
        }
    }

    private void removeAssetModule(Company company) {
        int assetIndex;
        getPrinter().print("Podaj indeks sprzętu do usunięcia");
        assetIndex = scanner.nextInt();

        if (!getAssetsManager().canCompanyDeleteAsset(company, assetIndex)) {
            getPrinter().print("Nie możesz usunąć sprzętu o danym indeksie");
        } else {
            getAssetsManager().deleteAsset(company, assetIndex);
            getPrinter().print("Sprzęt o indeksie: " + assetIndex + " został usunięty");
        }
    }

    private void addNewAssetModule(Company company) {
        getPrinter().print("Podaj nazwę sprzętu");
        String assetName = scanner.next();

        getPrinter().print("Podaj typ sprzętu");
        String assetType = scanner.next();

        getPrinter().print("Podaj wartość sprzętu");
        int assetValue = scanner.nextInt();

        getPrinter().print("Podaj stopę amortyzacji");
        int depreciationRate = depreciationRateValidator();

        Asset asset = new Asset(assetName, assetType, assetValue, depreciationRate);
        getAssetsManager().addAsset(company, asset);
    }

    private int depreciationRateValidator() {
        int depreciationRateToCheck = scanner.nextInt();

        while (depreciationRateToCheck <= 0) {
            getPrinter().print("Wartość amortyzacji nie może być mniejsza lub równa 0.");
            depreciationRateToCheck = scanner.nextInt();
        }

        return depreciationRateToCheck;
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
        startUpCapital = validateStartUpCapital();

        return new Company(companyName, headquarters, address, startUpCapital);
    }

    private int validateStartUpCapital() {
        int capitalToCheck = scanner.nextInt();

        while (capitalToCheck < 0) {
            getPrinter().print("Kapitał początkowy nie może być mniejszy od 0");

            capitalToCheck = scanner.nextInt();
        }

        return capitalToCheck;
    }
}
