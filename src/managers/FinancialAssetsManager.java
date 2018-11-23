package managers;

import companyModules.Company;
import utils.Printer;

public class FinancialAssetsManager {
    private Printer printer = new Printer();

    public void showAllFinancialAssets(Company company) {
        printer.print("środki pieniężne firmy: " + company.getFinancialAssets() +
                "\nwartość środków trwałych: " + assetsTotalValue(company));
    }

    private int assetsTotalValue(Company company) {
        int sum = 0;
        for (int i = 0; i < company.getAssets().length; i++) {
            if (company.getAssets()[i] != null) {
                sum += company.getAssets()[i].getAssetValue();
            }
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

        for (int i = 0; i < company.getEmployees().length; i++) {
            if (company.getEmployees()[i] != null) {
                totalSalaryValaue += company.getEmployees()[i].getSalary();
            }
        }
        return totalSalaryValaue;
    }

    public void paySalary(Company company) {
        company.spendCash(calculateEmployeesTotalSalary(company));
    }

    public boolean canCompanyCalculateDepreciationRate(Company company) {
        return company.getAssets().length > 0;
    }

    public void calculateDepreciationRate(Company company) {
        for (int i = 0; i < company.getAssets().length; i++) {
            if (company.getAssets()[i] != null) {
                company.getAssets()[i].setAssetValue(company.getAssets()[i].getAssetValue()
                        - company.getAssets()[i].getAssetValue() * company.getAssets()[i].getDepreciationRate());
            }
        }
    }
}
