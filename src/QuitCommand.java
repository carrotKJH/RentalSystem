import java.util.List;

public class QuitCommand extends ICommand {
    @Override
    public boolean executeCommand(List<Customer> customers, List<Video> videos) {
        return false;
    }
}
