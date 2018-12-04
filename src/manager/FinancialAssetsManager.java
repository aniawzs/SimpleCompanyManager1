package manager;

import company.module.Asset;
import company.module.Company;
import company.module.Employee;
import utils.Printer;

public class FinancialAssetsManager {
    private Printer printer = new Printer();

    public void showAllFinancialAssets(Company company) {
        printer.print("środki pieniężne firmy: " + company.getFinancialAssets() +
                "\nwartość środków trwałych: " + assetsTotalValue(company));
    }

    private int assetsTotalValue(Company company) {
        int sum = 0;
        for (Asset asset : company.getAssets()) {
            sum += asset.getAssetValue();
        }

        return sum;
    }


    public boolean canCompanySpendCash(Company company, int cashValue) {
        return cashValue < company.getFinancialAssets();
    }

    public boolean canCompanyPaySalary(Company company) {
        return calculateEmployeesTotalSalary(company) > company.getFinancialAssets();
    }

    private int calculateEmployeesTotalSalary(Company company) {
        int totalSalaryValaue = 0;

        for (Employee employee : company.getEmployees()) {
            totalSalaryValaue += employee.getSalary();
        }

        return totalSalaryValaue;
    }

    public void paySalary(Company company) {
        company.spendCash(calculateEmployeesTotalSalary(company));
    }

    public boolean canCompanyCalculateDepreciationRate(Company company) {
        return !company.getAssets().isEmpty();
    }

    public void calculateDepreciationRate(Company company) {
        for (int i = 0; i < company.getAssets().size(); i++) {
            company.getAssets().get(i).setAssetValue(company.getAssets().get(i).getAssetValue() -
                    company.getAssets().get(i).getAssetValue() * company.getAssets().get(i).getDepreciationRate() / 100);
        }
    }
}
