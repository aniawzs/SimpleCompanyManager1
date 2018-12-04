package manager;

import company.module.Asset;
import company.module.Company;
import utils.Printer;

public class AssetsManager {
    private final Printer printer = new Printer();

    public void showAllAssets(Company company) {
        if (company.getAssets().isEmpty()) {
            printer.print("Firma nie posiada majątku trwałego");
            return;
        }

        for (int i = 0; i < company.getAssets().size(); i++) {
            printer.print("Nazwa sprzętu: " + company.getAssets().get(i).getAssetName() + ", typ sprzetu: " +
                    company.getAssets().get(i).getAssetType() + ", wartość sprzętu: " + company.getAssets().get(i).getAssetValue() +
                    ", stopa amortyzacji: " + company.getAssets().get(i).getDepreciationRate() + "%");
        }
    }

    public void addAsset(Company company, Asset assets) {
        company.getAssets().add(assets);
    }

    public boolean canCompanyDeleteAsset(Company company, int assetIndex) {
        return assetIndex <= company.getAssets().size() || assetIndex > 0;
    }

    public void deleteAsset(Company company, int assetIndex) {
        company.addCash(company.getAssets().get(assetIndex).getAssetValue());
        company.getAssets().remove(assetIndex);
    }
}
