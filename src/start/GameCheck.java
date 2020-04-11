package start;

import User.User;

import java.util.HashMap;

public class GameCheck {
    public GameCheck() {
        pattern = new HashMap<>();

        pattern.put(0, "123");
        pattern.put(1, "456");
        pattern.put(2, "789");
        pattern.put(3, "147");
        pattern.put(4, "258");
        pattern.put(5, "369");
        pattern.put(6, "159");
        pattern.put(7, "357");
    }

    private HashMap<Integer, String> pattern;

    public boolean check(User user) {
//        String test = Arrays.toString(IntStream.of(Stream.of(user.getUserChosen().split("")).mapToInt(Integer::valueOf).toArray()).sorted().toArray()).replaceAll("[\\D*]", "");

        for (int i = 0; i < pattern.size(); i++) {
            int temp = 0;

            for (int j = 0; j < pattern.get(i).length(); j++) {
                if (user.getUserChosen().contains(String.valueOf(pattern.get(i).charAt(j)))) {
                    temp++;
                }

                else {
                    break;
                }
            }

            if (temp == 3) {
                return true;
            }
        }

        return false;
    }
}