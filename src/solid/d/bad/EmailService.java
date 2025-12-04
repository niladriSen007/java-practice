package solid.d.bad;

public class EmailService {
    public void sendEmail(String email, String message) {
        System.out.println("Sending email to: " + email);
        System.out.println("Message: " + message);
    }
}
