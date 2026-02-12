package designpattertnsupgrade.structuraldp.decorator.example1.good;

public class BoldItalicTextView extends TextDecorator {
    public BoldItalicTextView(TextView textView) {
        super(textView);
    }

    @Override
    public String render() {
        return "<b><i> " + textView.render() + " </i></b>";
    }

}
