package designpattertnsupgrade.structuraldp.decorator.example1.good;

public abstract class TextDecorator implements TextView {

    protected TextView textView;

    public TextDecorator(TextView textView) {
        this.textView = textView;
    }

}
