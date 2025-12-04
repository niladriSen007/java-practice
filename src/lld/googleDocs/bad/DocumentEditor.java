package lld.googleDocs.bad;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DocumentEditor {
    private String renderedDocument;
    private List<String> documentElements;

    DocumentEditor() {
        this.renderedDocument = "";
        this.documentElements = new ArrayList<>();
    }

    static void main() {
        DocumentEditor editor = new DocumentEditor();
        editor.addText("Hello, this is a sample document.");
        editor.addImage("image1.png");
        editor.addText("This is another paragraph.");
        editor.addImage("image2.jpeg");

        String renderedDoc = editor.renderDocument();
        System.out.println("Rendered Document:");
        System.out.println(renderedDoc);

        editor.saveToFile();
    }

    public void addText(String text) {
        documentElements.add(text);
    }

    public void addImage(String imagePath) {
        documentElements.add(imagePath);
    }

    public String renderDocument() {
        if (renderedDocument.isEmpty()) {
            StringBuilder result = new StringBuilder();
            for (String element : documentElements) {
                if (element.length() > 4 && element.endsWith(".png") ||
                        (element.length() > 5 && element.endsWith(".jpeg"))) {
                    result.append("<img src='").append(element).append("' />").append("\n");
                } else {
                    result.append("<p>").append(element).append("</p>").append("\n");
                }
            }
            renderedDocument = result.toString();
        }
        return renderedDocument;
    }

    void saveToFile() {
        try (FileWriter writer = new FileWriter("document.txt")) {
            try {
                // creates/overwrites the file
                writer.write(renderDocument());           // write content
                System.out.println("Document saved to document.txt");
            } catch (IOException e) {
                System.out.println("Error: Unable to open file for writing.");
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
