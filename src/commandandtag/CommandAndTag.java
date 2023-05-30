package commandandtag;

import commandandnumber.CommandAndNumber;

public class CommandAndTag {
    private final Command command;
    private final Tag tag;

    public CommandAndTag(Command command, Tag tag) {
        this.command = command;
        this.tag = tag;
    }

    public static Tag getExecuteTag(CommandAndNumber commandAndNumber) {
        Command command = commandAndNumber.getCommand();
        int number = commandAndNumber.getNumber();
        Tag tag;
        switch (command) {
            case EXECUTE:
                tag = new Tag(number);
                break;
            case CREATE:
                tag = AvailableTags.getMinTag();
                break;
            default:
                throw new IllegalArgumentException();
        }

        return tag;
    }

    public void execute() {



    }
}
