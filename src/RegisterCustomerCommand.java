import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class RegisterCustomerCommand extends ICommand {
    private static Scanner scanner = new Scanner(System.in) ;

    @Override
    public boolean executeCommand(List<Customer> customers, List<Video> videos) {
        System.out.println("Enter customer name: ") ;
        String name = scanner.next();
        Customer customer = new Customer(name) ;
        customers.add(customer) ;

        return false;
    }
}
