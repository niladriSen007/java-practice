package lld.googleDocs.good;

import java.util.List;

public class RenderDocument {
    private final Document document;

    public RenderDocument(Document document) {
        this.document = document;
    }

    public String renderDocuments() {
        List<DocumentElement> documentElements = document.getDocumentElements();
        StringBuilder renderedContent = new StringBuilder();
        for (DocumentElement element : documentElements) {
            renderedContent.append(element.render());
        }
        return renderedContent.toString();
    }
}
