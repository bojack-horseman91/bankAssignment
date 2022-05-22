public class Savings extends Accounts{
    public Savings(String Name,Double Amount,Bank bank){
        this.setAmount(Amount);
        this.setName(Name);
        this.setLoan(0.0);
        this.setBank(bank);
        this.setTime(0);
        this.setInterestRate(.1f);
        this.setType("SAVINGS");
        bank.incInternalFunds(Amount);
    }

    @Override
    public void Deposit(Double Amount) {
        this.setAmount(Amount+this.getAmount());
        System.out.println(Amount+"$ deposited; current balance "+getAmount()+"$");
    }

    @Override
    public void withDraw(Double Amount) {
        if (Amount>this.getAmount()-1000) {
            System.out.println("Invalid transaction !!; current balance "+this.getAmount()+"$");
            return;
        } else {
            this.setAmount(this.getAmount()-Amount);
            bank.decreaseInternalFunds(Amount);
            System.out.println(Amount+"$ WithDrawn; current balance "+getAmount()+"$");
        }
    }

    @Override
    public void RequestLoan(LoanInfo loanInfo) {
        Double Amount=loanInfo.getAmmount();
        if(Amount>1000){
            System.out.println("Invalid transaction !!; current balance "+this.getAmount()+"$");
            return;
        }
        this.getBank().makeLoanRequests(this,Amount);
        System.out.println("Loan request successful, sent for approval");
    }

    @Override
    public void increaseYear() {
        this.deduct(500.0);
        this.deduct(this.getLoan()*this.getInterestRate());
    }
}
