import java.util.HashMap;
import java.util.Map;

public class Main {
    static String text = "Lorem ipsum dolor sit amet, " +
            "consectetur adipiscing elit, sed do " +
            "eiusmod tempor incididunt ut labore et dolore" +
            " magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation" +
            " ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis" +
            " aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat" +
            " nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui" +
            " officia deserunt mollit anim id est laborum.";

    public static void main(String[] args) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < text.length(); i++) {
            char word = text.charAt(i);
            if (isLetter(word) || word == ' ') {
                continue;
            }
            if (map.containsKey(word)) {
                int j = map.get(word) + 1;
                map.put(word, j);
            } else {
                map.put(word, 1);
            }
        }

        System.out.println("Максимальное кол-во - " + max(map, text) + " " + map.get(max(map, text)));
        System.out.println("Минимальное кол-во - " + min(map, text) + " " + map.get(min(map, text)));
    }

    public static boolean isLetter(char aChar) {
        return !Character.isLetter(aChar);
    }

    public static char max(Map<Character, Integer> map, String text) {
        int maxValue = Integer.MIN_VALUE;
        char maxKey = 0;
        for (Map.Entry<Character, Integer> word : map.entrySet()) {
            if (maxValue < word.getValue()) {
                maxValue = word.getValue();
                maxKey = word.getKey();
            }
        }
        return maxKey;
    }

    public static char min(Map<Character, Integer> map, String text) {
        int minValue = Integer.MAX_VALUE;
        char minKey = 0;
        for (Map.Entry<Character, Integer> word : map.entrySet()) {
            if (minValue > word.getValue()) {
                minValue = word.getValue();
                minKey = word.getKey();
            }
        }
        return minKey;
    }
}