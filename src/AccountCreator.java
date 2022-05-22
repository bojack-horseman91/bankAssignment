public class AccountCreator {
    public Accounts makeAccount(String Name,String Type,Double Amount,Bank bank) {
        Accounts account;
        if (Type.equals("FIXED")){
            if (Amount < 100000) {
                System.out.println("Not enough for fixed account");
                return null;
            }
            else
            {return new Fixed(Name, Amount, bank);}
        } else if (Type.equals("STUDENT")) {
            return new Student(Name, Amount, bank);
        } else if (Type.equals("SAVINGS")) {
            return new Savings(Name, Amount, bank);
        }
        else if (Type.equals("LOAN")) {
            return new Loan(Name, Amount, bank);
        }
        else {
            System.out.println("Error!!");
            return null;
        }
        
    }
}
