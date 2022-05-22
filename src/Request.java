import java.util.ArrayList;

public class Request {
    private String command;
    private ArrayList<String>others;

    public Request(String command, ArrayList<String> others) {
        this.command = command;
        this.others = others;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public ArrayList<String> getOthers() {
        return others;
    }

    public void setOthers(ArrayList<String> others) {
        this.others = others;
    }
}
