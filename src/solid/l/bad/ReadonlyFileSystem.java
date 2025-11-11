package solid.l.bad;

public class ReadonlyFileSystem extends FileSystem {
    public void write() {
        throw new UnsupportedOperationException("Unsupported Operation");
    }
}
