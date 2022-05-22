public class MD extends Employee {
    private String Designation;
    public MD(Bank bank,String Name){
        super(bank,Name);
        Designation="MD";
    }
    @Override
    public void ApproveLoan() {
        this.bank.ApproveLoan();
    }

    @Override
    public void ChangeInterestRate(String type, float rate) {
        this.ChangeInterestRate(type, rate);
    }

    @Override
    public void seeInternalFunds() {
        this.bank.seeInternalFunds();
    }

    public String getDesignation() {
        return Designation;
    }

    public void setDesignation(String designation) {
        Designation = designation;
    }
}
