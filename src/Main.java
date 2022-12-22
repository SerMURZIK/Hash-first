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
        String[] listOfWords = text.split("");
        Map<String, Integer> map = new HashMap<>();

        for (String word : listOfWords) {
            if (isLetter(word) || word.equals(" ")) {
                continue;
            }
            if (map.containsKey(word)) {
                int i = map.get(word) + 1;
                map.put(word, i);
            } else {
                map.put(word, 1);
            }
        }

        System.out.println("Максимальное кол-во - " + max(map, listOfWords) + " " + map.get(max(map, listOfWords)));
        System.out.println("Минимальное кол-во - " + min(map, listOfWords) + " " + map.get(min(map, listOfWords)));
    }

    public static boolean isLetter(String aChar) {
        char[] chars = aChar.toCharArray();
        return !Character.isLetter(chars[0]);
    }

    public static String max(Map<String, Integer> map, String[] listOfWords) {
        int maxValue = Integer.MIN_VALUE;
        String maxKey = "";
        for (Map.Entry<String, Integer> word : map.entrySet()) {
            if (!word.getKey().equals(" ") && maxValue < word.getValue()) {
                maxValue = word.getValue();
                maxKey = word.getKey();
            }
        }
        return maxKey;
    }

    public static String min(Map<String, Integer> map, String[] listOfWords) {
        int minValue = Integer.MAX_VALUE;
        String minKey = "";
        for (Map.Entry<String, Integer> word : map.entrySet()) {
            if (!word.getKey().equals(" ") && minValue > word.getValue()) {
                minValue = word.getValue();
                minKey = word.getKey();
            }
        }
        return minKey;
    }
}
