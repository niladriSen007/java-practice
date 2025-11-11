package solid.s.bad;

public class Invoice {
    public int amount;

    public Invoice(int amount){
        this.amount = amount;
    }

    public void generateInvoice(){
        System.out.println("Generating invoice for amount: " + amount);
    }

    public void sendEmail(String email){
        System.out.println("Sending invoice to email: " + email);
    }

    public void saveToDatabase(){
        System.out.println("Saving invoice to database");
    }
}
