package co.grandcircus.library.blackjack;

public class Dealer {
	private Card card1;
	private Card card2;
	private Card card3;
	private Card card4;
	private Card card5;
	private Card card6;
	private int cardCount;
	boolean dealerBust = false;
	private int aceCount;
	boolean blackJack = false;
		
	
	public boolean getBlackJack() {
		return blackJack;
	}
	public void setBlackJack(boolean blackJack) {
		this.blackJack = blackJack;
	}
	public Dealer() {
		
	}
	public Dealer(Card card1, Card card2) {
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
	public int getCardCount() {
		return cardCount;
	}
	public void setCardCount(int cardCount) {
		this.cardCount = cardCount;
	}
	
	public boolean getBust() {
		return dealerBust;
	}

	public void setBust(boolean dealerBust) {
		this.dealerBust = dealerBust;
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
}
