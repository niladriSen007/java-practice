package designPatterns.templateMethod;

public class CsvParser implements ParserTemplate {
    @Override
    public void parser() {
        System.out.println("Parsing CSV file");
    }
}
