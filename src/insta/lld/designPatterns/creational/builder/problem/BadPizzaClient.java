package insta.lld.designPatterns.creational.builder.problem;

class BadPizza {
    private final String size;
    private final String crust;
    private final boolean extraCheese;
    private final boolean extraSauce;

    public BadPizza(String size) {
        this(size, null);
    }

    public BadPizza(String size, String crust) {
        this(size, crust, false);
    }

    public BadPizza(String size, String crust, boolean extraCheese) {
        this(size, crust, extraCheese, false);
    }

    public BadPizza(
            String size,
            String crust,
            boolean extraCheese,
            boolean extraSauce
    ) {
        this.size = size;
        this.crust = crust;
        this.extraCheese = extraCheese;
        this.extraSauce = extraSauce;

        System.out.println("Pizza Created: = " +
                "\nsize=" + size +
                ", crust=" + crust +
                ", extraCheese=" + extraCheese +
                ", extraSauce=" + extraSauce);
    }

    // Getter Setter...


}

public class BadPizzaClient {
    public static void main(String[] args) {
        // Client don't want to give crust but due to this code they must give 'null' as they can't skip it
        // ❌ - Bad code
        BadPizza badPizza = new BadPizza("Large", null, false, true);
    }
}
