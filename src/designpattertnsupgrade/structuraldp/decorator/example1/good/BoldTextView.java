package designpattertnsupgrade.structuraldp.decorator.example1.good;

public class BoldTextView extends TextDecorator {
    public BoldTextView(TextView textView) {
        super(textView);
    }

    @Override
    public String render() {
        return "<b> " + textView.render() + " </b>";
    }
}
