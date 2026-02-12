package designpattertnsupgrade.structuraldp.decorator.example1.bad;

public class BoldItalicTextView implements TextView {
    @Override
    public void render() {
        System.out.println("Rendering bold italic text");
    }

}
