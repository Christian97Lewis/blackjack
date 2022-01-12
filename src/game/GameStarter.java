package game;

import data.Cache;

import java.util.Scanner;

public class GameStarter {
    public static void main(String[] args) throws InterruptedException {
        Cache cache = Cache.getInstance();
        Scanner scanner = new Scanner(System.in);
        Dealer dealer = new Dealer();
        Player player = new Player();
        CardsDeck deck = new CardsDeck();
        cache.setDeck(deck);
        cache.setPlayer(player);
        while (true) {
            System.out.println("Welcome to Blackjack! Enter your wager: ");
            System.out.println("Current balance: $" + cache.getPlayer().getMoney());
            String scannerIn = scanner.next();
            if (scannerIn.equals("reset")) {
                cache.getPlayer().changeMoney(100);
                continue;
            }
            int wager = Integer.valueOf(scannerIn);
            if (wager > cache.getPlayer().getMoney())
                continue;
            Game game = new Game(cache.getPlayer(), dealer, cache.getDeck());
            game.playHand(wager);
        }
    }
}
