package solid.d.bad;

public class Notification {
    private final EmailService emailService;
    private final SmsService smsService;

    public Notification(EmailService emailService, SmsService smsService) {
        this.emailService = emailService;
        this.smsService = smsService;
    }

    public void sendEmailNotification(String email, String message) {
        emailService.sendEmail(email, message);
    }

    public void sendSmsNotification(String phoneNumber, String message) {
        smsService.sendSms(phoneNumber, message);
    }
}
