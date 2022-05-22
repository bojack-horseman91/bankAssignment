import java.util.ArrayList;

public abstract class Employee {
    protected Bank bank;
    private String Name;
    public Employee(Bank bank,String Name){
        this.bank=bank;
        this.Name=Name;
    }
    public void LookUp(String Name){
        bank.LookUp(Name);
    }
    public abstract void ApproveLoan();
    public abstract void ChangeInterestRate(String type,float rate);
    public abstract void seeInternalFunds();

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
