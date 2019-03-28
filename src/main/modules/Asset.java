package main.modules;

public class Asset {
    private String assetName;
    private String assetType;
    private double assetValue;
    private int depreciationRate;

    public Asset(String assetName, String assetType, double assetValue, int depreciationRate) {
        this.assetName = assetName;
        this.assetType = assetType;
        this.assetValue = assetValue;
        this.depreciationRate = depreciationRate;
    }

    public String getAssetName() {
        return assetName;
    }

    public String getAssetType() {
        return assetType;
    }

    public double getAssetValue() {
        return assetValue;
    }

    public void setAssetValue(double assetValue) {
        this.assetValue = assetValue;
    }

    public int getDepreciationRate() {
        return depreciationRate;
    }
}
