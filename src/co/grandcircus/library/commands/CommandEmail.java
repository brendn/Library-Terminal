package co.grandcircus.library.commands;

import java.util.Scanner;

import co.grandcircus.library.Command;
import co.grandcircus.library.Library;

public class CommandEmail extends Command {

	public CommandEmail() {
		super("addemail", "Add your email address to join our mailing list! Usage: addemail <email-address>");
		
	}

	@Override
	public void execute(String input, Scanner scanner) {
		//this String is the regex validation that we will test user email addresses with
		String emailRegex = "[A-z0-9]{5,30}@[A-z0-9]{3,10}\\.[A-z0-9]{2,3}";
		if (input.matches(emailRegex)) {
			System.out.println("Successfully added to our mailing list!");
			Library.emailList.add(input);
			
				System.out.println(input);
			
			System.out.println();
		} else {
			System.out.println("Sorry, that was not a valid entry.\n");
			
		}
	
		
	}

}
