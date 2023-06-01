package commandandtag;

import java.util.concurrent.ConcurrentHashMap;

public class FailHistory {
    private static final ConcurrentHashMap<Tag, Integer> FAIL_HISTORY = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<Integer, Integer> FAIL_MAP = new ConcurrentHashMap<>();

    public static void addFailHistory(Tag tag) {
        Integer failCnt = FAIL_HISTORY.putIfAbsent(tag, 1);
        if (failCnt != null) {
            FAIL_HISTORY.put(tag, ++failCnt);
        }
    }

    public static void print() {
        FAIL_MAP.remove(0);
        System.out.println(FAIL_MAP);
    }

    public static void addFailMap(int number) {
        Integer failCnt = FAIL_MAP.putIfAbsent(number, 1);
        if (failCnt != null) {
            FAIL_MAP.put(number, ++failCnt);
        }
    }

    public static void printCreateFailCnt() {
        int createFailCnt = FAIL_MAP.getOrDefault(0, 0);
        System.out.println(createFailCnt);
    }
}
