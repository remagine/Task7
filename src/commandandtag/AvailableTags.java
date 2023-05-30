package commandandtag;

import java.util.concurrent.ConcurrentSkipListSet;

public class AvailableTags {
    private static final ConcurrentSkipListSet<Tag> availableTags = new ConcurrentSkipListSet<>();


    static {
        for (int i = 1; i < 10; i++) {
            availableTags.add(new Tag(i));
        }
    }

    public static Tag execute(CommandAndTag commandAndTag) {
        Command command = commandAndTag.getCommand();
        Tag tag = commandAndTag.getTag();
        Tag doneTag = null;

        switch (command) {
            case CREATE:
                Tag minTag = availableTags.pollFirst();
                if (minTag != null) {
                    doneTag = minTag;
                }
                break;
            case EXECUTE:
                boolean isValidTag = Tag.validateId(tag);
                if (isValidTag && availableTags.add(tag)) {
                    doneTag = tag;
                }
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + command);
        }
        return doneTag;
    }

    public boolean isAvaiableTag(Tag tag) {
        return false;
    }
}
