import java.util.List;
import java.util.Scanner;

public class RentVideoCommand extends ICommand {
    private static Scanner scanner = new Scanner(System.in) ;
    @Override
    public boolean executeCommand(List<Customer> customers, List<Video> videos)
    {
        System.out.println("Enter customer name: ") ;
        String customerName = scanner.next() ;

        Customer foundCustomer = null;
        try {
            foundCustomer = findMyCustomer(customers, customerName);
        }catch (Exception e) {
            System.out.println(e.getMessage()) ;
            return false;
        }

        System.out.println("Enter video title to rent: ") ;
        String videoTitle = scanner.next() ;

        Video foundVideo = null ;
        for ( Video video: videos ) {
            if ( video.getTitle().equals(videoTitle) && video.isRented() == false ) {
                foundVideo = video ;
                break ;
            }
        }

        if ( foundVideo == null ) return false;

        Rental rental = new Rental(foundVideo) ;
        foundVideo.setRented(true);

        List<Rental> customerRentals = foundCustomer.getRentals() ;
        customerRentals.add(rental);
        foundCustomer.setRentals(customerRentals);

        return false;
    }
}
