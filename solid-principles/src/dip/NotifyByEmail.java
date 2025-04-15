package dip;

public class NotifyByEmail implements Notifier {
    public String email;
    public String subject;

    @Override
    public void notify(String message) {
        //Imagine to send email
        System.out.println("Email: " + email + " Subject: " + subject + " Body: " + message);
    }
}
