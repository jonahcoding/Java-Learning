import java.util.*;

/**
 * ----------------------------------------
 * 斗地主：
 *      思路：
 *          1.扑克集合（HashMap），手牌索引+牌
 *          2.手牌索引（ArrayList<Integer>）
 *          3.花色+数字（ArrayList<String>）
 *          4.索引乱序Collections.shuffle();
 *          5.由索引集合判定发牌（底牌）
 *          6.玩家手牌降序
 */
public class LandlordPork {
    public static void main(String[] args) {
        HashMap<Integer, String> poker = new HashMap<Integer, String>();
        ArrayList<Integer> pokerIndex = new ArrayList<>();

        List<String> colors = List.of("♥", "♠", "♣", "♦");
        List<String> numbers = List.of("2", "A", "K", "Q", "J", "10", "9", "8", "7", "6", "5", "4", "3");
        int index = 0;
        poker.put(index, "大王");
        pokerIndex.add(index);
        index++;
        poker.put(index, "小王");
        pokerIndex.add(index);
        index++;
        for (String number : numbers) {
            for (String color : colors) {
                poker.put(index, color + number);
                pokerIndex.add(index);
                index++;
            }
        }
        Collections.shuffle(pokerIndex);
        ArrayList<Integer> Player1 = new ArrayList<>();
        ArrayList<Integer> Player2 = new ArrayList<>();
        ArrayList<Integer> Player3 = new ArrayList<>();
        ArrayList<Integer> HoleCards = new ArrayList<>();
        for (int i = 0; i < pokerIndex.size(); i++) {
            Integer in = pokerIndex.get(i);
            if (i >= 51) {
                HoleCards.add(in);
            } else if (i % 3 == 0) {
                Player1.add(in);
            } else if (i % 3 == 1) {
                Player2.add(in);
            } else if (i % 3 == 2){
                Player3.add(in);
            }
        }
        Collections.sort(Player1);
        Collections.sort(Player2);
        Collections.sort(Player3);
        lookPoker("Zhao Xin", poker, Player1);
        lookPoker("Galen Demacia", poker, Player2);
        lookPoker("Jarvan 4th", poker, Player3);
        lookPoker("Hole Cards", poker, HoleCards);
    }

    public static  void lookPoker(String name, HashMap<Integer, String> poker, ArrayList<Integer> list){
        System.out.print(name+": ");
        for (Integer key : list) {
            String Value = poker.get(key);
            System.out.print(Value + " ");
        }
        System.out.println();
    }
}
