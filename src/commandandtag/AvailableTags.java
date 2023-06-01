package commandandtag;

import java.util.Optional;
import java.util.TreeSet;

public class AvailableTags {
    private static final TreeSet<Tag> availableTags = new TreeSet<>();

    static {
        for (int i = 1; i < 10; i++) {
            availableTags.add(new Tag(i));
        }
    }

    public static Tag getMinTag() {
        Tag minTag = availableTags.pollFirst();
        if (minTag == null) {
            FailHistory.addFailMap(0);
        }
        return minTag;
    }

    public static Tag addTag(Tag tag) {
        if (!availableTags.add(tag)) {
            tag.fail();
        }
        return tag;
    }

    public static void print() {
        System.out.println(availableTags);
    }
}
