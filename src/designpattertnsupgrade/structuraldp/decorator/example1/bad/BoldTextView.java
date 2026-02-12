package designpattertnsupgrade.structuraldp.decorator.example1.bad;

public class BoldTextView implements TextView {
    @Override
    public void render() {
        System.out.println("Rendering bold text");
    }

}
