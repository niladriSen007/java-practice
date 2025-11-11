package designPatterns.memento.canvaEditor;

public class CanvaEditor {
    private String shape;
    private String color;

    public void write(String shape, String color) {
        this.shape = shape;
        this.color = color;
    }

    public String read() {
        return "Shape: " + shape + ", Color: " + color;
    }

    public Memento saveState() {
        return new Memento(shape, color);
    }

    public void undo(Memento memento) {
        this.shape = memento.getShape();
        this.color = memento.getColor();
    }
}
