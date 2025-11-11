package solid.l.good;

public class ReadAndWriteFile extends ReadOnlyFile implements Write {

    @Override
    public void write(String data) {
        System.out.println("Writing data: " + data);
    }
}
