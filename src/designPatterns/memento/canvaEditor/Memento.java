package designPatterns.memento.canvaEditor;

public class Memento {
    private String shape;
    private String color;

    public Memento(String shape, String color) {
        this.shape = shape;
        this.color = color;
    }

    public String getShape() {
        return this.shape;
    }

    public String getColor() {
        return this.color;
    }
}
