package co.grandcircus.library.commands;

import java.util.Scanner;

import co.grandcircus.library.Command;
import co.grandcircus.library.Library;

public class CommandRemoveEmail extends Command {

	public CommandRemoveEmail() {
		super("removeemail", "Unsubscribe from our mailing list. Usage: removeemail <email-address>");
	}

	@Override
	public void execute(String input, Scanner scanner) {
		boolean findEmail = false;
		for (int i = 0; i < Library.emailList.size(); i++) {
			if (input.equalsIgnoreCase(Library.emailList.get(i))) {
				Library.emailList.remove(i);
				print("Sorry to see you go!");
				print("We have successfully removed " + input + " from our mailing list.");
				findEmail = true;
			}
		}
		if (!findEmail) {
			print("Sorry, we couldn't find that email in our database.");
		}
	}

}
