package game;

import java.util.ArrayList;

public class Player {
    private int money;
    private ArrayList<Card> hand;
    private int aceCount;

    public Player() {
        money = 100;
        hand = new ArrayList<>();
        aceCount = 0;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public void reset() {
        hand.clear();
        aceCount = 0;
    }

    public int getMoney() {
        return money;
    }

    public int getAceCount() {
        return aceCount;
    }

    public void setAceCount(int aceCount) {
        this.aceCount = aceCount;
    }

    public void changeMoney(int winnings) {
        this.money = money + winnings;
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
