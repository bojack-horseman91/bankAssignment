import java.io.FileNotFoundException;

public class Simulation {
    public static void main(String[] args) throws FileNotFoundException {
    Bank bank=new Bank();
    RequestHandler requestHandler=new RequestHandler(bank);
    requestHandler.handleRequest("src/test.txt");
    }
}
