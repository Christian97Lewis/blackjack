package game;

import util.Rank;
import util.Suit;

public class Card {

    private Suit mSuit;
    private Rank mRank;

    public Card(Suit suit, Rank rank) {
        this.mSuit = suit;
        this.mRank = rank;
    }

    public Suit getSuit() {
        return mSuit;
    }

    public Rank getRank() {
        return mRank;
    }

    public int getValue() {
        if (mRank.ordinal() <= 8)
            return mRank.ordinal() + 2;
        else if (mRank.ordinal() == 12)
            return 11;
        else
            return 10;
    }

    @Override
    public boolean equals(Object o) {
        return (o != null && o instanceof Card && ((Card) o).mRank == mRank && ((Card) o).mSuit == mSuit);
    }

    @Override
    public String toString() {
        return getRank().name() + " of " + getSuit().name();
    }
}

