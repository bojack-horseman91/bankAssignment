public class Fixed extends Accounts{
    public Fixed(String Name,Double Amount,Bank bank){
        this.setAmount(Amount);
        this.setName(Name);
        this.setLoan(0.0);
        this.setBank(bank);
        this.setInterestRate(0.1f);
        this.setTime(0);
        this.setType("FIXED");
       bank.incInternalFunds(Amount);
    }

    @Override
    public void Deposit(Double Amount) {
        if(Amount<50000){
            System.out.println("Insufficient Amount");
            return;
        }
        this.setAmount(Amount+this.getAmount());
        System.out.println(Amount+"$ deposited; current balance "+getAmount()+"$");
    }

    @Override
    public void withDraw(Double Amount) {
        if(this.getTime()<1){
            System.out.println("Invalid transaction Maturity Period Not Obtained!!; current balance "+this.getAmount()+"$");
            return;
        } else if (Amount>this.getAmount()) {
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
