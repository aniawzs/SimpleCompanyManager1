package managers;

import companyModules.Company;
import utils.Printer;

public class FinancialAssetsManager {
    private Printer printer = new Printer();
    public void showAllFinancialAssets(Company company) {
        printer.print("środki pieniężne firmy: " + company.getFinancialAssets() +
        "\n wartość środków trwałych: " + assetsValue(company));
    }

    private int assetsValue(Company company){
        int sum = 0;
        for(int i = 0; i<company.getAssets().length; i++){
            if(company.getAssets()[i]!=null){
                sum += company.getAssets()[i].getAssetValue();
            }
        }

        return sum;
    }


    public boolean canISpendCash(Company company, int cashValue){
        if(cashValue > company.getFinancialAssets()){
            return false;
        }

        else return true;
    }
}
