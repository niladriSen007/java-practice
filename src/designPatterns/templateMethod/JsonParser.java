package designPatterns.templateMethod;

public class JsonParser implements ParserTemplate {
    @Override
    public void parser() {
        System.out.println("Parsing JSON data...");
    }
}
