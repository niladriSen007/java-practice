package designPatterns.memento.textEditor;

public class TextEditor {

    private String content;

    public String read() {
        return content;
    }

    public void write(String content) {
        this.content = content;
    }

    //save the current state
    public Memento saveState() {
        Memento memento = new Memento();
        memento.setContent(content);
        return memento;
    }

    // restore the previous state
    public void restoreState(Memento memento) {
        this.content = memento.getContent();
    }
}
