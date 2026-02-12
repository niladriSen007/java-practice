package designpattertnsupgrade.structuraldp.decorator.example1.good;

public class ItalicTextView extends TextDecorator {
    public ItalicTextView(TextView textView) {
        super(textView);
    }

    @Override
    public String render() {
        return "<i> " + textView.render() + " </i>";
    }

}
