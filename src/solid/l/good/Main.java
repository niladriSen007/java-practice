package solid.l.good;

public class Main {
    public static void main(String[] args) {
        ReadOnlyFile fs = new ReadOnlyFile();
        fs.read();

        ReadAndWriteFile fws = new ReadAndWriteFile();
        fws.read();
        fws.write("Some data");
    }
}
