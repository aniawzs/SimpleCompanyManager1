package managers;

import companyModules.Assets;
import companyModules.Company;
import utils.Printer;

import java.util.Arrays;

public class AssetsManager {
    private final Printer printer = new Printer();

    public void showAllAssets(Company company) {
        if (company.getAssets().length == 0) {
            printer.print("Firma nie posiada majątku trwałego");
            return;
        }

        for (int i = 0; i < company.getAssets().length; i++) {
            if (company.getAssets()[i] != null) {
                printer.print("Nazwa sprzętu: " + company.getAssets()[i].getAssetName() + ", typ sprzetu: " +
                        company.getAssets()[i].getAssetType() + ", wartość sprzętu: " + company.getAssets()[i].getAssetValue() +
                        ", stopa amortyzacji: " + company.getAssets()[i].getDepreciationRate() + "%");
            }
        }
    }

    public void addAsset(Company company, Assets assets) {
        for (int i = 0; i < company.getAssets().length; i++) {
            if (company.getAssets()[i] == null) {
                company.getAssets()[i] = assets;
                return;
            }
        }
        company.setAssets(Arrays.copyOf(company.getAssets(), company.getAssets().length + 1));
        company.getAssets()[company.getAssets().length - 1] = assets;
    }

    public boolean canCompanyDeleteAsset(Company company, int assetIndex) {
        if (assetIndex >= company.getAssets().length) {
            return false;
        } else {
            for (int i = 0; i < company.getAssets().length; i++) {
                if (company.getAssets()[i] == null) {
                    return false;
                }
            }
        }
        return true;
    }

    public void deleteAsset(Company company, int assetIndex) {
        company.addCash(company.getAssets()[assetIndex].getAssetValue());
        company.getAssets()[assetIndex] = null;
    }
}
