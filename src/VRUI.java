import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class VRUI {
	private static Scanner scanner = new Scanner(System.in) ;

	public static void main(String[] args) {
		VRUI ui = new VRUI() ;
		VRManager vrManager = new VRManager();

		boolean quit = false ;
		while ( ! quit ) {
			int command = ui.showCommand() ;
			try {
				quit = vrManager.excuteCommand(command);
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		System.out.println("Bye");
	}

	public int showCommand() {
		System.out.println("\nSelect a command !");
		System.out.println("\t 0. Quit");
		System.out.println("\t 1. List customers");
		System.out.println("\t 2. List videos");
		System.out.println("\t 3. Register customer");
		System.out.println("\t 4. Register video");
		System.out.println("\t 5. Rent video");
		System.out.println("\t 6. Return video");
		System.out.println("\t 7. Show customer report");
		System.out.println("\t 8. Show customer and clear rentals");

		int command = scanner.nextInt() ;

		return command ;

	}
}
