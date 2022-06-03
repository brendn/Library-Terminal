package co.grandcircus.library.commands;

import java.util.ArrayList;
import java.util.Scanner;

import co.grandcircus.library.Command;
import co.grandcircus.library.blackjack.Card;
import co.grandcircus.library.blackjack.Dealer;
import co.grandcircus.library.blackjack.Methods;
import co.grandcircus.library.blackjack.Player;

public class CommandBlackJack extends Command {

	public CommandBlackJack() {
		super("playgame", "Relax, hop on a computer and play a game!");
	}

	@Override
	public void execute(String input, Scanner scanner) {
		System.out.println("Welcome to the Library's Java BlackJack table!");
		System.out.println("Bets are $25 -- BlackJack pays 3:2");
		System.out.println("Please enter your name: ");
		String userName = scanner.nextLine();
		int userBet = 25;
		boolean userCont = true;
		try {
			Player player1 = new Player(userName, userBet);
			Dealer dealer = new Dealer();
			while (userCont) {
				if (player1.getBank() < 25) {
					System.out.println("You don't have enough money for that!");
					userCont = false;
					break;
				} else {
					System.out.println("Ok, " + userName + ". You started this round with $" + player1.getBank()
							+ " in your bank.");
					player1.setCardCount(0);
					dealer.setCardCount(0);

					ArrayList<Card> firstDeck = new ArrayList<>();
					player1.playerBet();
					Thread.sleep(1500);
					System.out.println("Now you have $" + player1.getBank() + " since you've bet $" + userBet);

					Methods.fillDeck(firstDeck);
					Methods.deal(firstDeck, player1, dealer);
					Methods.play(firstDeck, player1, dealer);
					if (!player1.getBust()) {
						Methods.dealerPlay(firstDeck, player1, dealer);
					} else {
						System.out.println("You lost your bet of $" + player1.getBet());
						System.out.println("You have $" + player1.getBank() + " in your bank.");
					}

					if (Methods.playAgain(player1, dealer)) {
						userCont = true;
					} else {
						userCont = false;
						break;
					}
				}
			}
		} catch (Exception e) {
			System.out.println("Invalid Input. Please try again. Error: Main.tryCatch...");
			userCont = true;
			scanner.next();
		}

		System.out.println("Thanks for playing!");
		System.out.println();
		System.out.println("To see what we have, type 'list'!");
		System.out.println("To search for an item, type 'search <author/director>' or 'search <title>'");
		System.out.println("To preview an item, type 'preview <index> OR preview <title>'");
		System.out.println("For a list of all commands, type 'help'");

	}

}


