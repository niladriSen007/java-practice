package solid.s.good;

public class Invoice {
    public int amount;

    public Invoice(int amount){
        this.amount = amount;
    }

    public void generateInvoice(){
        System.out.println("Generating invoice for amount: " + amount);
    }

}
