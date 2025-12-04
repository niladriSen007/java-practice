package solid.i.bad;

import java.sql.SQLOutput;

public class SimplePrinter implements Machine{


    @Override
    public void print(String document) {
        System.out.println("Printing document: " + document);
    }

    @Override
    public void fax(String document) {
        throw new UnsupportedOperationException("Faxing not supported");
    }

    @Override
    public void scan(String document) {
        throw new UnsupportedOperationException("Scanning not supported");
    }
}
