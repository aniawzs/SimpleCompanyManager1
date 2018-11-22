package companyModules;

public class Assets {
    private String assetName;
    private String assetType;
    private int assetValue;
    private double depreciationRate;

    public Assets(String assetName, String assetType, int assetValue, double depreciationRate){
        this.assetName = assetName;
        this.assetType = assetType;
        this.assetValue = assetValue;
        this.depreciationRate = depreciationRate;
    }

    public String getAssetName(){
        return assetName;
    }

    public void setAssetName(String assetName){
        this.assetName = assetName;
    }

    public String getAssetType(){
        return assetType;
    }

    public void setAssetType(String assetType){
        this.assetType = assetType;
    }

    public int getAssetValue(){
        return assetValue;
    }

    public void setAssetValue(int assetValue){
        this.assetValue = assetValue;
    }

    public double getDepreciationRate(){
        return depreciationRate;
    }

    public void setDepreciationRate(int depreciationRate){
        this.depreciationRate = depreciationRate;
    }
}
