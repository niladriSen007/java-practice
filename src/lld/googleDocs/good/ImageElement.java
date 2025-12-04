package lld.googleDocs.good;

public class ImageElement implements  DocumentElement{
    private final String imagePath;

    public ImageElement(String imagePath) {
        this.imagePath = imagePath;
    }

    @Override
    public String render() {
        return STR."<img src='\{imagePath}' />";
    }

}
