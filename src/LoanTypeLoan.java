public class LoanTypeLoan implements LoanInfo{
    private Accounts account;
    public LoanTypeLoan(Accounts account){
        this.account=account;
    }
    @Override
    public Double getAmmount() {
        return .5*account.getLoan();
    }
}