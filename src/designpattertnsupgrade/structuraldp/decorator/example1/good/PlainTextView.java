package designpattertnsupgrade.structuraldp.decorator.example1.good;

public class PlainTextView implements TextView {

    @Override
    public String render() {
        return "<p> Hello, World! </p>";
    }

}
