package designPatterns.memento.textEditor;

import java.util.Stack;

public class History {
    private final Stack<Memento> history = new Stack<>();

    public void saveState(TextEditor textEditor) {
        history.push(textEditor.saveState());
    }

    public void undo(TextEditor textEditor) {
        if (!history.isEmpty()) {
            history.pop();
            textEditor.restoreState(history.peek());
        }
    }
}
