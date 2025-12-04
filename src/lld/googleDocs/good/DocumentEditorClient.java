package lld.googleDocs.good;

public class DocumentEditorClient {
    public static void main(String[] args) {
        Document document = new Document();
        RenderDocument renderDocument = new RenderDocument(document);
        Persistence persistence = new SaveToFileStorage();

        DocumentEditor documentEditor = new DocumentEditor(document);
        documentEditor.addText("Hello, World!");
        documentEditor.addImage("/path/to/image.png");

        String renderedContent = renderDocument.renderDocuments();
        System.out.println(renderedContent);
        persistence.save(renderedContent);

    }
}
