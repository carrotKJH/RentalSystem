import java.util.List;

public abstract class ICommand {
    Customer findMyCustomer(List<Customer> customers, String customerName) throws Exception {
        Customer foundCustomer = null ;
        for ( Customer customer: customers ) {
            if ( customer.getName().equals(customerName)) {
                foundCustomer = customer ;
                break ;
            }
        }

        if ( foundCustomer == null ) throw new Exception("Not found customer");

        return foundCustomer;
    }


    abstract boolean executeCommand(List<Customer> customers, List<Video> videos);
}
