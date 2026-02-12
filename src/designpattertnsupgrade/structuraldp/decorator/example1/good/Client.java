package designpattertnsupgrade.structuraldp.decorator.example1.good;

public class Client {
    public static void main(String[] args) {
        TextView textView = new PlainTextView();
        System.out.println("Plain text: " + textView.render());

        textView = new BoldTextView(textView);
        System.out.println("Bold text: " + textView.render());

        textView = new ItalicTextView(textView);
        System.out.println("Italic text: " + textView.render());

        textView = new BoldItalicTextView(textView);
        System.out.println("Bold italic text: " + textView.render());

    }
}
