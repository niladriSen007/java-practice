package solid.i.good;

public class MultiPurpose implements Printable, Scanable {
    @Override
    public void print() {
        System.out.println("Printing document");
    }

    @Override
    public void scan(String document) {
        System.out.println("Scanning document" + document);
    }
}
