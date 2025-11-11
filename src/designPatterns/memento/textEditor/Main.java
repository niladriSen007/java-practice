package designPatterns.memento.textEditor;

public class Main {
    public static void main(String[] args) {

        History history = new History();

        TextEditor textEditor = new TextEditor();

        textEditor.write("Version 1");
        history.saveState(textEditor);

        textEditor.write("Version 2");
        history.saveState(textEditor);

        history.undo(textEditor);

        System.out.println(textEditor.read());


    }
}
