public class LoanRequest {
    private Accounts accounts;
    private Double Amount;
    public LoanRequest(Accounts accounts,Double Amount){
        this.Amount=Amount;
        this.accounts=accounts;
    }
    public void Approve(){
        accounts.setLoan(accounts.getLoan()+Amount);
    }
    public void reject(){

    }
    public Double  getAmount(){return Amount;}
    public String getName(){return accounts.getName();}
}
