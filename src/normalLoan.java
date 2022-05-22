public class normalLoan implements LoanInfo{
    private Double amount;
    public normalLoan(Double amount){
        this.amount=amount;
    }
    @Override
    public Double getAmmount() {
        return amount;
    }
}
