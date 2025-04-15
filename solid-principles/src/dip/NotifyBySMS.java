package dip;

public class NotifyBySMS implements Notifier{
    public String phone;

    @Override
    public void notify(String message) {
        //Implement send SMS
        System.out.println("Phone: " + phone + " Message: " + message);
    }
}
