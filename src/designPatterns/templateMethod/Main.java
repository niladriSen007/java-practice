package designPatterns.templateMethod;

public class Main {
    public static void main(String[] args) {
        CsvParser csvParser = new CsvParser();
        JsonParser jsonParser = new JsonParser();

        csvParser.parseData();
        jsonParser.parseData();
    }
}
