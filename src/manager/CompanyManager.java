package manager;

        import company.module.Company;
        import utils.Printer;

        public class CompanyManager {
        private Printer printer = new Printer();

        public void showCompanyInformation(Company company) {
        printer.print("Nazwa firmy: " + company.getCompanyName());
        printer.print("Siedziba firmy: " + company.getHeadquarters());
        printer.print("Adres firmy: " + company.getAddress());
        printer.print("Kapital początkowy firmy: " + company.getStartUpCapital());
        }

        public void changeCompanyName(Company company, String newCompanyName) {
        company.setCompanyName(newCompanyName);
        }

        public void changeCompanyHeadquarter(Company company, String newHeadquarter) {
        company.setHeadquarters(newHeadquarter);
        }

        public void changeCompanyAddress(Company company, String newAddress) {
        company.setAddress(newAddress);
        }

        public void changeStartUpCapital(Company company, int newStartUpCapital) {
        company.setStartUpCapital(newStartUpCapital);
        }
        }
