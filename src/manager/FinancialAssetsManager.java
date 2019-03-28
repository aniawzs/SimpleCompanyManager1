package manager;

import company.module.Asset;
import company.module.Company;
import company.module.Employee;
import utils.Printer;

import java.util.Scanner;

public class FinancialAssetsManager extends ManagerUtils {
    private Printer printer;
    private Scanner scanner;
    private Company company;

    public FinancialAssetsManager() {
        this.printer = super.getPrinter();
        this.company = super.getCompany();
        this.scanner = super.getScanner();
    }

    public void showAllFinancialAssets() {
        printer.print("środki pieniężne firmy: " + company.getFinancialAssets() +
                "\nwartość środków trwałych: " + assetsTotalValue());
    }

    private int assetsTotalValue() {
        int sum = 0;
        for (Asset asset : company.getAssets()) {
            sum += asset.getAssetValue();
        }

        return sum;
    }

    public void calculateDepreciationModule() {
        if (canCompanyCalculateDepreciationRate()) {
            printer.print("Brak środków trwałych w firmie - nie możesz policzyć stopy amortyzacji");
        } else {
            calculateDepreciationRate(company);
            printer.print("Wartość środków trwałych została pomniejszona o stopę amortyzacji");
        }
    }

    public void paySalaryModule() {
        if (canCompanyPaySalary()) {
            printer.print("Firma ma za mało środków pieniężnych na wypłatę wynagrodzeń");
        } else {
            paySalary();
            printer.print("Wynagrodzenie zostało wypłacone pracownikom.");
        }
    }

    public void removeCashModule() {
        int cashValue;
        printer.print("Podaj wartość środków pieniężnych do usunięcia");
        cashValue = scanner.nextInt();

        if (canCompanySpendCash(cashValue)) {
            printer.print("Podana wartość jest wyższa od wartości posiadanych środków pieniężnych");
        } else {
            company.spendCash(cashValue);
            printer.print("środki pieniężne został usunięte");
        }
    }

    public void addCashModule() {
        int cashValue;
        printer.print("Podaj wartość środków pieniężnych");
        cashValue = cashValidator();

        company.addCash(cashValue);
    }

    private boolean canCompanySpendCash(int cashValue) {
        return cashValue < company.getFinancialAssets();
    }

    private boolean canCompanyPaySalary() {
        return calculateEmployeesTotalSalary(company) > company.getFinancialAssets();
    }

    private int cashValidator() {
        int cashToCheck = scanner.nextInt();

        while (cashToCheck < 0) {
            printer.print("Wartość gotówki nie może być mniejsza od 0");

            cashToCheck = scanner.nextInt();
        }

        return cashToCheck;
    }

    private int calculateEmployeesTotalSalary(Company company) {
        int totalSalaryValaue = 0;

        for (Employee employee : company.getEmployees()) {
            totalSalaryValaue += employee.getSalary();
        }

        return totalSalaryValaue;
    }

    private void paySalary() {
        company.spendCash(calculateEmployeesTotalSalary(company));
    }

    private boolean canCompanyCalculateDepreciationRate() {
        return !company.getAssets().isEmpty();
    }

    private void calculateDepreciationRate(Company company) {
        for (int i = 0; i < company.getAssets().size(); i++) {
            company.getAssets().get(i).setAssetValue(company.getAssets().get(i).getAssetValue() -
                    company.getAssets().get(i).getAssetValue() * company.getAssets().get(i).getDepreciationRate() / 100);
        }
    }
}
