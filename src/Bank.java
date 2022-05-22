import java.util.*;

public class Bank {
    private Double internalFunds;
    private ArrayList<Employee> employees=new ArrayList<>();
    private  ArrayList<Accounts> accounts=new ArrayList<>();

    private Queue<LoanRequest> loanRequests;

    private void offlineSpecificationInitialization(){
        
        Employee MD=new MD(this,"MD"),s1=new Officer(this,"S1"),
                s2=new Officer(this,"S2"),c1=new Cashier(this,"C1"),
                c2=new Cashier(this,"C2"),c3=new Cashier(this,"C3"),
                c4=new Cashier(this,"C4"),c5=new Cashier(this,"C5");
        employees.add(MD);
        employees.add(s1);
        employees.add(s2);
        employees.add(c1);
        employees.add(c2);
        employees.add(c3);
        employees.add(c4);
        employees.add(c5);
    }
    public Bank(){
        offlineSpecificationInitialization();
        internalFunds= 1000000.0;
        loanRequests=new ArrayDeque<>();


    }
    public void makeLoanRequests(Accounts accounts,Double Amount){
        loanRequests.add(new LoanRequest(accounts, Amount));
    }
    public void ApproveLoan(){
        LoanRequest loanRequest=loanRequests.remove();
        loanRequest.Approve();
        decreaseInternalFunds(loanRequest.getAmount());
        System.out.println("Loan for "+loanRequest.getName()+" approved");
    }
    public void LookUp(String Name){
        for (Accounts accounts1:accounts){
            if(accounts1.getName().equals(Name))
                System.out.println(accounts1.getName()+"’s current balance "+accounts1.getAmount()+"$");
        }
    }
    public void ChangeInterestRate(String Type,float rate){
        for (Accounts accounts1:accounts){
            if(accounts1.getType().equals(Type))
                accounts1.setInterestRate(rate);
        }
    }
    public void seeInternalFunds(){
        System.out.println("Internal Funds are"+this.internalFunds+"$");
    }

    public void incInternalFunds(Double internalFunds) {
        this.internalFunds += internalFunds;
    }
    public void OneYearPass(){
        for(Accounts accounts1:accounts){
            accounts1.increaseYear();
        }
    }
    public void decreaseInternalFunds(Double internalFunds) {
        this.internalFunds -= internalFunds;
    }
    public void addAccount(Accounts account){
        accounts.add(account);
    }
    public boolean areLoans(){return !loanRequests.isEmpty();}
    public Employee isEmployee(String Name){
        for (Employee employee:employees){
            if(employee.getName().equals(Name))
                return employee;
        }
        return null;
    }
    public Accounts isAccount(String Name){
        for (Accounts accounts1:accounts){
            if(accounts1.getName().equals(Name))
                return accounts1;
        }
        return null;
    }

//    public Response giveResponse(Request request){
//        return null;
//    }

}
