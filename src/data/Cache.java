package data;

import game.CardsDeck;
import game.Player;

public class Cache {

  private static Cache instance = null;

  private Player player;
  private CardsDeck deck;

  public static Cache getInstance(){
    if (instance == null)
      instance = new Cache();
    return instance;
  }

  public void setDeck(CardsDeck deck) {
    this.deck = deck;
  }

  public void setPlayer(Player player) {
    this.player = player;
  }

  public CardsDeck getDeck() {
    return deck;
  }

  public Player getPlayer() {
    return player;
  }
}
