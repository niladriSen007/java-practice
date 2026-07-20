package insta.lld.designPatterns.creational.builder.solution;

class GoodPizza {
    private final String size; //  main required parameter
    private final String crust;
    private final boolean extraCheese;
    private final boolean extraSauce;

    private GoodPizza(Builder builder) {
        this.size = builder.size;
        this.crust = builder.crust;
        this.extraCheese = builder.extraCheese;
        this.extraSauce = builder.extraSauce;
    }

    static class Builder {
        private final String size; //  main required parameter
        private String crust;
        private boolean extraCheese;
        private boolean extraSauce;

        public Builder(String size) {
            this.size = size;
        }

        public Builder crust(String crust) {
            this.crust = crust;
            return this;
        }

        public Builder extraCheese(boolean extraCheese) {
            this.extraCheese = extraCheese;
            return this;
        }

        public Builder extraSauce(boolean extraSauce) {
            this.extraSauce = extraSauce;
            return this;
        }

        public GoodPizza build() {
            return new GoodPizza(this);
        }
    }
}

public class GoodPizzaClient {
    public static void main(String[] args) {
        // Client only give those which they want , here only Size and ExtraCheese
        GoodPizza goodPizza = new GoodPizza.Builder("Large").extraSauce(true).build();
    }
}
