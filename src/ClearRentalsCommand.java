import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClearRentalsCommand extends ICommand {
    private static Scanner scanner = new Scanner(System.in);

    @Override
    public boolean executeCommand(List<Customer> customers, List<Video> videos) {
        System.out.println("Enter customer name: ") ;
        String customerName = scanner.next();

        Customer foundCustomer = null;
        try {
            foundCustomer = findMyCustomer(customers, customerName);
        }catch (Exception e) {
            System.out.println(e.getMessage()) ;
            return false;
        }

        System.out.println("Name: " + foundCustomer.getName() +
                "\tRentals: " + foundCustomer.getRentals().size()) ;
        for ( Rental rental: foundCustomer.getRentals() ) {
            System.out.print("\tTitle: " + rental.getVideo().getTitle() + " ") ;
            System.out.print("\tPrice Code: " + rental.getVideo().getPriceCode()) ;
        }

        List<Rental> rentals = new ArrayList<Rental>() ;
        foundCustomer.setRentals(rentals);

        return false;
    }
}
