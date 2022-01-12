package game;

import data.Cache;
import util.CardConverterUtil;

import java.util.Scanner;

public class Game {

    Player player;
    Dealer dealer;
    CardsDeck deck;
    public Game(Player player, Dealer dealer, CardsDeck deck) {
        this.player = player;
        this.dealer = dealer;
        this.deck = deck;
    }
    public void playHand(int wager) throws InterruptedException {
        Cache cache = Cache.getInstance();
        if (deck.getmCards().size() < 20){
            System.out.println("Shuffling deck!");
            deck.reset();
        }
        CardConverterUtil cardConverterUtil = new CardConverterUtil();
        cardConverterUtil.initializeDeckConvert();

        boolean playerBusted = false;

        player.dealCard(deck.pullRandom());
        dealer.dealCard(deck.pullRandom());
        player.dealCard(deck.pullRandom());
        dealer.dealCard(deck.pullRandom());

        int playerCount = 0;
        playerCount += player.getHand().get(0).getValue() + player.getHand().get(1).getValue();
        int dealerCount = 0;
        dealerCount += dealer.getHand().get(0).getValue() + dealer.getHand().get(1).getValue();



        System.out.println("+-------------------------------------+");
        System.out.println("|             Dealer Hand (?)         |");
        System.out.print(dealer.handToString());
        System.out.println("|              Your Hand  ("+ playerCount +")         |");
        System.out.print(player.handToString());
        System.out.println("+-------------------------------------+");


        if (playerCount == 21 && dealerCount != 21) {
            System.out.println("Blackjack! You win");
            System.out.println("Your earnings: $" + wager * 1.5);
            cache.getPlayer().changeMoney((int)(wager*1.5));
        } else if (playerCount == 21 && dealerCount == 21) {
            System.out.println("Push");
        } else if (playerCount != 21 && dealerCount == 21) {
            System.out.println("+-------------------------------------+");
            System.out.println("|             Dealer Hand ("+ dealerCount +")          |");
            System.out.print(dealer.handToStringReveal());
            System.out.println("|              Your Hand ("+ playerCount +")             |");
            System.out.print(player.handToString());
            System.out.println("+-------------------------------------+");
            // TODO: Insurance
            System.out.println("You lost $" + wager);
            cache.getPlayer().changeMoney(-wager);

        } else {
            System.out.println("Press 1 to hit, press 2 to stay");
            Scanner s = new Scanner(System.in);
            while(s.next().equals("1")) {
                Card nextCard = player.dealCard(deck.pullRandom());
                playerCount += nextCard.getValue();
                System.out.println("+-------------------------------------+");
                System.out.println("|             Dealer Hand             |");
                System.out.print(dealer.handToString());
                System.out.println("|              Your Hand ("+ playerCount +")             |");
                System.out.print(player.handToString());
                System.out.println("+-------------------------------------+");
                if (playerCount > 21) {
                    if (player.getAceCount() > 0) {
                        player.setAceCount(player.getAceCount() - 1);
                        playerCount -= 10;
                    }
                    else {
                        Thread.sleep(2000);
                        System.out.println("Bust! You lose.");
                        System.out.println("You lost $" + wager);
                        cache.getPlayer().changeMoney(-wager);
                        playerBusted = true;
                        break;
                    }
                }
                System.out.println("Press 1 to hit, press 2 to stay");
            }
            if (playerBusted) {
                dealer.reset();
                player.reset();
                return;
            }
            System.out.println("+-------------------------------------+");
            System.out.println("|             Dealer Hand ("+ dealerCount +")          |");
            System.out.print(dealer.handToStringReveal());
            System.out.println("|              Your Hand ("+ playerCount +")             |");
            System.out.print(player.handToString());
            System.out.println("+-------------------------------------+");
            Thread.sleep(2000);

            if (dealerCount >= 17) {
                if (dealerCount > playerCount) {
                    System.out.println("You lose.");
                    System.out.println("You lost $" + wager);
                    cache.getPlayer().changeMoney(-wager);
                } else if (dealerCount == playerCount){
                    System.out.println("Push.");
                } else {
                    System.out.println("You win.");
                    System.out.println("Your earnings: $" + wager);
                    cache.getPlayer().changeMoney(wager);
                }
            }
            while (dealerCount < 17) {
                Card nextCard = dealer.dealCard(deck.pullRandom());
                dealerCount += nextCard.getValue();
                System.out.println("+-------------------------------------+");
                System.out.println("|             Dealer Hand ("+ dealerCount +")          |");
                System.out.print(dealer.handToStringReveal());
                System.out.println("|              Your Hand ("+ playerCount +")             |");
                System.out.print(player.handToString());
                System.out.println("+-------------------------------------+");
                Thread.sleep(2000);
                if (dealerCount > 21) {
                    if (dealer.getAceCount() > 0) {
                        dealer.setAceCount(dealer.getAceCount() - 1);
                        dealerCount -= 10;
                    } else{
                        System.out.println("Dealer busted, you win!");
                        System.out.println("Your earnings: $" + wager);
                        cache.getPlayer().changeMoney(wager);
                    }
                } else if (dealerCount >= 17) {
                    if (dealerCount > playerCount) {
                        System.out.println("You lose.");
                        System.out.println("You lost $" + wager);
                        cache.getPlayer().changeMoney(-wager);
                    } else if (dealerCount == playerCount){
                        System.out.println("Push.");
                    } else {
                        System.out.println("You win.");
                        System.out.println("Your earnings: $" + wager);
                        cache.getPlayer().changeMoney(wager);
                    }
                }
            }
        }

        player.reset();
        dealer.reset();
    }
}
