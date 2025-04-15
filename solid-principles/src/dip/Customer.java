package dip;

public class Customer {
    public Notifier notify;

    public void notify(String email, String subject, String body) {
        notify.notify();
    }

    public void setNotify(Notifier notify) {
        this.notify = notify;
    }
}
