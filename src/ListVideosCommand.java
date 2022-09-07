import java.util.List;

public class ListVideosCommand extends ICommand {
    @Override
    public boolean executeCommand(List<Customer> customers, List<Video> videos)
    {
        System.out.println("List of videos");

        for ( Video video: videos ) {
            System.out.println("Price code: " + video.getPriceCode() +"\tTitle: " + video.getTitle()) ;
        }
        System.out.println("End of list");

        return false;
    }
}
