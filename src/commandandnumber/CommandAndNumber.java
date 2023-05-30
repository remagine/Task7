package commandandnumber;

import commandandtag.Command;

public class CommandAndNumber {
    private final Command command;
    private final Integer number;

    public CommandAndNumber(Command command, Integer number) {
        this.command = command;
        this.number = number;
    }

    public Command getCommand() {
        return command;
    }

    public Integer getNumber() {
        return number;
    }
}
