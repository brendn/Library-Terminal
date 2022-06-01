package co.grandcircus.library.blackjack;

import java.util.ArrayList;
import java.util.Scanner;

public class Methods {
	public static ArrayList<Card> fillDeck(ArrayList<Card> fullDeck) {
		// create Heart Cards
		Card aceHeart = new Card(Rank.Ace, Suit.Heart);
		Card kingHeart = new Card(Rank.King, Suit.Heart);
		Card queenHeart = new Card(Rank.Queen, Suit.Heart);
		Card jackHeart = new Card(Rank.Jack, Suit.Heart);
		Card tenHeart = new Card(Rank.Ten, Suit.Heart);
		Card nineHeart = new Card(Rank.Nine, Suit.Heart);
		Card eightHeart = new Card(Rank.Eight, Suit.Heart);
		Card sevenHeart = new Card(Rank.Seven, Suit.Heart);
		Card sixHeart = new Card(Rank.Six, Suit.Heart);
		Card fiveHeart = new Card(Rank.Five, Suit.Heart);
		Card fourHeart = new Card(Rank.Four, Suit.Heart);
		Card threeHeart = new Card(Rank.Three, Suit.Heart);
		Card twoHeart = new Card(Rank.Two, Suit.Heart);

		// create Spade Cards
		Card aceSpade = new Card(Rank.Ace, Suit.Spade);
		Card kingSpade = new Card(Rank.King, Suit.Spade);
		Card queenSpade = new Card(Rank.Queen, Suit.Spade);
		Card jackSpade = new Card(Rank.Jack, Suit.Spade);
		Card tenSpade = new Card(Rank.Ten, Suit.Spade);
		Card nineSpade = new Card(Rank.Nine, Suit.Spade);
		Card eightSpade = new Card(Rank.Eight, Suit.Spade);
		Card sevenSpade = new Card(Rank.Seven, Suit.Spade);
		Card sixSpade = new Card(Rank.Six, Suit.Spade);
		Card fiveSpade = new Card(Rank.Five, Suit.Spade);
		Card fourSpade = new Card(Rank.Four, Suit.Spade);
		Card threeSpade = new Card(Rank.Three, Suit.Spade);
		Card twoSpade = new Card(Rank.Two, Suit.Spade);

		// create Diamond Cards
		Card aceDiamond = new Card(Rank.Ace, Suit.Diamond);
		Card kingDiamond = new Card(Rank.King, Suit.Diamond);
		Card queenDiamond = new Card(Rank.Queen, Suit.Diamond);
		Card jackDiamond = new Card(Rank.Jack, Suit.Diamond);
		Card tenDiamond = new Card(Rank.Ten, Suit.Diamond);
		Card nineDiamond = new Card(Rank.Nine, Suit.Diamond);
		Card eightDiamond = new Card(Rank.Eight, Suit.Diamond);
		Card sevenDiamond = new Card(Rank.Seven, Suit.Diamond);
		Card sixDiamond = new Card(Rank.Six, Suit.Diamond);
		Card fiveDiamond = new Card(Rank.Five, Suit.Diamond);
		Card fourDiamond = new Card(Rank.Four, Suit.Diamond);
		Card threeDiamond = new Card(Rank.Three, Suit.Diamond);
		Card twoDiamond = new Card(Rank.Two, Suit.Diamond);

		// create Club Cards
		Card aceClub = new Card(Rank.Ace, Suit.Club);
		Card kingClub = new Card(Rank.King, Suit.Club);
		Card queenClub = new Card(Rank.Queen, Suit.Club);
		Card jackClub = new Card(Rank.Jack, Suit.Club);
		Card tenClub = new Card(Rank.Ten, Suit.Club);
		Card nineClub = new Card(Rank.Nine, Suit.Club);
		Card eightClub = new Card(Rank.Eight, Suit.Club);
		Card sevenClub = new Card(Rank.Seven, Suit.Club);
		Card sixClub = new Card(Rank.Six, Suit.Club);
		Card fiveClub = new Card(Rank.Five, Suit.Club);
		Card fourClub = new Card(Rank.Four, Suit.Club);
		Card threeClub = new Card(Rank.Three, Suit.Club);
		Card twoClub = new Card(Rank.Two, Suit.Club);

		// add all Cards to deck
		fullDeck.add(aceHeart);
		fullDeck.add(kingHeart);
		fullDeck.add(queenHeart);
		fullDeck.add(jackHeart);
		fullDeck.add(tenHeart);
		fullDeck.add(nineHeart);
		fullDeck.add(eightHeart);
		fullDeck.add(sevenHeart);
		fullDeck.add(sixHeart);
		fullDeck.add(fiveHeart);
		fullDeck.add(fourHeart);
		fullDeck.add(threeHeart);
		fullDeck.add(twoHeart);

		fullDeck.add(aceSpade);
		fullDeck.add(kingSpade);
		fullDeck.add(queenSpade);
		fullDeck.add(jackSpade);
		fullDeck.add(tenSpade);
		fullDeck.add(nineSpade);
		fullDeck.add(eightSpade);
		fullDeck.add(sevenSpade);
		fullDeck.add(sixSpade);
		fullDeck.add(fiveSpade);
		fullDeck.add(fourSpade);
		fullDeck.add(threeSpade);
		fullDeck.add(twoSpade);

		fullDeck.add(aceDiamond);
		fullDeck.add(kingDiamond);
		fullDeck.add(queenDiamond);
		fullDeck.add(jackDiamond);
		fullDeck.add(tenDiamond);
		fullDeck.add(nineDiamond);
		fullDeck.add(eightDiamond);
		fullDeck.add(sevenDiamond);
		fullDeck.add(sixDiamond);
		fullDeck.add(fiveDiamond);
		fullDeck.add(fourDiamond);
		fullDeck.add(threeDiamond);
		fullDeck.add(twoDiamond);

		fullDeck.add(aceClub);
		fullDeck.add(kingClub);
		fullDeck.add(queenClub);
		fullDeck.add(jackClub);
		fullDeck.add(tenClub);
		fullDeck.add(nineClub);
		fullDeck.add(eightClub);
		fullDeck.add(sevenClub);
		fullDeck.add(sixClub);
		fullDeck.add(fiveClub);
		fullDeck.add(fourClub);
		fullDeck.add(threeClub);
		fullDeck.add(twoClub);
		return fullDeck;
	}

	public static ArrayList<Card> deal(ArrayList<Card> fullDeck, Player player1, Dealer dealer)
			throws InterruptedException {

		// makes sure random number doesn't pick two of the same card below
		boolean cardsMatch = true;

		// remove all counters and reset all booleans on player and dealer
		player1.resetCards();
		dealer.resetCards();

		// picking a random element from fullDeck
		int max = fullDeck.size() - 1;
		int min = 0;

		// generate random numbers and assign them to Card objects
		// if two of the same cards are chosen, the below will repeat
		while (cardsMatch == true) {
			int playerCardNumber = (int) Math.floor(Math.random() * (max - min + 1) + min);
			int playerCardNumber2 = (int) Math.floor(Math.random() * (max - min + 1) + min);
			int dealerCardNumber = (int) Math.floor(Math.random() * (max - min + 1) + min);
			int dealerCardNumber2 = (int) Math.floor(Math.random() * (max - min + 1) + min);
			if (playerCardNumber == playerCardNumber2 || playerCardNumber == dealerCardNumber
					|| playerCardNumber == dealerCardNumber2 || playerCardNumber2 == dealerCardNumber
					|| playerCardNumber2 == dealerCardNumber2 || dealerCardNumber == dealerCardNumber2) {
				cardsMatch = true;

				// if two of the same cards are not chosen, play continues below in the else
				// statement
			} else {
				cardsMatch = false;

				// assigning the Player's Card Rank and Suit to the random numbers above
				Card playerCard = fullDeck.get(playerCardNumber);
				Card playerCard2 = fullDeck.get(playerCardNumber2);

				// assigning Card Rank and Suit to the Player object's 'hand'
				player1.setCard1(playerCard);
				player1.setCard2(playerCard2);

				// check to see if two aces were drawn, if they were, set one of them to a value
				// of 1
				if (playerCard.getRank() == Rank.Ace && playerCard2.getRank() == Rank.Ace) {
					Methods.setAceTo1(playerCard2);
					player1.setAceCount(player1.getAceCount() + 1);
				} else if (playerCard.getRank() == Rank.Ace || playerCard2.getRank() == Rank.Ace) {
					player1.setAceCount(player1.getAceCount() + 1);
				}

				// set the Player's card count value to the first two cards drawn
				player1.setCardCount(player1.getCard1().getValue() + player1.getCard2().getValue());

				// assigning the Dealer's Card Rank and Suit to the random numbers above
				Card dealerCard = fullDeck.get(dealerCardNumber);
				Card dealerCard2 = fullDeck.get(dealerCardNumber2);

				// assigning the Dealer's Card Rank and Suit to the Dealer object's 'hand'
				dealer.setCard1(dealerCard);
				dealer.setCard2(dealerCard2);

				// check to see if two aces were drawn, if they were, set one of them to a value
				// of 1
				if (dealerCard.getRank() == Rank.Ace && dealerCard2.getRank() == Rank.Ace) {
					Methods.setAceTo1(dealerCard2);
					dealer.setAceCount(dealer.getAceCount() + 1);
				} else if (dealerCard.getRank() == Rank.Ace || dealerCard2.getRank() == Rank.Ace) {
					dealer.setAceCount(dealer.getAceCount() + 1);
				}

				// setting the dealer's card count to the first two cards drawn
				dealer.setCardCount(dealer.getCard1().getValue() + dealer.getCard2().getValue());

				// this allows the program to display the initial values of the cards that are
				// shown
				int playerCardNumberValue = player1.getCard1().getValue();
				int playerCardNumber2Value = player1.getCard2().getValue();
				int dealerCardNumberValue = dealer.getCard1().getValue();

				// actually printing out the cards and values of the dealer and player
				Thread.sleep(1500);
				System.out.println("Your first two cards are: ");
				Thread.sleep(1500);
				System.out.println(playerCard.toString() + " and " + playerCard2.toString() + " ("
						+ (playerCardNumberValue + playerCardNumber2Value) + ")" + "\n");
				Thread.sleep(1500);
				System.out.println("The dealer's first card is: ");
				Thread.sleep(1500);
				System.out.println(dealerCard.toString() + " (" + (dealerCardNumberValue) + ")\n");

				// if the player is dealt a blackjack, set BlackJack to
				// true
				if ((player1.getCard1().getRank() == Rank.Ace && player1.getCard2().getValue() == 10)) {
					player1.setBlackJack(true);
					Thread.sleep(1500);
					System.out.println("You got a BlackJack!");
				} else if ((player1.getCard1().getValue() == 10 && player1.getCard2().getRank() == Rank.Ace)) {
					Thread.sleep(1500);
					System.out.println("You got a BlackJack!");
					player1.setBlackJack(true);
				}
			}
		}

		// return amended deck
		return fullDeck;
	}

	public static ArrayList<Card> play(ArrayList<Card> deck, Player player1, Dealer dealer)
			throws InterruptedException {
		// && dealer.getBlackJack() == false)
		if (player1.getBlackJack() == false) {
			// keeps the Stand or Hit loop going until the player chooses Stand
			boolean userCont = true;
			Scanner scnr = new Scanner(System.in);

			while (userCont == true) {
				Thread.sleep(1500);
				System.out.println("What would you like to do?");
				System.out.println("1. Stand");
				System.out.println("2. Hit");
				System.out.println("3. Double Down");
				try {
					int userChoice = scnr.nextInt();

					// when player chooses to Stand
					if (userChoice == 1) {
						System.out.println("You Stand.");
						// Seeing how many cards the Player has in their hand
						// Will print out each card and the total value of all cards
						// Starts at the last possible card (6) and checks to see if it's null
						if (player1.getCard6() != null) {
							Thread.sleep(1500);
							System.out.println("You have " + player1.getCard1() + " and " + player1.getCard2());
							System.out.println(player1.getCard3() + " and " + player1.getCard4());
							System.out.println(player1.getCard5() + " and " + player1.getCard6() + " ("
									+ (player1.returnValue6()) + ")");
							player1.setCardCount(player1.returnValue6());
						} else if (player1.getCard5() != null) {
							Thread.sleep(1500);
							System.out.println("You have " + player1.getCard1() + " and " + player1.getCard2());
							System.out.println(player1.getCard3() + " and " + player1.getCard4());
							System.out.println(player1.getCard5() + " (" + (player1.returnValue5()) + ")");
							player1.setCardCount(player1.returnValue5());
						} else if (player1.getCard4() != null) {
							Thread.sleep(1500);
							System.out.println("You have " + player1.getCard1() + " and " + player1.getCard2());
							System.out.println(player1.getCard3() + " and " + player1.getCard4() + " ("
									+ (player1.returnValue4() + ")"));
							player1.setCardCount(player1.returnValue4());
						} else if (player1.getCard3() != null) {
							Thread.sleep(1500);
							System.out.println("You have " + player1.getCard1() + " and " + player1.getCard2());
							System.out.println(player1.getCard3() + " (" + (player1.returnValue3() + ")"));
							player1.setCardCount(player1.returnValue3());
						} else if (player1.getCard2() != null) {
							Thread.sleep(1500);
							System.out.println("You have " + player1.getCard1() + " and " + player1.getCard2() + " ("
									+ (player1.returnValue2() + ")"));
							player1.setCardCount(player1.returnValue2());
						}
						// breaks out of the Stand/Hit loop
						userCont = false;

						// if Player wants another card
					} else if (userChoice == 2) {
						player1.setFirstRound(false); // removes the ability to double down
						// picking a random element from deck
						int max = deck.size() - 1;
						int min = 0;

						// generate random numbers and assign them to Card objects
						int playerCardNumber = (int) Math.floor(Math.random() * (max - min + 1) + min);
						Card playerCard = deck.get(playerCardNumber);

						// setting the Ace to 1 if there is already 1 ace in their hand, or if the ace
						// would put them over 21
						if ((playerCard.getRank() == Rank.Ace && player1.getAceCount() > 1)
								|| playerCard.getRank() == Rank.Ace
										&& (playerCard.getValue() + player1.getCardCount()) > 21) {
							setAceTo1(playerCard);
						} else if (player1.getCardCount() > 21 && playerCard.getRank() == Rank.Ace) {
							setAceTo1(playerCard);
						} else if ((player1.getCard1().getRank() == Rank.Ace)
								&& (player1.getCardCount() + playerCard.getValue() > 21)) {
							setAceTo1(player1.getCard1());
						} else if ((player1.getCard2().getRank() == Rank.Ace)
								&& (player1.getCardCount() + playerCard.getValue() > 21)) {
							setAceTo1(player1.getCard2());
						}

						// assigns the new card to the first open Card field in Player Class
						if (player1.getCard5() != null) {
							player1.setCard6(playerCard);
						} else if (player1.getCard4() != null) {
							player1.setCard5(playerCard);
						} else if (player1.getCard3() != null) {
							player1.setCard4(playerCard);
						} else if (player1.getCard2() != null) {
							player1.setCard3(playerCard);
						}
						System.out.println("Hit me!");
						// printing out card for player
						Thread.sleep(1500);
						System.out.println("Your next card is: ");

						// userCardValueTotal will be used to determine if the Player's cards
						// reach over 21
						int userCardValueTotal = 0;
						// display all Cards that aren't null and their sum
						if (player1.getCard6() != null) {
							Thread.sleep(1500);
							System.out.println(playerCard.toString() + " ("
									+ (player1.getCard1().getValue() + player1.getCard2().getValue()
											+ player1.getCard3().getValue() + player1.getCard4().getValue()
											+ player1.getCard5().getValue() + player1.getCard6().getValue() + ")"
											+ "\n"));
							Thread.sleep(1500);
							System.out.println("The dealer is showing a " + dealer.getCard1() + " ("
									+ dealer.getCard1().getValue() + ")");
							// assign the printed value to userCardValueTotal
							userCardValueTotal = userCardValueTotal
									+ (player1.getCard1().getValue() + player1.getCard2().getValue()
											+ player1.getCard3().getValue() + player1.getCard4().getValue()
											+ player1.getCard5().getValue() + player1.getCard6().getValue());

							// if userCardValueTotal goes higher than 21 the player loses their bet
							if (userCardValueTotal > 21) {
								Thread.sleep(1500);
								System.out.println("Bust!");
								player1.setBust(true);
								userCont = false;
								break;
							}
						} else if (player1.getCard5() != null) {
							Thread.sleep(1500);
							System.out.println(playerCard.toString() + " ("
									+ (player1.getCard1().getValue() + player1.getCard2().getValue()
											+ player1.getCard3().getValue() + player1.getCard4().getValue()
											+ player1.getCard5().getValue() + ")" + "\n"));
							Thread.sleep(1500);
							System.out.println("The dealer is showing a " + dealer.getCard1() + " ("
									+ dealer.getCard1().getValue() + ")");
							// assign the printed value to userCardValueTotal
							userCardValueTotal = userCardValueTotal + (player1.getCard1().getValue()
									+ player1.getCard2().getValue() + player1.getCard3().getValue()
									+ player1.getCard4().getValue() + player1.getCard5().getValue());
							// if userCardValueTotal goes higher than 21, the player loses their bet
							if (userCardValueTotal > 21) {
								Thread.sleep(1500);
								System.out.println("Bust!");
								player1.setBust(true);
								userCont = false;
								break;
							}
						} else if (player1.getCard4() != null) {
							Thread.sleep(1500);
							System.out.println(playerCard.toString() + " ("
									+ (player1.getCard1().getValue() + player1.getCard2().getValue()
											+ player1.getCard3().getValue() + player1.getCard4().getValue() + ")"
											+ "\n"));
							Thread.sleep(1500);
							System.out.println("The dealer is showing a " + dealer.getCard1() + " ("
									+ dealer.getCard1().getValue() + ")");
							// assign the printed value to userCardValueTotal
							userCardValueTotal = userCardValueTotal
									+ (player1.getCard1().getValue() + player1.getCard2().getValue()
											+ player1.getCard3().getValue() + player1.getCard4().getValue());
							// if userCardValueTotal goes higher than 21, the player loses their bet
							if (userCardValueTotal > 21) {
								Thread.sleep(1500);
								System.out.println("Bust!");
								player1.setBust(true);
								userCont = false;
								break;
							}
						} else if (player1.getCard3() != null) {
							Thread.sleep(1500);
							System.out.println(playerCard.toString() + " (" + (player1.getCard1().getValue()
									+ player1.getCard2().getValue() + player1.getCard3().getValue() + ")" + "\n"));
							Thread.sleep(1500);
							System.out.println("The dealer is showing a " + dealer.getCard1() + " ("
									+ dealer.getCard1().getValue() + ")");
							// assign the printed value to userCardValueTotal
							userCardValueTotal = userCardValueTotal + (player1.getCard1().getValue()
									+ player1.getCard2().getValue() + player1.getCard3().getValue());
							// if userCardValueTotal goes higher than 21, the player loses their bet
							if (userCardValueTotal > 21) {
								Thread.sleep(1500);
								System.out.println("Bust!");
								player1.setBust(true);
								userCont = false;
								break;
							}
						}

						// continues to ask the Player if they want to Stand or Hit
						userCont = true;

						// if the Player wants to Double Down
					} else if ((userChoice == 3 && player1.isFirstRound() == true)
							&& ((player1.getBet()) <= player1.getBank())) {
						player1.setPlayerDoubledDown(true); // used to track double bet
						player1.setFirstRound(false); // removes the ability to double down
						player1.setBet(player1.getBet() * 2); // double the bet
						player1.setBank(player1.getBank() - (player1.getBet() / 2)); // remove the doubled bet from the
																						// Player's bank
						// picking a random element from deck
						int max = deck.size() - 1;
						int min = 0;

						// generate random numbers and assign them to Card objects
						int playerCardNumber = (int) Math.floor(Math.random() * (max - min + 1) + min);
						Card playerCard = deck.get(playerCardNumber);

						// setting the Ace to 1 if there is already 1 ace in their hand, or if the ace
						// would put them over 21
						if ((playerCard.getRank() == Rank.Ace && player1.getAceCount() > 1)
								|| playerCard.getRank() == Rank.Ace
										&& (playerCard.getValue() + player1.getCardCount()) > 21) {
							setAceTo1(playerCard);
						} else if (player1.getCardCount() > 21 && playerCard.getRank() == Rank.Ace) {
							setAceTo1(playerCard);
						} else if ((player1.getCard1().getRank() == Rank.Ace)
								&& (player1.getCardCount() + playerCard.getValue() > 21)) {
							setAceTo1(player1.getCard1());
						} else if ((player1.getCard2().getRank() == Rank.Ace)
								&& (player1.getCardCount() + playerCard.getValue() > 21)) {
							setAceTo1(player1.getCard2());
						}

						// assigns the new card to the first open Card field in Player Class
						if (player1.getCard2() != null) {
							player1.setCard3(playerCard);
						}
						System.out.println("Double Down!");
						// printing out card for player
						Thread.sleep(1500);
						System.out.println("Your final card is: ");

						// userCardValueTotal will be used to determine if the Player's cards
						// reach over 21
						int userCardValueTotal = 0;
						// display all Cards that aren't null and their sum
						 if (player1.getCard3() != null) {
							Thread.sleep(1500);
							System.out.println(playerCard.toString() + " (" + (player1.getCard1().getValue()
									+ player1.getCard2().getValue() + player1.getCard3().getValue() + ")" + "\n"));
							Thread.sleep(1500);
							System.out.println("The dealer is showing a " + dealer.getCard1() + " ("
									+ dealer.getCard1().getValue() + ")");
							// assign the printed value to userCardValueTotal
							userCardValueTotal = userCardValueTotal + (player1.getCard1().getValue()
									+ player1.getCard2().getValue() + player1.getCard3().getValue());
							// if userCardValueTotal goes higher than 21, the player loses their bet
							if (userCardValueTotal > 21) {
								Thread.sleep(1500);
								System.out.println("Bust!");
								player1.setBust(true);
								userCont = false;
								break;
							}
						}

						// no more cards after double down
						userCont = false;
					} else {
						System.out.println("Invalid Entry. Try again");
						System.out.println("Can't double down after first hand");
						System.out.println("Make sure you have enough in your bank to cover the double bet!");
						userCont = true;
					}
				} catch (Exception e) {
					System.out.println("Choice was not a valid number. Try again");
					scnr.next();
					userCont = true;
				}
			} // while loop userCont. needs to be false to exit

		} // if statement that skips all of this if player has a blackjack
		return deck;
	}

	public static void dealerPlay(ArrayList<Card> deck, Player player1, Dealer dealer) throws InterruptedException {

		Thread.sleep(1500);
		System.out.println("The dealer's first card was a " + dealer.getCard1());
		Thread.sleep(1500);
		System.out.println("The dealer's second card is a " + dealer.getCard2());
		Thread.sleep(1500);
		System.out.println("For a total of (" + (dealer.getCard1().getValue() + dealer.getCard2().getValue()) + ")");

		if (player1.getBlackJack() == false && dealer.getBlackJack() == false) {
			do {
				if (dealer.getCardCount() <= 16) {
					Thread.sleep(1500);
					System.out.println("The Dealer's next card is: ");
					// dealer draws another card

					// picking a random element from deck
					int max = deck.size() - 1;
					int min = 0;

					// generate random numbers and assign them to Card objects
					int dealerCardNumber = (int) Math.floor(Math.random() * (max - min + 1) + min);
					Card dealerCard = deck.get(dealerCardNumber);

					if ((dealerCard.getRank() == Rank.Ace && dealer.getAceCount() > 1)
							|| dealerCard.getRank() == Rank.Ace
									&& (dealerCard.getValue() + dealer.getCardCount()) > 21) {
						setAceTo1(dealerCard);
					} else if (dealer.getCardCount() > 21 && dealerCard.getRank() == Rank.Ace) {
						setAceTo1(dealerCard);
					} else if ((dealer.getCard1().getRank() == Rank.Ace)
							&& (dealer.getCardCount() + dealerCard.getValue() > 21)) {
						setAceTo1(dealer.getCard1());
					} else if ((dealer.getCard2().getRank() == Rank.Ace)
							&& (dealer.getCardCount() + dealerCard.getValue() > 21)) {
						setAceTo1(dealer.getCard2());
					}

					// assigns the new card to the first open Card field in Dealer Class
					if (dealer.getCard5() != null) {
						dealer.setCard6(dealerCard);
					} else if (dealer.getCard4() != null) {
						dealer.setCard5(dealerCard);
					} else if (dealer.getCard3() != null) {
						dealer.setCard4(dealerCard);
					} else if (dealer.getCard2() != null) {
						dealer.setCard3(dealerCard);
					}

					// dealerCardValueTotal will be used to determine if the Dealer's cards
					// reach over 21
					// while (dealer.dealerBust = false) {
					int dealerCardValueTotal = 0;
					// display all Cards that aren't null and their sum
					if (dealer.getCard6() != null) {
						System.out.println(dealerCard.toString() + " ("
								+ (dealer.getCard1().getValue() + dealer.getCard2().getValue()
										+ dealer.getCard3().getValue() + dealer.getCard4().getValue()
										+ dealer.getCard5().getValue() + dealer.getCard6().getValue() + ")" + "\n"));
						// assign the printed value to userCardValueTotal
						dealerCardValueTotal = dealerCardValueTotal
								+ (dealer.getCard1().getValue() + dealer.getCard2().getValue()
										+ dealer.getCard3().getValue() + dealer.getCard4().getValue()
										+ dealer.getCard5().getValue() + dealer.getCard6().getValue());
						// keeping track of Dealer's card count
						dealer.setCardCount(dealerCardValueTotal);
						// if userCardValueTotal goes higher than 21, the player loses their bet
						if (dealerCardValueTotal > 21) {
							Thread.sleep(1500);
							System.out.println("Dealer Busts!");
							if (player1.didPlayerDoubledDown() == true) {
								System.out.println("You win $" + (player1.getBet() * 2));
								player1.setBank(player1.getBank() + (2 * player1.getBet()));
							} else {
								System.out.println("You win $" + (player1.getBet() * 2));
								player1.setBank(player1.getBank() + (player1.getBet() * 2));
								dealer.setBust(true);
							}
						}
					} else if (dealer.getCard5() != null) {
						System.out.println(dealerCard.toString() + " ("
								+ (dealer.getCard1().getValue() + dealer.getCard2().getValue()
										+ dealer.getCard3().getValue() + dealer.getCard4().getValue()
										+ dealer.getCard5().getValue() + ")" + "\n"));
						// assign the printed value to userCardValueTotal
						dealerCardValueTotal = dealerCardValueTotal + (dealer.getCard1().getValue()
								+ dealer.getCard2().getValue() + dealer.getCard3().getValue()
								+ dealer.getCard4().getValue() + dealer.getCard5().getValue());
						// keeping track of Dealer's card count
						dealer.setCardCount(dealerCardValueTotal);
						// if userCardValueTotal goes higher than 21, the player loses their bet
						if (dealerCardValueTotal > 21) {
							Thread.sleep(1500);
							System.out.println("Dealer Busts!");
							if (player1.didPlayerDoubledDown() == true) {
								System.out.println("You win $" + (player1.getBet() * 2));
								player1.setBank(player1.getBank() + (2 * player1.getBet()));
							} else {
								System.out.println("You win $" + (player1.getBet() * 2));
								player1.setBank(player1.getBank() + (player1.getBet() * 2));
								dealer.setBust(true);
							}
						}
					} else if (dealer.getCard4() != null) {
						System.out.println(dealerCard.toString() + " ("
								+ (dealer.getCard1().getValue() + dealer.getCard2().getValue()
										+ dealer.getCard3().getValue() + dealer.getCard4().getValue() + ")" + "\n"));
						// assign the printed value to userCardValueTotal
						dealerCardValueTotal = dealerCardValueTotal
								+ (dealer.getCard1().getValue() + dealer.getCard2().getValue()
										+ dealer.getCard3().getValue() + dealer.getCard4().getValue());

						// keeping track of Dealer's card count
						dealer.setCardCount(dealerCardValueTotal);
						// if userCardValueTotal goes higher than 21, the player loses their bet
						if (dealerCardValueTotal > 21) {
							Thread.sleep(1500);
							System.out.println("Dealer Busts!");
							if (player1.didPlayerDoubledDown() == true) {
								System.out.println("You win $" + (player1.getBet() * 2));
								player1.setBank(player1.getBank() + (2 * player1.getBet()));
							} else {
								System.out.println("You win $" + (player1.getBet() * 2));
								player1.setBank(player1.getBank() + (player1.getBet() * 2));
								dealer.setBust(true);
							}
						}
					} else if (dealer.getCard3() != null) {
						System.out.println(dealerCard.toString() + " (" + (dealer.getCard1().getValue()
								+ dealer.getCard2().getValue() + dealer.getCard3().getValue() + ")" + "\n"));
						// assign the printed value to userCardValueTotal
						dealerCardValueTotal = dealerCardValueTotal + (dealer.getCard1().getValue()
								+ dealer.getCard2().getValue() + dealer.getCard3().getValue());

						// keeping track of Dealer's card count
						dealer.setCardCount(dealerCardValueTotal);
						// if userCardValueTotal goes higher than 21, the player loses their bet
						if (dealerCardValueTotal > 21) {
							Thread.sleep(1500);
							System.out.println("Dealer Busts!");
							if (player1.didPlayerDoubledDown() == true) {
								System.out.println("You win $" + (player1.getBet() * 2));
								player1.setBank(player1.getBank() + (2 * player1.getBet()));
							} else {
								System.out.println("You win $" + (player1.getBet() * 2));
								player1.setBank(player1.getBank() + (player1.getBet() * 2));
								dealer.setBust(true);
							}
						}
					} else if (dealer.getCard2() != null) {
						System.out.println(dealerCard.toString() + " ("
								+ (dealer.getCard1().getValue() + dealer.getCard2().getValue() + ")" + "\n"));
						// assign the printed value to userCardValueTotal
						dealerCardValueTotal = dealerCardValueTotal
								+ (dealer.getCard1().getValue() + dealer.getCard2().getValue());
						// if userCardValueTotal goes higher than 21, the player loses their bet
						if (dealerCardValueTotal > 21) {
							Thread.sleep(1500);
							System.out.println("Dealer Busts!");
							if (player1.didPlayerDoubledDown() == true) {
								System.out.println("You win $" + (player1.getBet() * 2));
								player1.setBank(player1.getBank() + (2 * player1.getBet()));
							} else {
								System.out.println("You win $" + (player1.getBet() * 2));
								player1.setBank(player1.getBank() + (player1.getBet() * 2));
								dealer.setBust(true);
							}

						}
					}
				}
			} while (dealer.getCardCount() <= 16 && dealer.getBust() == false);
		}
		if (dealer.getBlackJack() == true && player1.getBlackJack() == true) {
			System.out.println("You both were dealt a Black Jack!");
			System.out.println("What are the odds!?");
			System.out.println("This hand was a draw.");
			player1.setBank(player1.getBank() + player1.getBet());
		} else if (dealer.getBlackJack() == true && player1.getBlackJack() == false) {
			System.out.println("Dealer was dealt a Black Jack.");
			System.out.println("Dealer's first card was a " + dealer.getCard1());
			System.out.println("Dealer's second card is a " + dealer.getCard2() + " (" + dealer.getCardCount() + ")");
			player1.setBank(player1.getBank() - player1.getBet());
		} else if (player1.getBlackJack() == true && dealer.getBlackJack() == false) {
			System.out.println("You win $" + (player1.getBet() * 1.67));
			player1.setBank(player1.getBank() + (player1.getBet() * 1.67));
		} else if (dealer.getCardCount() >= 17 && dealer.getCardCount() < 22) {
			Thread.sleep(1500);
			System.out.println("The Dealer stays.");
			if (player1.getCardCount() > dealer.getCardCount()) {
				Thread.sleep(1500);
				if (player1.didPlayerDoubledDown() == true) {
					player1.setBank(player1.getBank() + (4 * player1.getBet()));
				}
				System.out.println("You win $" + (2 * player1.getBet()) + "!");
				player1.setBank(player1.getBank() + (2 * player1.getBet()));// just changed this line
				Thread.sleep(1500);
				System.out.println("You now have $" + player1.getBank());
			} else if (player1.getCardCount() < dealer.getCardCount() && dealer.getCardCount() < 22) {
				Thread.sleep(1500);
				System.out.println("Dealer wins.\n");
				System.out.println("Bank: $" + player1.getBank());
			} else if (player1.getCardCount() == dealer.getCardCount() && player1.didPlayerDoubledDown() == false) {
				Thread.sleep(1500);
				System.out.println("A draw! Your bet was added back into your bank.");
				player1.setBank(player1.getBank() + player1.getBet());
			} else if (player1.getCardCount() == dealer.getCardCount() && player1.didPlayerDoubledDown() == true) {
				Thread.sleep(1500);
				System.out.println("A draw! Your bet was added back into your bank.");
				player1.setBank(player1.getBank() + player1.getBet() * 2);
			}
		}
	}

	protected static void setAceTo1(Card card) {
		card.setValue(1);
	}

	public static boolean playAgain(Player player1, Dealer dealer) throws InterruptedException {
		if (player1.getBank() >= 25) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Play another hand? enter 1 or 2");
			System.out.println("1. Yes");
			System.out.println("2. No");
			int userInput = scanner.nextInt();
			if (userInput == 1) {
				player1.setAceCount(0);
				player1.setBust(false);
				player1.setCardCount(0);
				player1.resetCards();
				player1.setBlackJack(false);
				player1.setFirstRound(true);
				player1.setBet(25);
				player1.setPlayerDoubledDown(false);
				dealer.setAceCount(0);
				dealer.setBust(false);
				dealer.setCardCount(0);
				dealer.resetCards();
				dealer.setBlackJack(false);
				return true;
			}
		} else {
			Thread.sleep(1500);
			System.out.println("Ugh...");
			Thread.sleep(1500);
			System.out.println("You don't have enough to cover another bet!");
		}
		return false;

	}
}
