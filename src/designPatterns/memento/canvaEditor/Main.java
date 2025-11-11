package designPatterns.memento.canvaEditor;

public class Main {
    public static void main(String[] args) {
        History history = new History();
        CanvaEditor canvaEditor = new CanvaEditor();

        canvaEditor.write("Rectangle","Red");
        history.saveState(canvaEditor);

        canvaEditor.write("Circle","Blue");
        history.saveState(canvaEditor);

//        history.undo(canvaEditor);
        System.out.println(canvaEditor.read());
    }
}
