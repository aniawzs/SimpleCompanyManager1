package companyModules;

public class Company {

    private String companyName;
    private String headquarters;
    private String address;
    private double startUpCapital;
    private Employees[] employees;
    private Assets[] assets;
    private int financialAssets;

    public Company(String companyName, String headquarters, String address, double startUpCapital) {
        this.companyName = companyName;
        this.headquarters = headquarters;
        this.address = address;
        this.startUpCapital = startUpCapital;
        this.employees = new Employees[0];
        this.assets = new Assets[0];
        this.financialAssets = 0;
    }

    public Employees[] getEmployees() {
        return employees;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getHeadquarters() {
        return headquarters;
    }

    public void setHeadquarters(String headquarters) {
        this.headquarters = headquarters;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getStartUpCapital() {
        return startUpCapital;
    }

    public void setStartUpCapital(double startUpCapital) {
        this.startUpCapital = startUpCapital;
    }

    public Assets[] getAssets() {
        return assets;
    }

    public void setAssets(Assets[] assets) {
        this.assets = assets;
    }

    public void setEmployees(Employees[] employees) {
        this.employees = employees;
    }

    public int getFinancialAssets() {
        return financialAssets;
    }

    public void addCash(double cashValue) {
        financialAssets += cashValue;
    }

    public void spendCash(double cashValue) {
        financialAssets -= cashValue;
    }
}
