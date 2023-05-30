package commandandtag;

import commandandnumber.CommandAndNumber;

import java.util.Objects;
import java.util.Optional;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentSkipListSet;

public class AvailableTags {
    private static final TreeSet<Tag> availableTags = new TreeSet<>();

    static {
        for (int i = 1; i < 10; i++) {
            availableTags.add(new Tag(i));
        }
    }

    public static Tag getMinTag() {
        return Optional.ofNullable(availableTags.pollFirst())
                .orElse(new Tag(0));
    }

    public static void addTag(Tag tag) {
        if (!availableTags.add(tag)) {
            tag.fail();
        }
    }

    public static void print() {
        System.out.println(availableTags);
    }
}
