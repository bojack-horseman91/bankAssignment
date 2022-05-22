import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;



public class RequestHandler {
    private String[] employeeRequest=new String[]{"LOOKUP","APPROVE","SEE","CHANGE"};
    private String[] accountRequest=new String[]{"DEPOSIT","QUERY","WITHDRAW","REQUEST"};
    private    RequestProcessor requestProcessor;
    private  Bank bank;
    public RequestHandler(Bank bank){
        this.bank=bank;
    }
   public   Request makeRequestBody(StringTokenizer stringTokenizer){
       String command=stringTokenizer.nextToken().toUpperCase();
       ArrayList<String> others=new ArrayList<>();
       while (stringTokenizer.hasMoreTokens()) {
           others.add(stringTokenizer.nextToken().replace(",",""));
       }
       return new Request(command,others);
   }

    public  void handleRequest(String path) throws FileNotFoundException {
        File file = new File(path);



        Scanner sc = new Scanner(System.in);
//        Scanner sc = new Scanner(file);


        while (sc.hasNextLine()) {
            StringTokenizer stringTokenizer=new StringTokenizer(sc.nextLine()," ");
//            if (sc.nextLine().toUpperCase().equals("CLOSE")) {
//
//                stringTokenizer=new StringTokenizer("CLOSE ");
//            }
//            else if (sc.nextLine().equals("INC")) {
//
//                stringTokenizer=new StringTokenizer("INC ");
//            }


            Request request=makeRequestBody(stringTokenizer);
            String command=request.getCommand();
            ArrayList<String>others=request.getOthers();
            if(command.equals("CREATE")){
                Accounts account=new AccountCreator().makeAccount(others.get(0),others.get(1).toUpperCase(),Double.parseDouble(others.get(2)),bank);
                if(account!=null) {
                    bank.addAccount(account);
                    System.out.println(account.getType() + " account for Alice Created; initial balance " + account.getAmount() + "$");
                    requestProcessor = new AccountRequestProcessor(bank.isAccount(others.get(0)));
                }
                else{
                    System.out.println("Invalid Trascation");
                }

            } else if (command.equals("INC")) {
                bank.OneYearPass();
                System.out.println("1 year passed");
            } else if (command.equals("OPEN")) {
                Employee employee= bank.isEmployee(others.get(0));
                Accounts account=bank.isAccount(others.get(0));
                if(employee!=null) {
                    requestProcessor = new EmployeeRequestProcessor(employee);
                    System.out.print(employee.getName()+" active");
                    if(bank.areLoans())
                        System.out.println(", there are loan approvals pending");
                    else
                        System.out.println();
                }
                else if (account!=null){

                    requestProcessor = new AccountRequestProcessor(account);
                    System.out.println("Welcome back, "+account.getName());
                }else{
                    System.out.println("Write Proper name");
                }
            }
            else if (requestProcessor!=null) {
                requestProcessor.processRequest(request);
            }
            else {
                System.out.println("Error!!");
            }
        }
    }





}
