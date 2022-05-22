public abstract class Accounts {
    private  String Name;
    private float interestRate;
    private String Type;
    protected Bank bank;
    private Double Amount,Loan;
    private int time;
    public abstract  void Deposit(Double Amount);
    public abstract void withDraw(Double Amount);



    public abstract void RequestLoan(LoanInfo loanInfo);
    public void QueryDeposit(){
        System.out.println("Current Balance "+Amount+"$, loan "+Loan+"$");
    }
    public abstract void increaseYear();
    public void deduct(Double Amount){
        this.bank.incInternalFunds(Amount);
        this.Amount-=Amount;
    }
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setAmount(Double amount) {
        Amount = amount;
    }
    public Double getAmount(){
        return Amount;
    }
    public Double getLoan(){
        return Loan;
    }

    public void setLoan(Double loan) {
        Loan = loan;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public float getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(float interestRate) {
        this.interestRate = interestRate;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }
}
