package solid.i.bad;

public class MultiPurposePrinter implements Machine{
    @Override
    public void print(String document) {
        System.out.println("Printing document: " + document);
    }

    @Override
    public void fax(String document) {
        System.out.println("Faxing document: " + document);
    }

    @Override
    public void scan(String document) {
        System.out.println("Scanning document: " + document);
    }
}
