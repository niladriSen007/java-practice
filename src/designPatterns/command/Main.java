package designPatterns.command;

public class Main {
    public static void main(String[] args) {

        TextEditor textEditor = new TextEditor();

        Command command = new BoldCommand(textEditor);

        Button button = new Button();
        button.setCommand(command);
        button.press();
    }
}
