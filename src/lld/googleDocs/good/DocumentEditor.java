package lld.googleDocs.good;

public class DocumentEditor {
    private final Document document;

    public DocumentEditor(Document document) {
        this.document = document;
    }

    void addText(String text) {
        document.addElement(new TextElement(text));
        document.addElement(new NewLineElement());
    }

    void addImage(String imagePath) {
        document.addElement(new ImageElement(imagePath));
        document.addElement(new NewLineElement());
    }

}
