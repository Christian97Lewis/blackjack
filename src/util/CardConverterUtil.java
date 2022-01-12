package util;

import java.util.HashMap;
import java.util.Map;

public class CardConverterUtil {
    private Map<Integer, String> deckConvert = new HashMap<>();

    public void initializeDeckConvert(){
        deckConvert.put(0,"Ace S");
        deckConvert.put(1,"2 S");
        deckConvert.put(2,"3 S");
        deckConvert.put(3,"4 S");
        deckConvert.put(4,"5 S");
        deckConvert.put(5,"6 S");
        deckConvert.put(6,"7 S");
        deckConvert.put(7,"8 S");
        deckConvert.put(8,"9 S");
        deckConvert.put(9,"10 S");
        deckConvert.put(10,"Jack S");
        deckConvert.put(11,"Queen S");
        deckConvert.put(12,"King S");

        deckConvert.put(13,"Ace C");
        deckConvert.put(14,"2 C");
        deckConvert.put(15,"3 C");
        deckConvert.put(16,"4 C");
        deckConvert.put(17,"5 C");
        deckConvert.put(18,"6 C");
        deckConvert.put(19,"7 C");
        deckConvert.put(20,"8 C");
        deckConvert.put(21,"9 C");
        deckConvert.put(22,"10 C");
        deckConvert.put(23,"Jack C");
        deckConvert.put(24,"Queen C");
        deckConvert.put(25,"King C");

        deckConvert.put(26,"Ace D");
        deckConvert.put(27,"2 D");
        deckConvert.put(28,"3 D");
        deckConvert.put(29,"4 D");
        deckConvert.put(30,"5 D");
        deckConvert.put(31,"6 D");
        deckConvert.put(32,"7 D");
        deckConvert.put(33,"8 D");
        deckConvert.put(34,"9 D");
        deckConvert.put(35,"10 D");
        deckConvert.put(36,"Jack D");
        deckConvert.put(37,"Queen D");
        deckConvert.put(38,"King D");

        deckConvert.put(39,"Ace H");
        deckConvert.put(40,"2 H");
        deckConvert.put(41,"3 H");
        deckConvert.put(42,"4 H");
        deckConvert.put(43,"5 H");
        deckConvert.put(44,"6 H");
        deckConvert.put(45,"7 H");
        deckConvert.put(46,"8 H");
        deckConvert.put(47,"9 H");
        deckConvert.put(48,"10 H");
        deckConvert.put(49,"Jack H");
        deckConvert.put(50,"Queen H");
        deckConvert.put(51,"King H");
    }
    public String convertNumberToCard(int i) {
        return deckConvert.get(i);
    }
}
