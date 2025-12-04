package lld.googleDocs.good;

import java.util.ArrayList;
import java.util.List;

public class Document {
    private List<DocumentElement> documentElements;

    public Document() {
        this.documentElements = new ArrayList<>();
    }

    void addElement(DocumentElement element) {
        documentElements.add(element);
    }

    public  List<DocumentElement> getDocumentElements(){
        return documentElements;
    }


}
