public class Officer extends Employee {
    private String Designation;

    public Officer(Bank bank,String Name){
        super(bank,Name);
        Designation="Officer";

    }
    @Override
    public void ApproveLoan() {
        this.bank.ApproveLoan();
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
