package designpattertnsupgrade.behaviouraldp.command.good;

import java.util.Stack;

public class RemoteController {
    private Command currentCommand;
    private final Stack<Command> commandHistory;

    public RemoteController() {
        this.commandHistory = new Stack<>();
    }

    public void setCommand(Command command) {
        this.currentCommand = command;
    }

    public void press() {
        if (this.currentCommand != null) {
            currentCommand.execute();
            commandHistory.push(currentCommand);
        } else {
            System.out.println("No command set");
        }
    }

    public void undoLast() {
        if (!commandHistory.isEmpty()) {
            Command lastCommand = commandHistory.pop();
            lastCommand.undo();
        } else {
            System.out.println("No command to undo");
        }
    }
}
