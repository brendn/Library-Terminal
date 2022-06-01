package co.grandcircus.library.blackjack;

public class Card {
	Rank rank;
	Suit suit;
	private int value;

	public Card(Rank rank, Suit suit) {
		this.rank = rank;
		this.suit = suit;
		if (this.rank == Rank.Ace) {
			this.setValue(11);
		} else if (this.rank == Rank.King) {
			this.setValue(10);
		} else if (this.rank == Rank.Queen) {
			this.setValue(10);
		} else if (this.rank == Rank.Jack) {
			this.setValue(10);
		} else if (this.rank == Rank.Ten) {
			this.setValue(10);
		} else if (this.rank == Rank.Nine) {
			this.setValue(9);
		} else if (this.rank == Rank.Eight) {
			this.setValue(8);
		} else if (this.rank == Rank.Seven) {
			this.setValue(7);
		} else if (this.rank == Rank.Six) {
			this.setValue(6);
		} else if (this.rank == Rank.Five) {
			this.setValue(5);
		} else if (this.rank == Rank.Four) {
			this.setValue(4);
		} else if (this.rank == Rank.Three) {
			this.setValue(3);
		} else if (this.rank == Rank.Two) {
			this.setValue(2);
		} 
	}

	public Rank getRank() {
		return rank;
	}

	public Suit getSuit() {
		return suit;
	}

	public int getValue() {
		return value;
	}

	public void printValue() {
		System.out.println(value);
	}

	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return rank + " of " + suit +"s";
	}
}
