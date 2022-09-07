import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VRManager {
    private List<Customer> customers = new ArrayList<Customer>() ;
    private List<Video> videos = new ArrayList<Video>() ;
    private Map<Integer, ICommand> commandMap = new HashMap<Integer, ICommand>();


    public VRManager() {
        makeCommandFactory();
    }

    private void makeCommandFactory() {
        commandMap.put(0, new QuitCommand());
        commandMap.put(1, new ListCustomersCommand());
        commandMap.put(2, new ListVideosCommand());
        commandMap.put(3, new RegisterCustomerCommand());
        commandMap.put(4, new RegisterVideoComand());
        commandMap.put(5, new RentVideoCommand());
        commandMap.put(6, new ReturnVideoCommand());
        commandMap.put(7, new CustomerReportCommand());
        commandMap.put(8, new ClearRentalsCommand());
        commandMap.put(-1, new InitCommand());
    }

    public boolean excuteCommand(int command) throws Exception {
        if(!commandMap.containsKey(command)) {
            throw new Exception("Command 없음: " + command);
        }

        return commandMap.get(command).executeCommand(customers, videos);
    }
}
