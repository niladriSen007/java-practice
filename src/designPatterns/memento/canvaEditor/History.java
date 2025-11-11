package designPatterns.memento.canvaEditor;

import java.util.Stack;

public class History {
    private final Stack<Memento> history = new Stack<>();

    public void saveState(CanvaEditor editor) {
        history.push(editor.saveState());
    }

    public void undo(CanvaEditor editor) {
        if (!history.isEmpty()) {
            history.pop();
            editor.undo(history.peek());
        }
    }
}
