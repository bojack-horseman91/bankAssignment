import java.util.ArrayList;

public class AccountRequestProcessor implements  RequestProcessor{
    private Accounts account;
    public AccountRequestProcessor(Accounts account){this.account=account;}
    @Override
    public void processRequest(Request request) {

        ArrayList<String> others=request.getOthers();
        String command=request.getCommand();
        if(command.equals("DEPOSIT"))
            account.Deposit(Double.valueOf(others.get(0)));
        else if (command.equals("QUERY")) {
            account.QueryDeposit();
        } else if (command.equals("WITHDRAW")) {
            account.withDraw(Double.valueOf(others.get(0)));
        }else if (command.equals("REQUEST")) {
            if(account.getType().equals("LOAN"))
                account.RequestLoan(new LoanTypeLoan(account));
            else
                account.RequestLoan(new normalLoan(Double.valueOf(others.get(0))));
        }
        else if (command.equals("CLOSE")) {
            System.out.println("Transaction Closed for "+account.getName());
            return;
        }
        else {
            System.out.println("invaild request");
        }

    }
}
