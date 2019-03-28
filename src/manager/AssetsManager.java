package manager;

import company.module.Asset;
import company.module.Company;
import utils.Printer;

import java.util.Scanner;

public class AssetsManager extends ManagerUtils{
    private final Printer printer;
    private Company company;
    private Scanner scanner;

    public AssetsManager() {
        this.printer = super.getPrinter();
        this.scanner = super.getScanner();
        this.company = super.getCompany();
    }

    public void showAllAssets() {
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

    public void removeAssetModule() {
        int assetIndex;
        printer.print("Podaj indeks sprzętu do usunięcia");
        assetIndex = scanner.nextInt();

        if (canCompanyDeleteAsset()) {
            printer.print("Nie możesz usunąć sprzętu o danym indeksie");
        } else {
            deleteAsset(assetIndex);
            printer.print("Sprzęt o indeksie: " + assetIndex + " został usunięty");
        }
    }

    public void addNewAssetModule() {
        printer.print("Podaj nazwę sprzętu");
        String assetName = scanner.next();

        printer.print("Podaj typ sprzętu");
        String assetType = scanner.next();

        printer.print("Podaj wartość sprzętu");
        int assetValue = scanner.nextInt();

        printer.print("Podaj stopę amortyzacji");
        int depreciationRate = depreciationRateValidator();

        Asset asset = new Asset(assetName, assetType, assetValue, depreciationRate);
        addAsset(asset);
    }

    private int depreciationRateValidator() {
        int depreciationRateToCheck = scanner.nextInt();

        while (depreciationRateToCheck <= 0) {
            printer.print("Wartość amortyzacji nie może być mniejsza lub równa 0.");
            depreciationRateToCheck = scanner.nextInt();
        }

        return depreciationRateToCheck;
    }

    private void addAsset(Asset assets) {
        company.getAssets().add(assets);
    }

    private boolean canCompanyDeleteAsset() {
        company.getAssets().size();
        return true;
    }

    private void deleteAsset(int assetIndex) {
        company.addCash(company.getAssets().get(assetIndex).getAssetValue());
        company.getAssets().remove(assetIndex);
    }
}
