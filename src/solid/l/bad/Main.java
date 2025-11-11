package solid.l.bad;

public class Main {
    public static void main(String[] args) {
        FileSystem fs = new ReadonlyFileSystem();
        fs.write();
    }
}
