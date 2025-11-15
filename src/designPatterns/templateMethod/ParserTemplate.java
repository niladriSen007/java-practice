package designPatterns.templateMethod;

@FunctionalInterface
public interface ParserTemplate {
    default void openFile(){
        System.out.println("Opening file");
    }

    default void closeFile(){
        System.out.println("Closing file");
    }

    default void parseData(){
        openFile();
        parser();
        closeFile();
    }

    void parser();
}
