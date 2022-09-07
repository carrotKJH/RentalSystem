import java.util.List;
import java.util.Scanner;

public class CustomerReportCommand extends ICommand {
    private static Scanner scanner = new Scanner(System.in) ;

    @Override
    public boolean executeCommand(List<Customer> customers, List<Video> videos) {
        System.out.println("Enter customer name: ") ;
        String customerName = scanner.next() ;

        Customer foundCustomer = null;
        try {
            foundCustomer = findMyCustomer(customers, customerName);
        }catch (Exception e) {
            System.out.println(e.getMessage()) ;
            return false;
        }

        String result = foundCustomer.getReport() ;
        System.out.println(result);


        return false;
    }
}
