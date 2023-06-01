package commandandtag;

import commandandnumber.CommandAndNumber;

public class CommandAndTag {
    private final Command command;
    private final Tag tag;

    public CommandAndTag(Command command, Tag tag) {
        this.command = command;
        this.tag = tag;
    }


    public static CommandAndTag from(CommandAndNumber commandAndNumber) {
        Command command = commandAndNumber.getCommand();
        int tagNum = commandAndNumber.getNumber();
        switch (command) {
            case EXECUTE:
                return new CommandAndTag(command, new Tag(tagNum));
            case CREATE:
                return new CommandAndTag(command, AvailableTags.getMinTag());
            default:
                throw new IllegalArgumentException();
        }
    }

    public Tag executeCommand() {
        switch (command) {
            case EXECUTE:
                return tag.execute();
            case CREATE:
                return AvailableTags.getMinTag();
            default:
                throw new IllegalArgumentException();
        }
    }


}
