package lld.googleDocs.good;

import java.io.FileWriter;

public class SaveToFileStorage implements Persistence {
    @Override
    public void save(String content) {
        FileWriter writer = null;
        try {
            writer = new FileWriter("good_document.txt");
            writer.write(content);
            System.out.println("Document saved to document.txt");
        } catch (Exception e) {
            System.out.println("An error occurred while saving the document: " + e.getMessage());
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (Exception e) {
                System.out.println("An error occurred while closing the file writer: " + e.getMessage());
            }
        }

    }
}
