package commandandtag;

import java.util.concurrent.ConcurrentHashMap;

public class FailHistory {
    private static final ConcurrentHashMap<Tag, Integer> failHistory = new ConcurrentHashMap<>();
}
