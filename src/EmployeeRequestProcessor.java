import java.util.ArrayList;

public class EmployeeRequestProcessor implements RequestProcessor {
    private  Employee employee;
    public EmployeeRequestProcessor(Employee employee){
        this.employee=employee;
    }

    @Override
    public void processRequest(Request request) {
        ArrayList<String> others=request.getOthers();
        String command=request.getCommand();
        if(command.equals("LOOKUP")){

            employee.LookUp(others.get(0));
        } else if (command.equals("APPROVE")) {
            employee.ApproveLoan();
        } else if (command.equals("SEE")) {
            employee.seeInternalFunds();
        } else if (command.equals("CHANGE")) {
            employee.ChangeInterestRate(others.get(0), Float.parseFloat(others.get(1)));
        }
         else if (command.equals("CLOSE")) {
            System.out.println("Operations for "+employee.getName()+" closed ");
            return;
        }
        else {
            System.out.println("invaild request");
        }
    }
}
