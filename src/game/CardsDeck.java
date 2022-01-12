package game;

import util.Rank;
import util.Suit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/*
    Deck created thanks to https://stackoverflow.com/questions/15942050/deck-of-cards-java
*/
public class CardsDeck {
    private ArrayList<Card> mCards;
    private ArrayList<Card> mPulledCards;
    private Random mRandom;

    public CardsDeck() {
        mRandom = new Random();
        mPulledCards = new ArrayList<Card>();
        mCards = new ArrayList<Card>(Suit.values().length * Rank.values().length);
        reset();
    }

    public void reset() {
        mPulledCards.clear();
        mCards.clear();
        /* Creating all possible  cards... */
        for (Suit s : Suit.values()) {
            for (Rank r : Rank.values()) {
                Card c = new Card(s, r);
                mCards.add(c);
            }
        }
        Collections.shuffle(mCards);
    }

    public ArrayList<Card> getmCards() {
        return mCards;
    }

    public ArrayList<Card> getmPulledCards() {
        return mPulledCards;
    }

    public Card pullRandom() {
        if (mCards.isEmpty())
            return null;
        Card res = mCards.remove(0);
        if (res != null)
            mPulledCards.add(res);
        return res;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (getmCards().size() == 0)
            return "Deck is empty";
        for (Card c : getmCards()) {
            sb.append(c.toString());
            sb.append('\n');
        }
        return sb.toString();
    }
}
