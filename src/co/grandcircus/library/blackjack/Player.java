package co.grandcircus.library.blackjack;

public class Player {
	private String name;
	private double bank;
	private double bet;
	private Card card1;
	private Card card2;
	private Card card3;
	private Card card4;
	private Card card5;
	private Card card6;
	private int cardCount;
	private boolean bust = false;
	private boolean blackJack = false; 
	private boolean firstRound = true;
	private boolean playerDoubledDown = false;
	
	
	public boolean didPlayerDoubledDown() {
		return playerDoubledDown;
	}

	public void setPlayerDoubledDown(boolean playerDoubledDown) {
		this.playerDoubledDown = playerDoubledDown;
	}

	public boolean getBlackJack() {
		return blackJack;
	}

	public void setBlackJack(boolean blackJack) {
		this.blackJack = blackJack;
	}

	private int aceCount;

	public boolean getBust() {
		return bust;
	}

	public void setBust(boolean bust) {
		this.bust = bust;
	}

	public Player(String name, double bet) {
		this.name = name;
		this.bank = 100;
		this.bet = bet;
	}
	
	public Player(String name, double bet, Card card1, Card card2) {
		this.name = name;
		this.bet = bet;
		this.card1 = card1;
		this.card2 = card2;
	}
	public Card getCard1() {
		return card1;
	}

	public void setCard1(Card card1) {
		this.card1 = card1;
	}

	public Card getCard2() {
		return card2;
	}

	public void setCard2(Card card2) {
		this.card2 = card2;
	}

	public Card getCard3() {
		return card3;
	}

	public void setCard3(Card card3) {
		this.card3 = card3;
	}

	public Card getCard4() {
		return card4;
	}

	public void setCard4(Card card4) {
		this.card4 = card4;
	}

	public Card getCard5() {
		return card5;
	}

	public void setCard5(Card card5) {
		this.card5 = card5;
	}

	public Card getCard6() {
		return card6;
	}

	public void setCard6(Card card6) {
		this.card6 = card6;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBank() {
		return bank;
	}

	public void setBank(double bank) {
		this.bank = bank;
	}

	public double getBet() {
		return bet;
	}

	public void setBet(double bet) {
		this.bet = bet;
	}
	
	public double playerBet() {
		this.bank = this.bank - this.bet;
		return this.bank;
	}
	

	@Override
	public String toString() {
		return "Player card1=" + card1 + ", card2=" + card2 + "]";
	}

	public int getCardCount() {
		return cardCount;
	}
	
	public void setCardCount(int cardCount) {
		this.cardCount = cardCount;
	}

	public int getAceCount() {
		return aceCount;
	}

	public void setAceCount(int aceCount) {
		this.aceCount = aceCount;
	}
	
	public void resetCards() {
		if (this.card6 != null) {
			this.card6 = null;
		} else if (this.card5 != null) {
			this.card5 = null;
		} else if (this.card4 != null) {
			this.card4 = null;
		} else if (this.card3 != null) {
			this.card3 = null;
		} else if (this.card2 != null) {
			this.card2 = null;
		} else if (this.card1 != null) {
			this.card1 = null;
		}
	}
	
	public int returnValue6() {
		return getCard1().getValue() + getCard2().getValue()
				+ getCard3().getValue() + getCard4().getValue()
				+ getCard5().getValue()	+ getCard6().getValue();
	}
	
	public int returnValue5() {
		return getCard1().getValue() + getCard2().getValue()
				+ getCard3().getValue() + getCard4().getValue()
				+ getCard5().getValue();
	}
	
	public int returnValue4() {
		return getCard1().getValue() + getCard2().getValue()
				+ getCard3().getValue() + getCard4().getValue();
	}
	
	public int returnValue3() {
		return getCard1().getValue() + getCard2().getValue()
				+ getCard3().getValue();
	}
	
	public int returnValue2() {
		return getCard1().getValue() + getCard2().getValue();
		
	}

	public boolean isFirstRound() {
		return firstRound;
	}

	public void setFirstRound(boolean firstRound) {
		this.firstRound = firstRound;
	}
}
