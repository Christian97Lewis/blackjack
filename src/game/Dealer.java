package game;

import java.util.ArrayList;

public class Dealer {

    private ArrayList<Card> hand;
    private int aceCount;

    public Dealer() {
        hand = new ArrayList<>();
        aceCount = 0;
    }

    public void reset() {
        hand.clear();
        aceCount = 0;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public int getAceCount() {
        return aceCount;
    }

    public void setAceCount(int aceCount) {
        this.aceCount = aceCount;
    }

    public Card dealCard(Card card) {
        hand.add(card);
        if (card.getValue() == 11)
            aceCount++;
        return card;
    }

    public String handToString() {
        StringBuilder sb = new StringBuilder();
        int i;
        for (i = 0;  i < getHand().size(); i++) {
            if (i == 0) {
                sb.append("|        ?        | ");
                continue;
            }
            if (i % 2 == 0)
                sb.append("| " + getHand().get(i) + " | ");
            else
                sb.append(getHand().get(i) + " |\n");
        }
        if (i % 2 == 1) {
            sb.append("                |\n");
        }
        return sb.toString();
    }
    public String handToStringReveal() {
        StringBuilder sb = new StringBuilder();
        int i;
        for (i = 0;  i < getHand().size(); i++) {
            if (i % 2 == 0)
                sb.append("| " + getHand().get(i) + " | ");
            else
                sb.append(getHand().get(i) + " |\n");
        }
        if (i % 2 == 1) {
            sb.append("                |\n");
        }
        return sb.toString();
    }
}
