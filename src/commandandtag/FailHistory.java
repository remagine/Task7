package commandandtag;

import java.util.concurrent.ConcurrentHashMap;

public class FailHistory {
    private static final ConcurrentHashMap<Tag, Integer> failHistory = new ConcurrentHashMap<>();

    public static void addFailHistory(Tag tag) {
        Integer failCnt = failHistory.putIfAbsent(tag, 1);
        if(failCnt != null){
            failHistory.put(tag, ++failCnt);
        }
    }

    public static int getCreateFailCnt() {
        return failHistory.getOrDefault(0,0);
    }


    public static void print() {
        System.out.println(failHistory);
    }
}
