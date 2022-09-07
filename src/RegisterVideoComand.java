import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class RegisterVideoComand extends ICommand {
    private static Scanner scanner = new Scanner(System.in) ;

    @Override
    public boolean executeCommand(List<Customer> customers, List<Video> videos) {
        System.out.println("Enter video title to register: ") ;
        String title = scanner.next() ;

        System.out.println("Enter video type( 1 for VHD, 2 for CD, 3 for DVD ):") ;
        int videoType = scanner.nextInt();

        System.out.println("Enter price code( 1 for Regular, 2 for New Release ):") ;
        int priceCode = scanner.nextInt();

        Date registeredDate = new Date();
        Video video = new Video(title, videoType, priceCode, registeredDate) ;
        videos.add(video) ;

        return false;
    }
}
