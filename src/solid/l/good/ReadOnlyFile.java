package solid.l.good;

public class ReadOnlyFile implements Read{

    @Override
    public void read() {
        System.out.println("Reading from file");
    }
}
