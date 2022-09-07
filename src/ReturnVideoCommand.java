import java.util.List;
import java.util.Scanner;

public class ReturnVideoCommand extends ICommand {
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

        System.out.println("Enter video title to return: ") ;
        String videoTitle = scanner.next() ;

        List<Rental> customerRentals = foundCustomer.getRentals() ;
        for ( Rental rental: customerRentals ) {
            if ( rental.getVideo().getTitle().equals(videoTitle) && rental.getVideo().isRented() ) {
                rental.returnVideo();
                rental.getVideo().setRented(false);
                break ;
            }
        }

        return false;
    }
}
