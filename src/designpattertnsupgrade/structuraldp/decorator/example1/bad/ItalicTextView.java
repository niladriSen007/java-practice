package designpattertnsupgrade.structuraldp.decorator.example1.bad;

public class ItalicTextView implements TextView {
    @Override
    public void render() {
        System.out.println("Rendering italic text");
    }

}
