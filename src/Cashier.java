public class Cashier extends Employee {
    private String Designation;
    public Cashier(Bank bank,String Name){
        super(bank,Name);
        Designation="cashier";
    }
    @Override
    public void ApproveLoan() {
        System.out.println("You don’t have permission for this operation");
    }

    @Override
    public void ChangeInterestRate(String type, float rate) {
        System.out.println("You don’t have permission for this operation");
    }

    @Override
    public void seeInternalFunds() {
        System.out.println("You don’t have permission for this operation");
    }

    public String getDesignation() {
        return Designation;
    }

    public void setDesignation(String designation) {
        Designation = designation;
    }
}
