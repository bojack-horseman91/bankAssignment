public class Loan extends Accounts{
    public Loan(String name, Double amount, Bank bank) {
        this.setLoan(amount);
        this.setName(name);
        this.setBank(bank);
        this.setInterestRate(0.1f);
        this.setTime(0);
        this.setType("LOAN");
        this.setAmount(0.0);
        bank.decreaseInternalFunds(amount);
    }

    @Override
    public void Deposit(Double Amount) {
        this.setLoan(this.getLoan()-Amount);
        System.out.println(Amount+"$ deposited; current loan "+getLoan()+"$");
    }

    @Override
    public void withDraw(Double Amount) {
        System.out.println("You don’t have permission for this operation");
    }


    @Override
    public void RequestLoan(LoanInfo loanInfo) {
        Double Amount=loanInfo.getAmmount();
        this.getBank().makeLoanRequests(this,Amount);
        System.out.println("Loan request successful, sent for approval");
    }

    @Override
    public void increaseYear() {
        this.deduct(this.getLoan()*this.getInterestRate());
    }
}
